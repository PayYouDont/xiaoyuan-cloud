package com.gospell.xiaoyuan.cloud.upms.admin.service;

import com.gospell.xiaoyuan.cloud.common.data.jpa.base.BaseService;
import com.gospell.xiaoyuan.cloud.upms.common.dto.OrganTree;
import com.gospell.xiaoyuan.cloud.upms.common.entity.SysOrgan;

import java.util.List;

/**
 * description: SysUserService <br>
 * date: 2020/12/31 15:54 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */

public interface SysOrganService extends BaseService<SysOrgan> {
    /**
     * description: 查询机构树菜单 <br>
     * version: 1.0 <br>
     * date: 2021/1/15 16:22 <br>
     * author: pay <br>
     *
     * @param
     * @return java.util.List<com.gospell.xiaoyuan.cloud.upms.common.dto.OrganTree>
     */
    List<OrganTree> selectTree();
}
