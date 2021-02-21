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
import java.util.Date;

/**
 * @ClassName PollSignUp
 * @Description 投票报名
 * @Author pay
 * @DATE 2021/2/4 14:31
 **/
@Data
@ApiModel(description = "投票报名")
@Entity
@Table(name = "class_poll_sign")
public class PollSignUp {

    @Id
    @ApiModelProperty(value = "主键")
    @GenericGenerator(name = "snowflakeId",strategy = "com.gospell.xiaoyuan.cloud.common.data.jpa.base.SnowflakeIdGenerator")
    @GeneratedValue(generator = "snowflakeId")
    private Long id;

    @ApiModelProperty(value = "班级通知id")
    @NotNull(message = "班级通知id不能为空")
    private Long pollItemId;

    @ApiModelProperty(value = "参与报名成员id")
    @NotNull(message = "参与报名成员id不能为空")
    private Long memberId;

    /**
    * 参与报名时间
    **/
    private Date createTime;
}
