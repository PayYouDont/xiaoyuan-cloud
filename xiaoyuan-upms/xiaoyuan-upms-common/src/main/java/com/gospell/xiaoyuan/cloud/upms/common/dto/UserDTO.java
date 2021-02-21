package com.gospell.xiaoyuan.cloud.upms.common.dto;

import com.gospell.xiaoyuan.cloud.upms.common.entity.SysUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * description: UserDTO <br>
 * date: 2021/1/15 17:04 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends SysUser {
    /**
     * 角色ID
     */
    private List<Long> roleIds;
    /**
     * 新密码
     */
    private String newpassword1;
    /**
     * 验证码
     */
    private String code;
    /**
     * 操作类型
     */
    private String doType;
}
