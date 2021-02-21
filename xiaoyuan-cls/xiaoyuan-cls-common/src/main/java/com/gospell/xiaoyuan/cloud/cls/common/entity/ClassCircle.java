package com.gospell.xiaoyuan.cloud.cls.common.entity;

import com.gospell.xiaoyuan.cloud.common.core.constant.CommonConstants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @ClassName ClassCircle
 * @Description 班级圈
 * @Author pay
 * @DATE 2021/2/4 10:10
 **/
@Data
@ApiModel(description = "班级圈")
@Entity
@Table(name = "class_circle")
public class ClassCircle {
    @Id
    @ApiModelProperty(value = "主键")
    @GenericGenerator(name = "snowflakeId",strategy = "com.gospell.xiaoyuan.cloud.common.data.jpa.base.SnowflakeIdGenerator")
    @GeneratedValue(generator = "snowflakeId")
    private Long id;

    /**
     * 班级圈活跃状态:
     * {@link com.gospell.xiaoyuan.cloud.common.core.constant.CommonConstants#CLASS_STATUS_ACTIVATED}
     * {@link com.gospell.xiaoyuan.cloud.common.core.constant.CommonConstants#CLASS_STATUS_NOT_ACTIVE}
     **/
    @ApiModelProperty(value = "班级圈活跃状态:0-不活跃 1-活跃")
    @NotNull(message = "班级圈活跃状态不能为空")
    private int activeStatus = CommonConstants.CLASS_STATUS_ACTIVATED;

    @ApiModelProperty(value = "班级id")
    @NotNull(message = "班级id不能为空")
    private Long classId;

    @ApiModelProperty(value = "备注")
    private String remarks;
}
