package com.gospell.xiaoyuan.cloud.upms.admin.repository;

import com.gospell.xiaoyuan.cloud.common.data.jpa.base.BaseRepository;
import com.gospell.xiaoyuan.cloud.upms.common.entity.SysUser;

import java.util.Optional;

/**
 * description: SysUserRepository <br>
 * date: 2020/12/31 15:11 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */
public interface SysUserRepository extends BaseRepository<SysUser> {
    Optional<SysUser> findByUsername(String username);


    /*@Query(value = "select * from sys_user su left join sys_organ so on so.id=su.organ_id " +
            "where su.username like concat('%',?1,'%') " +
            "and so.id in (select sou.ancestor from sys_organ_user sou where sou.ancestor=?2)",nativeQuery = true)
    List<UserVO> findUserVOAll(String username,Long organId);

    @Query(value = "select * from sys_user su left join sys_organ so on so.id=su.organ_id",nativeQuery = true)
    List<UserVO> findUserVOAll();*/
}
