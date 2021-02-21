package com.gospell.xiaoyuan.cloud.common.log.event;


import com.gospell.xiaoyuan.cloud.common.log.entity.SysLog;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author jiangsx
 * 系统日志事件
 */
@Getter
@AllArgsConstructor
public class SysLogEvent {
	private final SysLog sysLog;
}
