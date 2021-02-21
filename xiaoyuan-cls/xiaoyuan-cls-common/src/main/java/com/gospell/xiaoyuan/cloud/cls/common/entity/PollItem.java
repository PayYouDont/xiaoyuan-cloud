package com.gospell.xiaoyuan.cloud.cls.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @ClassName PollItem
 * @Description 投票项
 * @Author pay
 * @DATE 2021/2/4 11:50
 **/
@Data
@ApiModel(description = "投票项")
@Entity
@Table(name = "class_poll_item")
public class PollItem {

    @Id
    @ApiModelProperty(value = "主键")
    @GenericGenerator(name = "snowflakeId",strategy = "com.gospell.xiaoyuan.cloud.common.data.jpa.base.SnowflakeIdGenerator")
    @GeneratedValue(generator = "snowflakeId")
    private Long id;

    @ApiModelProperty(value = "投票项内容")
    @NotNull(message = "投票项内容不能为空")
    private String content;
    /**
    * 排序
    **/
    private Integer sort;

    @ApiModelProperty(value = "投票id")
    @NotNull(message = "投票id不能为空")
    @ManyToOne
    @JoinColumn(name = "poll_id", nullable = false, referencedColumnName = "id")
    @JsonIgnoreProperties("pollItems")
    private Poll poll;
}
