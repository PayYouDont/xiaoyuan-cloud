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
 * description: SysOrgan <br>
 * date: 2020/12/31 14:22 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */

@Data
@Entity
@Table(name = "sys_organ")
@ApiModel(description = "机构管理")
@EqualsAndHashCode(callSuper = true)
public class SysOrgan extends JpaEntity {

    @ApiModelProperty(value = "机构名称")
    @NotNull(message = "机构名称不能为空")
    private String name;

    @ApiModelProperty(value = "排序")
    @NotNull(message = "排序不能为空")
    private Integer sort;

    @ApiModelProperty(value = "机构编码")
    @NotNull(message = "机构编码不能为空")
    private String code;

    @ApiModelProperty(value = "机构类型")
    @NotNull(message = "机构类型不能为空")
    private String type;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "上级ID")
    private Long parentId;
}
