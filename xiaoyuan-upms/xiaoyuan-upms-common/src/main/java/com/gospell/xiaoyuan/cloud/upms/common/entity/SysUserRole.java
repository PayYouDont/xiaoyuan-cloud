package com.gospell.xiaoyuan.cloud.upms.common.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * description: 用户角色关系表 <br>
 * date: 2020/12/31 14:52 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */
@Data
@Entity
@Table(name = "sys_user_role")
public class SysUserRole {
    /**
     * 主键
     */
    @Id
    @ApiModelProperty(value = "主键")
    @GenericGenerator(name = "snowflakeId",strategy = "com.gospell.xiaoyuan.cloud.common.data.jpa.base.SnowflakeIdGenerator")
    @GeneratedValue(generator = "snowflakeId")
    private Long id;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 角色ID
     */
    private Long roleId;
}
