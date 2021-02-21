package com.gospell.xiaoyuan.cloud.cls.admin;


import com.gospell.xiaoyuan.cloud.common.security.annotation.EnableBaseFeignClients;
import com.gospell.xiaoyuan.cloud.common.security.annotation.EnableBaseResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringCloudApplication
@EnableBaseFeignClients
@EnableJpaAuditing
@EnableBaseResourceServer
@EntityScan("com.gospell.**")
public class ClsAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run (ClsAdminApplication.class, args);
    }
}
