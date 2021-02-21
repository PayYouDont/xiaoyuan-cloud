package com.gospell.xiaoyuan.cloud.upms.admin.criteria;

import com.gospell.xiaoyuan.cloud.common.data.jpa.annotation.JpaQuery;
import com.gospell.xiaoyuan.cloud.common.data.jpa.base.BaseQueryCriteria;
import lombok.Data;

/**
 * description: 根据用户名模糊搜索和机构id查询 <br>
 * date: 2021/1/19 11:20 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */
@Data
public class SysUserDetailCriteria implements BaseQueryCriteria {
    @JpaQuery(blurry = "username")
    private String username;

    @JpaQuery
    private String organId;
}
