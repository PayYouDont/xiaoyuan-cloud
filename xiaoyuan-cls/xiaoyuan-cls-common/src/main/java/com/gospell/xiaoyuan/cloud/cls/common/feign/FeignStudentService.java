package com.gospell.xiaoyuan.cloud.cls.common.feign;

import com.gospell.xiaoyuan.cloud.common.core.constant.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * description: StudentService <br>
 * date: 2021/2/5 17:17 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */
@FeignClient(contextId = "feignStudentService", value = ServiceNameConstants.STUDENT_SERVICE)
public interface FeignStudentService {
}
