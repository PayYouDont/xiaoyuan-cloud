package com.gospell.xiaoyuan.cloud.sms.admin.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName FeignConfig
 * @Description
 * @Author jiangsx
 * @DATE 2021/1/28 11:17
 **/
@Configuration
public class FeignConfig {
    // 配置feign的日志打印 类型
    @Bean
    Logger. Level  feignLoggerLevel (){
        return  Logger.Level .FULL ;
    }
}
