package com.gospell.xiaoyuan.cloud.upms.admin.service;

import com.gospell.xiaoyuan.cloud.common.data.jpa.base.BaseService;
import com.gospell.xiaoyuan.cloud.upms.common.entity.SysMenu;

import java.util.List;

/**
 * description: SysUserService <br>
 * date: 2020/12/31 15:54 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */

public interface SysMenuService extends BaseService<SysMenu> {

    List<SysMenu> findAllByRoleId(Long roleId);

    List<SysMenu> findAllByParentId(Long parentId);

    void deleteById(Long id);

    List<SysMenu> findMenuByRoleId(Long roleId);

}
