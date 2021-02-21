package com.gospell.xiaoyuan.cloud.upms.admin.repository;

import com.gospell.xiaoyuan.cloud.common.data.jpa.base.BaseRepository;
import com.gospell.xiaoyuan.cloud.upms.common.entity.SysDict;

import java.util.List;

/**
 * description: SysUserRepository <br>
 * date: 2020/12/31 15:11 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */
public interface SysDictRepository extends BaseRepository<SysDict> {

    List<SysDict> findAllByType(String type);
}
