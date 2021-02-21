package com.gospell.xiaoyuan.cloud.sms.admin;

import com.gospell.xiaoyuan.cloud.common.security.annotation.EnableBaseFeignClients;
import com.gospell.xiaoyuan.cloud.common.security.annotation.EnableBaseResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * 功能描述: student management system 微服务启动<br>
 * @Author: jiangsx
 * @Date: 2021/2/1 10:10
 */
@SpringCloudApplication
@EnableBaseFeignClients
@EnableBaseResourceServer
@EntityScan("com.gospell.xiaoyuan.cloud.sms.**")
@EnableJpaAuditing
public class SmsApplication {
    public static void main(String[] args) {
        SpringApplication.run (SmsApplication.class,args);
    }
}
