package com.gospell.xiaoyuan.cloud.upms.admin.repository;

import com.gospell.xiaoyuan.cloud.common.data.jpa.base.BaseRepository;
import com.gospell.xiaoyuan.cloud.upms.common.entity.SysRole;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * description: SysUserRepository <br>
 * date: 2020/12/31 15:11 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */
public interface SysRoleRepository extends BaseRepository<SysRole> {

    @Query("select sr from SysRole as sr join SysUserRole sur on sr.id=sur.roleId where sur.userId =?1")
    List<SysRole> findAllByUserId(Long userId);

    SysRole findByRoleCode(String roleCode);
}
