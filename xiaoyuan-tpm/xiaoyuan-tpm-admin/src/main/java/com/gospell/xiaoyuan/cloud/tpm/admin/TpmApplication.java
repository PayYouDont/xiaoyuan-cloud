package com.gospell.xiaoyuan.cloud.tpm.admin;


import com.gospell.xiaoyuan.cloud.common.security.annotation.EnableBaseFeignClients;
import com.gospell.xiaoyuan.cloud.common.security.annotation.EnableBaseResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * 功能描述: 人力资源 teacher personel management 微服务启动<br>
 * @Author: jiangsx
 * @Date: 2021/2/1 10:00
 */
@SpringCloudApplication
@EnableBaseFeignClients
@EnableBaseResourceServer
@EntityScan("com.gospell.xiaoyuan.cloud.tpm.**")
@EnableJpaAuditing
public class TpmApplication {
    public static void main(String[] args) {
        SpringApplication.run (TpmApplication.class,args);
    }
}
