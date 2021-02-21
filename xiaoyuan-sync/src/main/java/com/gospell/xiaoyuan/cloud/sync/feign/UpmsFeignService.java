package com.gospell.xiaoyuan.cloud.sync.feign;




import com.gospell.xiaoyuan.cloud.sync.feign.impl.UpmsFeignServiceImpl;
import com.gospell.xiaoyuan.cloud.common.core.constant.SecurityConstants;
import com.gospell.xiaoyuan.cloud.common.core.util.R;

import com.gospell.xiaoyuan.cloud.upms.common.dto.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @ClassName UpmsFeignService
 * @Description  用户权限 远程调用service
 * @Author jiangsx
 * @DATE 2021/1/27 19:22
 **/
@FeignClient(value = "xiaoyuan-upms-admin",fallback = UpmsFeignServiceImpl.class)
//@FeignClient(contextId = "UpmsFeignService", value = ServiceNameConstants.UMPS_ADMIN_SERVICE)
public interface UpmsFeignService {
    /**
     * 通过名称 获取用户信息
     */
    @GetMapping("/user/info/{username}")
    R<UserInfo> info(@PathVariable("username") String username, @RequestHeader(SecurityConstants.FROM) String from);
    @GetMapping("/user/test/info/{username}")
    R  test(@PathVariable("username") String username, @RequestHeader(SecurityConstants.FROM) String from);
}