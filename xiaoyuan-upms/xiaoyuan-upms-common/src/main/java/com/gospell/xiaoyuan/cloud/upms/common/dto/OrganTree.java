package com.gospell.xiaoyuan.cloud.upms.common.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author
 * 机构树
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OrganTree extends TreeNode {
	private String name;
	/**
	 * 机构编码
	 */
	private String code;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 机构类型
	 */
	private String type;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 备注
	 */
	private String remarks;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date updateTime;
}
