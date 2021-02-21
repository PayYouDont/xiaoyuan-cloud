package com.gospell.xiaoyuan.cloud.upms.common.entity;

import com.gospell.xiaoyuan.cloud.common.data.jpa.base.JpaEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * description: SysUser <br>
 * date: 2020/12/31 09:14 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */

@Data
@Entity
@Table(name = "sys_user")
@ApiModel(description = "用户")
@EqualsAndHashCode(callSuper = true)
public class SysUser extends JpaEntity {

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "锁定标记,(0：正常，1：封禁)")
    private Integer lockFlag;

    @ApiModelProperty(value = "机构ID")
    private Long organId;
    /**
     * 微信openid
     */
    private String wxOpenid;


}
