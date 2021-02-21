package com.gospell.xiaoyuan.cloud.upms.admin.service;

import com.gospell.xiaoyuan.cloud.common.data.jpa.base.BaseService;
import com.gospell.xiaoyuan.cloud.upms.common.entity.SysDictValue;

import java.util.List;

/**
 * description: SysDictService <br>
 * date: 2020/12/31 15:54 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */

public interface SysDictValueService extends BaseService<SysDictValue> {
    List<SysDictValue> findByType(String type);
}
