package com.gospell.xiaoyuan.cloud.upms.admin.repository;

import com.gospell.xiaoyuan.cloud.common.data.jpa.base.BaseRepository;
import com.gospell.xiaoyuan.cloud.upms.common.entity.SysOrgan;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * description: SysUserRepository <br>
 * date: 2020/12/31 15:11 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */
public interface SysOrganRepository extends BaseRepository<SysOrgan> {
    /**
     * description: 根据id查询某部门和其子部门 <br>
     * version: 1.0 <br>
     * date: 2021/1/19 16:46 <br>
     * author: pay <br>
     *
     * @param parentId
     * @return java.util.List<com.gospell.xiaoyuan.cloud.upms.common.entity.SysOrgan>
     */
    @Query("select so from SysOrgan so where so.parentId=?1 or so.id=?1")
    List<SysOrgan> findAllChildren(Long parentId);
}
