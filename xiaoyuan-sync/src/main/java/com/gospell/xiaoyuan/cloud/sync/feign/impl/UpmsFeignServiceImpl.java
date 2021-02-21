package com.gospell.xiaoyuan.cloud.sync.feign.impl;


import com.gospell.xiaoyuan.cloud.sync.feign.UpmsFeignService;
import com.gospell.xiaoyuan.cloud.common.core.util.R;
import com.gospell.xiaoyuan.cloud.upms.common.dto.UserInfo;
import org.springframework.stereotype.Component;

@Component
public class UpmsFeignServiceImpl implements UpmsFeignService {
    @Override
    public R<UserInfo> info(String username, String from) {
        System.out.println ("测试数据");
        return null;
    }

    @Override
    public R<UserInfo> test(String username, String from) {
        return R.failed ("测试fallback方法返回");
    }
}
