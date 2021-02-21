package com.gospell.xiaoyuan.cloud.sync.controller;


import com.gospell.xiaoyuan.cloud.common.log.annotation.SysLog;
import com.gospell.xiaoyuan.cloud.sync.feign.UpmsFeignService;
import com.gospell.xiaoyuan.cloud.common.core.constant.SecurityConstants;
import com.gospell.xiaoyuan.cloud.common.core.util.R;
import com.gospell.xiaoyuan.cloud.upms.common.dto.UserInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UpmsFeignController {

    @Resource
    private  UpmsFeignService upmsFeignService;

    @GetMapping("/sync/user/test/info/{username}")
    @SysLog ("测试feign调用")
    public R  test(@PathVariable("username") String username, @RequestHeader(SecurityConstants.FROM) String from){
        return upmsFeignService.test (username, from);
    }

    @GetMapping("/sync/user/info/{username}")
    public R<UserInfo> getUser(@PathVariable("username") String username, @RequestHeader(SecurityConstants.FROM) String from){
        return upmsFeignService.info (username, from);
    }

}
