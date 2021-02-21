package com.gospell.xiaoyuan.cloud.upms.admin.service;

import com.gospell.xiaoyuan.cloud.common.data.jpa.base.BaseService;
import com.gospell.xiaoyuan.cloud.upms.common.entity.SysDict;

import java.util.List;

/**
 * description: SysDictService <br>
 * date: 2020/12/31 15:54 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */

public interface SysDictService extends BaseService<SysDict> {
    List<SysDict> findByType(String type);
}
