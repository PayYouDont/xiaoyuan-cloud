package com.gospell.xiaoyuan.cloud.common.log.aspect;


import com.gospell.xiaoyuan.cloud.common.log.annotation.SysLog;
import com.gospell.xiaoyuan.cloud.common.log.event.SysLogEvent;
import com.gospell.xiaoyuan.cloud.common.log.util.SysLogUtils;
import com.gospell.xiaoyuan.cloud.common.core.constant.CommonConstants;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.ApplicationEventPublisher;

/**
 * 操作日志使用spring event异步入库
 *
 * @author jiangsx
 */
@Slf4j
@Aspect
@AllArgsConstructor
public class SysLogAspect {
	private final ApplicationEventPublisher publisher;

	@SneakyThrows
	@Around("@annotation(sysLog)")
	public Object around(ProceedingJoinPoint point, SysLog sysLog) {
		String strClassName = point.getTarget().getClass().getName();
		String strMethodName = point.getSignature().getName();
		log.debug("[类名]:{},[方法]:{}", strClassName, strMethodName);

        com.gospell.xiaoyuan.cloud.common.log.entity.SysLog logVo = SysLogUtils.getSysLog ();
        logVo.setType(CommonConstants.LOG_TYPE_0);
		logVo.setTitle(sysLog.value());
		// 发送异步日志事件
		Long startTime = System.currentTimeMillis();
		Object obj = point.proceed();
		Long endTime = System.currentTimeMillis();
		logVo.setTime(endTime - startTime);
		publisher.publishEvent(new SysLogEvent(logVo));
		return obj;
	}

}
