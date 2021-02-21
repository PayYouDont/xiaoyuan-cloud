package com.gospell.xiaoyuan.cloud.common.core.constant;

/**
 * @author
 */
public interface CommonConstants {
	/**
	 * 删除
	 */
	String STATUS_DEL = "1";
	/**
	 * 正常
	 */
	Integer STATUS_NORMAL = 0;

	/**
	 * 锁定
	 */
	String STATUS_LOCK = "9";
	/**
	 * 日志类型：正常操作日志
	 */
	String LOG_TYPE_0 = "0";
	/**
	 * 日志类型：异常操作日志
	 */
	String LOG_TYPE_9 = "9";
	/**
	 * 菜单
	 */
	String MENU = "0";
	/**
	 * 按钮
	 */
	String BUTT = "1";

	/**
	 * 编码
	 */
	String UTF8 = "UTF-8";

	/**
	 * 成功标记
	 */
	Integer SUCCESS = 0;
	/**
	 * 失败标记
	 */
	Integer FAIL = 1;

	/**
	 * 树形父类ID
	 */
	Long PARENT_ID = 0L;

	/**
	 * 数据权限类型
	 * 0全部，1自定义，2本级及子级，3本级
	 */
	Integer DS_TYPE_0 = 0;
	Integer DS_TYPE_1 = 1;
	Integer DS_TYPE_2 = 2;
	Integer DS_TYPE_3 = 3;

	/**
	 * 管理员角色编码
	 */
	String ROLE_CODE_ADMIN = "ROLE_ADMIN";


	String CONFIG_DATA_ID = "dynamic_routes";
	String CONFIG_GROUP = "DEFAULT_GROUP";
	long CONFIG_TIMEOUT_MS = 5000;

    /**
     * 班级圈活跃状态:不活跃
     */
    Integer CLASS_STATUS_NOT_ACTIVE = 0;
    /**
    * 班级圈活跃状态:活跃
    **/
    Integer CLASS_STATUS_ACTIVATED = 1;
    /**
     * 投票类型：单选
     */
    Integer POLL_TYPE_RADIO = 0;

    /**
     * 投票类型：多选
     */
	Integer POLL_TYPE_CHECKBOX = 1;


}
