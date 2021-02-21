package com.gospell.xiaoyuan.cloud.upms.admin.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ArrayUtil;
import com.gospell.xiaoyuan.cloud.common.core.constant.CacheConstants;
import com.gospell.xiaoyuan.cloud.common.core.constant.CommonConstants;
import com.gospell.xiaoyuan.cloud.common.data.jpa.base.BaseServiceImpl;
import com.gospell.xiaoyuan.cloud.common.data.jpa.base.JpaEntity;
import com.gospell.xiaoyuan.cloud.upms.admin.repository.SysOrganRepository;
import com.gospell.xiaoyuan.cloud.upms.admin.repository.SysUserRepository;
import com.gospell.xiaoyuan.cloud.upms.admin.repository.SysUserRoleRepository;
import com.gospell.xiaoyuan.cloud.upms.admin.service.SysMenuService;
import com.gospell.xiaoyuan.cloud.upms.admin.service.SysRoleService;
import com.gospell.xiaoyuan.cloud.upms.admin.service.SysUserService;
import com.gospell.xiaoyuan.cloud.upms.common.dto.UserDTO;
import com.gospell.xiaoyuan.cloud.upms.common.dto.UserInfo;
import com.gospell.xiaoyuan.cloud.upms.common.entity.*;
import com.gospell.xiaoyuan.cloud.upms.common.vo.UserVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.stream.Collectors;

