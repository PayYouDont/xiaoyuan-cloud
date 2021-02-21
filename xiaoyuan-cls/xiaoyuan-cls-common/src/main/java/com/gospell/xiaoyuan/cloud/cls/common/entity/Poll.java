package com.gospell.xiaoyuan.cloud.cls.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gospell.xiaoyuan.cloud.common.core.constant.CommonConstants;
import com.gospell.xiaoyuan.cloud.common.data.jpa.base.JpaEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @ClassName Poll
 * @Description 投票
 * @Author pay
 * @DATE 2021/2/4 11:28
 **/
@Data
@ApiModel(description = "投票")
@Entity
@Table(name = "class_poll")
@EqualsAndHashCode(callSuper = true)
public class Poll extends JpaEntity {

    @ApiModelProperty(value = "班级圈id")
    @NotNull(message = "班级圈id不能为空")
    private Long classCircleId;

    @ApiModelProperty(value = "投票发起者id")
    @NotNull(message = "投票发起者id不能为空")
    private Long initiatorId;

    @ApiModelProperty(value = "投票主题")
    @NotNull(message = "投票主题不能为空")
    private String theme;

    @ApiModelProperty(value = "投票描述")
    private String description;

    @ApiModelProperty(value = "投票开始时间")
    private Date startTime;

    @ApiModelProperty(value = "投票结束时间")
    private Date endTime;

    /**
     * 投票类型:
     * {@link com.gospell.xiaoyuan.cloud.common.core.constant.CommonConstants#POLL_TYPE_RADIO}
     * {@link com.gospell.xiaoyuan.cloud.common.core.constant.CommonConstants#POLL_TYPE_CHECKBOX}
     **/
    @ApiModelProperty(value = "投票类型")
    @NotNull(message = "投票类型不能为空")
    private Integer type = CommonConstants.POLL_TYPE_RADIO;

    @OneToMany(mappedBy = "poll", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("poll")
    private List<PollItem> pollItems;
}
