package com.gospell.xiaoyuan.cloud.common.data.jpa.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * description: BaseEntity <br>
 * date: 2020/12/31 08:36 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */
@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
@DynamicInsert
public abstract class JpaEntity implements Serializable {
    /**
     * 主键
     */
    @Id
    @ApiModelProperty(value = "主键")
    //根据业务需求，自定义id生成策略，采用雪花id做为主键
    @GenericGenerator (name = "snowflakeId",strategy = "com.gospell.xiaoyuan.cloud.common.data.jpa.base.SnowflakeIdGenerator")
    @GeneratedValue(generator = "snowflakeId")
    private Long id;
    /**
     * 删除标识：0-正常，1-删除
     */
    @ApiModelProperty(value = "0-正常，1-删除")
    private Integer delFlag;
    /**
     * 创建时间
     */
    @CreatedDate
    private Date createTime;
    /**
     * 创建人
     */
    @CreatedBy
    private String createBy;
    /**
     * 修改时间
     */
    @LastModifiedDate
    private Date updateTime;
    /**
     * 修改人
     */
    @LastModifiedBy
    private String updateBy;

    @ApiModelProperty(value = "备注")
    private String remarks;
}
