package com.gospell.xiaoyuan.cloud.cls.common.entity;

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
 * @ClassName ClassMessage
 * @Description 班级通知
 * @Author pay
 * @DATE 2021/2/3 16:35
 **/
@Data
@ApiModel(description = "班级通知")
@Entity
@Table(name = "class_message")
@EqualsAndHashCode(callSuper = true)
public class ClassMessage extends JpaEntity {

    @ApiModelProperty(value = "班级圈id")
    @NotNull(message = "班级圈id不能为空")
    private Long classCircleId;

    @ApiModelProperty(value = "通知标题")
    @NotNull(message = "通知标题不能为空")
    private String title;

    @ApiModelProperty(value = "通知内容")
    private String content;

    @ApiModelProperty(value = "发起人id")
    @NotNull(message = "发起人id不能为空")
    private Long initiatorId;

    @ApiModelProperty(value = "通知等级")
    @NotNull(message = "通知等级不能为空")
    private Integer level;

    @ApiModelProperty(value = "是否需要阅读回执")
    @NotNull(message = "是否需要阅读回执状态不能为空")
    private Boolean isReceipt;

    /**
    * 附件id列表
    **/
    @JsonIgnore
    @Transient
    private List<Long> attachIds;
}
