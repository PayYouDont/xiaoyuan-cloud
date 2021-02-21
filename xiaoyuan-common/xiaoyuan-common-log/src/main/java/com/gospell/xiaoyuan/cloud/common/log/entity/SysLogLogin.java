/**
 * Copyright (C) 2018-2019
 * All rights reserved, Designed By www.joolun.com
 * 注意：
 * 本软件为www.joolun.com开发研制，未经购买不得使用
 * 购买后可获得全部源代码（禁止转卖、分享、上传到码云、github等开源平台）
 * 一经发现盗用、分享等行为，将追究法律责任，后果自负
 */
package com.gospell.xiaoyuan.cloud.common.log.entity;



import com.gospell.xiaoyuan.cloud.common.data.jpa.base.JpaEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;

/**
 * 登录日志表
 *
 * @author jiangsx
 * @date 2021-1-28
 */
@Data
@Table(catalog = "sys_log_login")
@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "登录日志表")
public class SysLogLogin extends JpaEntity {
    private static final long serialVersionUID=1L;

    /**
     * 创建者ID
     */
    @ApiModelProperty(value = "创建者ID")
    private String createId;

    /**
     * IP地址
     */
    @ApiModelProperty(value = "IP地址")
    private String remoteAddr;
    /**
     * 用户代理
     */
    @ApiModelProperty(value = "用户代理")
    private String userAgent;
    /**
     * 请求URI
     */
    @ApiModelProperty(value = "请求URI")
    private String requestUri;
    /**
     * 操作提交的数据
     */
    @ApiModelProperty(value = "操作提交的数据")
    private String params;

    /**
     * 地址信息
     */
    @ApiModelProperty(value = "地址信息")
    private String address;
    /**
     * 所属租户
     */
    @ApiModelProperty(value = "所属租户")
    private String tenantId;

}
