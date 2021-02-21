package com.gospell.xiaoyuan.cloud.upms.common.dto;

import com.gospell.xiaoyuan.cloud.upms.common.entity.SysUser;
import lombok.Data;

import java.io.Serializable;

/**
 * description: UserInfo <br>
 * date: 2021/1/4 15:36 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */
@Data
public class UserInfo implements Serializable {
    /**
     * 用户基本信息
     */
    private SysUser sysUser;
    /**
     * 权限标识集合
     */
    private String[] permissions;

    /**
     * 角色集合
     */
    private Long[] roles;
}
