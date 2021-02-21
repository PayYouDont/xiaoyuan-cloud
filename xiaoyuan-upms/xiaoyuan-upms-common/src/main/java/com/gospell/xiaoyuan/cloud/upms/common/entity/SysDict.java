package com.gospell.xiaoyuan.cloud.upms.common.entity;

import com.gospell.xiaoyuan.cloud.common.data.jpa.base.JpaEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * description: SysDict <br>
 * date: 2020/12/31 14:59 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */
@Data
@ApiModel(description = "字典")
@Entity
@Table(name = "sys_dict")
@EqualsAndHashCode(callSuper = true)
public class SysDict extends JpaEntity {

    @ApiModelProperty(value = "类型")
    private String type;

    @ApiModelProperty(value = "描述")
    private String description;

}