/**
 * description: SysUserServiceImpl <br>
 * date: 2020/12/31 15:55 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser> implements SysUserService {
    private final SysUserRepository repository;
    @Resource
    private SysRoleService roleService;
    @Resource
    private SysMenuService menuService;
    @Resource
    private SysUserRoleRepository userRoleRepository;
    @Resource
    private SysOrganRepository organRepository;

    private static final PasswordEncoder ENCODER = new BCryptPasswordEncoder ();

    public SysUserServiceImpl(SysUserRepository repository) {
        super (repository);
        this.repository = repository;
    }

    @Override
    public SysUser findByUsername(String username) {
        Optional<SysUser> sysUser = repository.findByUsername (username);
        return sysUser.orElse (null);
    }

    @Override
    public UserInfo findUserInfo(SysUser sysUser) {
        UserInfo userInfo = new UserInfo ();
        userInfo.setSysUser (sysUser);
        //设置角色列表  （ID）
        List<SysRole> sysRoles = roleService.findAllByUserId (sysUser.getId ());
        List<Long> roleIds = sysRoles.stream ().map (SysRole::getId).collect (Collectors.toList ());
        userInfo.setRoles (ArrayUtil.toArray (roleIds, Long.class));
        //设置权限列表（menu.permission）
        Set<String> permissions = new HashSet<> ();
        sysRoles.forEach (sysRole -> {
            List<SysMenu> sysMenuList = menuService.findAllByRoleId (sysRole.getId ());
            List<String> permissionList = sysMenuList.stream ()
                    .map (SysMenu::getPermission)
                    .filter (StringUtils::isNotEmpty)
                    .collect (Collectors.toList ());
            permissions.addAll (permissionList);
        });
        userInfo.setPermissions (ArrayUtil.toArray (permissions, String.class));

        return userInfo;
    }

    @Override
    public void add(SysUser sysUser) {
        if (sysUser != null && sysUser.getPassword () != null) {
            sysUser.setPassword (ENCODER.encode (sysUser.getPassword ()));
            super.add (sysUser);
        }
    }

    @Override
    public void updateUser(UserDTO userDto) {
        //查询出管理员角色，判断管理员角色是否至少有1个用户
        SysRole adminRole = roleService.getAdmin ();
        if (!CollUtil.contains (userDto.getRoleIds (), adminRole.getId ())) {
            List<SysUserRole> adminUserRoles = userRoleRepository.findAllByRoleId (adminRole.getId ());
            if (adminUserRoles.size () <= 1) {//只有一条记录，判断是否当前用户拥有
                SysUserRole sysUserRole = userRoleRepository.findByUserIdAndRoleId (userDto.getId (), adminRole.getId ());
                Assert.isNull (sysUserRole, "至少需要一个用户拥有管理员角色");
            }
        }
        save (userDto);
    }

    @CacheEvict(value = CacheConstants.USER_CACHE, key = "#userDto.username")
    @Transactional(rollbackFor = Exception.class)
    public void save(UserDTO userDto) {
        SysUser sysUser = new SysUser ();
        BeanUtils.copyProperties (userDto, sysUser);
        sysUser.setPassword (null);
        repository.save (sysUser);

        userRoleRepository.deleteAllByUserId (userDto.getId ());
        userDto.getRoleIds ().forEach (roleId -> {
            SysUserRole userRole = new SysUserRole ();
            userRole.setUserId (sysUser.getId ());
            userRole.setRoleId (roleId);
            userRoleRepository.save (userRole);
        });
    }

    @Override
    public void deleteById(Long id) {
        SysRole adminRole = roleService.getAdmin ();
        SysUserRole sysUserRole = userRoleRepository.findByUserIdAndRoleId (id, adminRole.getId ());
        Assert.isNull (sysUserRole, "无法删除拥有管理员角色的用户");
        super.deleteById (id);
    }

    @Override
    public Page<UserVO> getUsersWithRolePage(@NotNull(message = "当前分页数不能为空") Integer pageIndex,
                                             @NotNull(message = "每页数量不能为空") Integer pageSize,
                                             UserDTO userDTO) {
        List<Predicate> predicates = new ArrayList<> ();
        Page<SysUser> userPage = repository.findAll ((root, query, criteriaBuilder) -> {
            if (StringUtils.isNotEmpty (userDTO.getUsername ())) {
                predicates.add (criteriaBuilder.like (root.get ("username"), "%" + userDTO.getUsername () + "%"));
            }
            if (userDTO.getOrganId () != null) {
                /*List<Long> descendants = organRelationService.findAllByAncestor (userDTO.getOrganId ()).stream ()
                        .map (SysOrganRelation::getDescendant).collect (Collectors.toList ());*/
                List<Long> descendants = organRepository.findAllChildren (userDTO.getOrganId ()).stream ()
                        .map (JpaEntity::getId).collect (Collectors.toList ());
                predicates.add (root.get ("organId").in (descendants));
            }
            return criteriaBuilder.and (ArrayUtil.toArray (predicates, Predicate.class));
        }, PageRequest.of (pageIndex, pageSize));
        List<SysUser> userList = userPage.getContent ();
        List<UserVO> userVOList = new ArrayList<> ();
        userList.forEach (sysUser -> {
            UserVO userVO = new UserVO ();
            BeanUtils.copyProperties (sysUser, userVO);
            SysOrgan sysOrgan = organRepository.findById (sysUser.getOrganId ()).orElse (null);
            if (sysOrgan != null) {
                userVO.setOrganName (sysOrgan.getName ());
            }
            List<SysRole> sysRoles = roleService.findAllByUserId (sysUser.getId ());
            userVO.setRoleList (sysRoles);
            List<Long> roleIds = sysRoles.stream ().map (SysRole::getId).collect (Collectors.toList ());
            userVO.setRoleIds (roleIds);
            userVOList.add (userVO);
        });
        return new PageImpl<> (userVOList, userPage.getPageable (), userPage.getTotalElements ());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveUser(UserDTO userDto) {
        SysUser sysUser = new SysUser ();
        BeanUtils.copyProperties (userDto, sysUser);
        sysUser.setDelFlag (CommonConstants.STATUS_NORMAL);
        sysUser.setPassword (ENCODER.encode (userDto.getPassword ()));
        add (sysUser);
        //保存用户角色关系
        List<SysUserRole> userRoleList = userDto.getRoleIds ()
                .stream ().map (roleId -> {
                    SysUserRole userRole = new SysUserRole ();
                    userRole.setUserId (sysUser.getId ());
                    userRole.setRoleId (roleId);
                    return userRole;
                }).collect (Collectors.toList ());
        userRoleRepository.saveAll (userRoleList);
        //保存用户部门关系
        userDto.getOrganId ();
    }
}
