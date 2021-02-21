package com.gospell.xiaoyuan.cloud.cls.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @ClassName ClassMessageReceipt
 * @Description 班级通知阅读回执
 * @Author pay
 * @DATE 2021/2/4 10:59
 **/
@Data
@ApiModel(description = "班级通知阅读回执")
@Entity
@Table(name = "class_message_receipt")
public class ClassMessageReceipt {

    @Id
    @ApiModelProperty(value = "主键")
    @GenericGenerator(name = "snowflakeId",strategy = "com.gospell.xiaoyuan.cloud.common.data.jpa.base.SnowflakeIdGenerator")
    @GeneratedValue(generator = "snowflakeId")
    private Long id;

    @ApiModelProperty(value = "班级通知id")
    @NotNull(message = "班级通知id不能为空")
    private Long classMessageId;

    @ApiModelProperty(value = "班级圈成员id")
    @NotNull(message = "班级圈成员id不能为空")
    private Long memberId;

    @ApiModelProperty(value = "是否已阅")
    @NotNull(message = "阅读状态不能为空")
    private Boolean isRead;
}
