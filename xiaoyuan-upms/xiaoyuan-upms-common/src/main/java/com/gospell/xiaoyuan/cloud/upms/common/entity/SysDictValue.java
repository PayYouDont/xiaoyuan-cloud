package com.gospell.xiaoyuan.cloud.upms.common.entity;

import com.gospell.xiaoyuan.cloud.common.data.jpa.base.JpaEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * description: SysDictValue <br>
 * date: 2021/1/19 10:36 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */
@Data
@ApiModel(description = "字典值")
@Entity
@Table(name = "sys_dict_value")
@EqualsAndHashCode(callSuper = true)
public class SysDictValue extends JpaEntity {
    /**
     * 字典ID
     */
    @ApiModelProperty(value = "字典ID")
    private Long dictId;
    /**
     * 数据值
     */
    @ApiModelProperty(value = "数据值")
    private String value;
    /**
     * 标签名
     */
    @ApiModelProperty(value = "标签名")
    private String label;
    /**
     * 类型
     */
    @ApiModelProperty(value = "类型")
    private String type;
    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String description;
    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sort;
}
