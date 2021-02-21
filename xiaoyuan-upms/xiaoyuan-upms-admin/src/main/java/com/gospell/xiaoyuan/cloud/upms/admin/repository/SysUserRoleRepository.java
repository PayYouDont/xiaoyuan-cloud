package com.gospell.xiaoyuan.cloud.upms.admin.repository;

import com.gospell.xiaoyuan.cloud.common.data.jpa.base.BaseRepository;
import com.gospell.xiaoyuan.cloud.upms.common.entity.SysUserRole;

import javax.transaction.Transactional;
import java.util.List;

/**
 * description: SysUserRepository <br>
 * date: 2020/12/31 15:11 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */
public interface SysUserRoleRepository extends BaseRepository<SysUserRole> {

    SysUserRole findByUserIdAndRoleId(Long userId,Long roleId);

    List<SysUserRole> findAllByRoleId(Long roleId);

    @Transactional
    void deleteAllByUserId(Long userId);

}
