package com.gospell.xiaoyuan.cloud.sync;


import com.gospell.xiaoyuan.cloud.common.security.annotation.EnableBaseFeignClients;
import com.gospell.xiaoyuan.cloud.common.security.annotation.EnableBaseResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @Author jiangsx
 * @Decription  同步微服务启动入口
 * @Date 2021/1/27 17:57
 * @Version 1.0
 */
//
@SpringCloudApplication
@EnableBaseFeignClients
//@EnableFeignClients
@EnableBaseResourceServer
@EntityScan("com.gospell.xiaoyuan.cloud.sync.**")
@EnableJpaAuditing
public class SyncApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run (SyncApplication.class,args);
    }
}
