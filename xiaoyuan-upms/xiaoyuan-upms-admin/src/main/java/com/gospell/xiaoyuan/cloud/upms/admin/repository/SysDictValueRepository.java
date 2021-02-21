package com.gospell.xiaoyuan.cloud.upms.admin.repository;

import com.gospell.xiaoyuan.cloud.common.data.jpa.base.BaseRepository;
import com.gospell.xiaoyuan.cloud.upms.common.entity.SysDictValue;

import java.util.List;

/**
 * description: SysUserRepository <br>
 * date: 2020/12/31 15:11 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */
public interface SysDictValueRepository extends BaseRepository<SysDictValue> {

    List<SysDictValue> findAllByType(String type);
}
