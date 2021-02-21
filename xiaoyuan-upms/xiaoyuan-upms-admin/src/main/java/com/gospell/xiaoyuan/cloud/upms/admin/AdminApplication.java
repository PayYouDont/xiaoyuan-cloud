package com.gospell.xiaoyuan.cloud.upms.admin;

import com.gospell.xiaoyuan.cloud.common.security.annotation.EnableBaseFeignClients;
import com.gospell.xiaoyuan.cloud.common.security.annotation.EnableBaseResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * description: AdminApplication <br>
 * date: 2020/12/3 17:02 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */
@SpringCloudApplication
@EnableBaseFeignClients
@EnableBaseResourceServer
@EntityScan("com.gospell.**")
@EnableJpaAuditing
public class AdminApplication {
    public static void main(String[] args) {
        SpringApplication.run (AdminApplication.class,args);
    }
}
