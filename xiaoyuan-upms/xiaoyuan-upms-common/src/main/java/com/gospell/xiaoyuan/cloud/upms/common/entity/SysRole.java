package com.gospell.xiaoyuan.cloud.upms.common.entity;

import com.gospell.xiaoyuan.cloud.common.data.jpa.base.JpaEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * description: SysRole <br>
 * date: 2020/12/31 14:15 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */

@Data
@Entity
@Table(name = "sys_role")
@ApiModel(description = "角色")
@EqualsAndHashCode(callSuper = true)
public class SysRole extends JpaEntity {

    @ApiModelProperty(value = "角色名称")
    @NotNull(message = "角色名称 不能为空")
    private String roleName;

    @ApiModelProperty(value = "角色标识")
    @NotNull(message = "角色标识 不能为空")
    private String roleCode;

    @ApiModelProperty(value = "角色描述")
    @NotNull(message = "角色描述 不能为空")
    private String roleDesc;

    @ApiModelProperty(value = "数据权限")
    //@NotNull(message = "数据权限类型 不能为空")
    private Integer dsType;

    /**
     * 数据权限范围
     */
    private String dsScope;
}
