package com.gospell.xiaoyuan.cloud.upms.common.entity;

import com.gospell.xiaoyuan.cloud.common.data.jpa.base.JpaEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * description: nacos：客户端信息 <br>
 * date: 2020/12/31 14:32 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */
@Data
@Entity
@Table(name ="sys_oauth_client")
@EqualsAndHashCode(callSuper = true)
public class SysOauthClient extends JpaEntity {

    /**
     * 客户端密钥
     */
    @NotNull(message = "客户端密钥 不能为空")
    private String clientSecret;

    /**
     * 资源ID
     */
    private String resourceIds;

    /**
     * 作用域
     */
    @NotNull(message = "作用域 不能为空")
    private String scope;

    /**
     * 授权方式（A,B,C）
     */
    private String authorizedGrantTypes;

    private String webServerRedirectUri;

    private String authorities;

    /**
     * 请求令牌有效时间
     */
    private Integer accessTokenValidity;

    /**
     * 刷新令牌有效时间
     */
    private Integer refreshTokenValidity;

    /**
     * 扩展信息
     */
    private String additionalInformation;

    /**
     * 是否自动放行
     */
    private String autoapprove;

}
