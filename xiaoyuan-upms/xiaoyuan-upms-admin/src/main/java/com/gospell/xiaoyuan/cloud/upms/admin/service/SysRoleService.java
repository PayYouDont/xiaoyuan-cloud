package com.gospell.xiaoyuan.cloud.upms.admin.service;

import com.gospell.xiaoyuan.cloud.common.data.jpa.base.BaseService;
import com.gospell.xiaoyuan.cloud.upms.common.entity.SysRole;

import java.util.List;

/**
 * description: SysUserService <br>
 * date: 2020/12/31 15:54 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */

public interface SysRoleService extends BaseService<SysRole> {

    List<SysRole> findAllByUserId(Long userId);

    void deleteById(Long id);

    SysRole getAdmin();

    void saveRoleMenus(String roleCode, Long roleId, String menuIds);
}
