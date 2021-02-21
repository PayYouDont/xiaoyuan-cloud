package com.gospell.xiaoyuan.cloud.upms.admin.repository;

import com.gospell.xiaoyuan.cloud.common.data.jpa.base.BaseRepository;
import com.gospell.xiaoyuan.cloud.upms.common.entity.SysMenu;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * description: SysUserRepository <br>
 * date: 2020/12/31 15:11 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */
public interface SysMenuRepository extends BaseRepository<SysMenu> {

    @Query("select sm from SysMenu as sm join SysRoleMenu srm on sm.id=srm.menuId where srm.roleId =?1")
    List<SysMenu> findAllByRoleId(Long roleId);
}
