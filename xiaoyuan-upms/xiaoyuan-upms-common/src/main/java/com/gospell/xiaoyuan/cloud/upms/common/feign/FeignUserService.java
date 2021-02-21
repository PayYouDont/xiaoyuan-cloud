package com.gospell.xiaoyuan.cloud.upms.common.feign;

import com.gospell.xiaoyuan.cloud.common.core.constant.SecurityConstants;
import com.gospell.xiaoyuan.cloud.common.core.constant.ServiceNameConstants;
import com.gospell.xiaoyuan.cloud.common.core.util.R;
import com.gospell.xiaoyuan.cloud.upms.common.dto.UserInfo;
import io.lettuce.core.dynamic.annotation.Param;
import lombok.NonNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * description: FeignUserService <br>
 * date: 2021/1/4 15:28 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */
@FeignClient(contextId = "feignUserService", value = ServiceNameConstants.UMPS_ADMIN_SERVICE)
public interface FeignUserService {
    @GetMapping("/user/info/{username}")
    R<UserInfo> info(@PathVariable("username") String username,@RequestHeader(SecurityConstants.FROM) String from);

    @PostMapping("/user/info")
    R<UserInfo> loadUserByWxOpenId(@NonNull @RequestParam("wxOpenId") String wxOpenId, @RequestHeader(SecurityConstants.FROM) String from);

}
