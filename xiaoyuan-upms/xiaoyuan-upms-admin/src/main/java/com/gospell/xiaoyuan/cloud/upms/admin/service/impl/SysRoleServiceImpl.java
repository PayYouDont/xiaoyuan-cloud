package com.gospell.xiaoyuan.cloud.upms.admin.service.impl;

import com.gospell.xiaoyuan.cloud.common.core.constant.CacheConstants;
import com.gospell.xiaoyuan.cloud.common.core.constant.CommonConstants;
import com.gospell.xiaoyuan.cloud.common.data.jpa.base.BaseServiceImpl;
import com.gospell.xiaoyuan.cloud.upms.admin.repository.SysRoleMenuRepository;
import com.gospell.xiaoyuan.cloud.upms.admin.repository.SysRoleRepository;
import com.gospell.xiaoyuan.cloud.upms.admin.service.SysRoleService;
import com.gospell.xiaoyuan.cloud.upms.common.entity.SysRole;
import com.gospell.xiaoyuan.cloud.upms.common.entity.SysRoleMenu;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * description: SysRoleServiceImpl <br>
 * date: 2021/1/6 19:15 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */
@Service
public class SysRoleServiceImpl extends BaseServiceImpl<SysRole> implements SysRoleService {
    private final SysRoleRepository repository;
    @Resource
    private SysRoleMenuRepository roleMenuRepository;
    @Resource
    private CacheManager cacheManager;
    public SysRoleServiceImpl(SysRoleRepository repository) {
        super (repository);
        this.repository = repository;
    }

    @Override
    public List<SysRole> findAllByUserId(Long userId) {
        return repository.findAllByUserId (userId);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById (id);
    }

    @Override
    public SysRole getAdmin() {
        return repository.findByRoleCode (CommonConstants.ROLE_CODE_ADMIN);
    }

    @Override
    public void saveRoleMenus(String roleCode, Long roleId, String menuIds) {
        roleMenuRepository.deleteAllByRoleId (roleId);
        List<SysRoleMenu> roleMenuList = Arrays.stream(menuIds.split(","))
                .map(menuId -> {
                    SysRoleMenu roleMenu = new SysRoleMenu();
                    roleMenu.setRoleId(roleId);
                    roleMenu.setMenuId(Long.valueOf (menuId));
                    return roleMenu;
                }).collect(Collectors.toList());
        //清空userinfo
        Objects.requireNonNull (cacheManager.getCache (CacheConstants.USER_CACHE)).clear();
        roleMenuRepository.saveAll (roleMenuList);
    }
}
