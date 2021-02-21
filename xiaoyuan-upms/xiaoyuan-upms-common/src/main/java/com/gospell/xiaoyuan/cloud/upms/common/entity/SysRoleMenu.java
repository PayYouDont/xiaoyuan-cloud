package com.gospell.xiaoyuan.cloud.upms.common.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * description: 角色菜单关系表 <br>
 * date: 2020/12/31 14:52 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */
@Data
@Entity
@Table(name = "sys_role_menu")
public class SysRoleMenu {
    /**
     * 主键
     */
    @Id
    @ApiModelProperty(value = "主键")
    @GenericGenerator(name = "snowflakeId",strategy = "com.gospell.xiaoyuan.cloud.common.data.jpa.base.SnowflakeIdGenerator")
    @GeneratedValue(generator = "snowflakeId")
    private Long id;
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 菜单ID
     */
    private Long menuId;
}
