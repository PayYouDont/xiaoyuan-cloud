package com.gospell.xiaoyuan.cloud.upms.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gospell.xiaoyuan.cloud.common.data.jpa.base.JpaEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * description: SysMenu <br>
 * date: 2020/12/31 14:08 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */

@Data
@Entity
@ApiModel(description = "菜单")
@Table(name ="sys_menu")
@EqualsAndHashCode(callSuper = true)
public class SysMenu extends JpaEntity {

    @ApiModelProperty(value = "菜单名称")
    @NotNull(message = "菜单名称不能为空")
    private String name;

    @ApiModelProperty(value = "菜单权限标识")
    private String permission;

    @ApiModelProperty(value = "父菜单ID")
    @NotNull(message = "菜单父ID不能为空")
    private Long parentId;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "VUE页面")
    private String component;

    @ApiModelProperty(value = "排序值")
    private Integer sort;

    @NotNull(message = "菜单类型 （0菜单 1按钮）")
    private String type;

    @ApiModelProperty(value = "路由缓冲")
    private String keepAlive;

    @ApiModelProperty(value = "前端URL")
    private String path;

    @Transient
    private Long roleId;

    @JsonIgnore
    @Transient
    private List<SysMenu> children;
}
