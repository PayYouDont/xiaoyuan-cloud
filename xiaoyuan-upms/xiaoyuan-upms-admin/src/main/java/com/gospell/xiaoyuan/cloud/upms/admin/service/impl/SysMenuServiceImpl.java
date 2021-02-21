package com.gospell.xiaoyuan.cloud.upms.admin.service.impl;

import com.gospell.xiaoyuan.cloud.common.data.jpa.base.BaseServiceImpl;
import com.gospell.xiaoyuan.cloud.upms.admin.repository.SysMenuRepository;
import com.gospell.xiaoyuan.cloud.upms.admin.repository.SysRoleMenuRepository;
import com.gospell.xiaoyuan.cloud.upms.admin.service.SysMenuService;
import com.gospell.xiaoyuan.cloud.upms.common.entity.SysMenu;
import com.gospell.xiaoyuan.cloud.upms.common.entity.SysRoleMenu;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * description: SysMenuServiceImpl <br>
 * date: 2021/1/6 19:46 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */
@Service
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenu> implements SysMenuService {
    private final SysMenuRepository repository;
    @Resource
    private SysRoleMenuRepository roleMenuRepository;

    public SysMenuServiceImpl(SysMenuRepository repository) {
        super (repository);
        this.repository = repository;
    }

    @Override
    public List<SysMenu> findAllByRoleId(Long roleId) {
        return repository.findAllByRoleId (roleId);
    }

    @Override
    public List<SysMenu> findAllByParentId(Long parentId) {
        return null;
    }


    @Override
    public void deleteById(Long id) {
        repository.deleteById (id);
    }

    @Override
    public List<SysMenu> findMenuByRoleId(Long roleId) {
        return repository.findAllByRoleId (roleId);
    }

    @Override
    public void add(SysMenu entity) {
        Long roleId = entity.getRoleId ();
        super.add (entity);
        if (roleId != null) {
            SysRoleMenu sysRoleMenu = new SysRoleMenu ();
            sysRoleMenu.setRoleId (roleId);
            sysRoleMenu.setMenuId (entity.getId ());
            roleMenuRepository.save (sysRoleMenu);
        }
    }
}
