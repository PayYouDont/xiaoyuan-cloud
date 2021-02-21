package com.gospell.xiaoyuan.cloud.tpm.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import feign.Logger;
/**
 * @ClassName FeignConfig
 * @Description
 * @Author jiangsx
 * @DATE 2021/2/1 9:53
 **/
@Configuration
public class FeignConfig {
    // 配置feign的日志打印 类型
    @Bean
    Logger. Level  feignLoggerLevel (){
        return  Logger.Level .FULL ;
    }
}
