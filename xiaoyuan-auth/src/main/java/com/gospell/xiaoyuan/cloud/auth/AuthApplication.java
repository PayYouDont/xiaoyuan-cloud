package com.gospell.xiaoyuan.cloud.auth;

import com.gospell.xiaoyuan.cloud.common.security.annotation.EnableBaseFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * description: AuthApplication <br>
 * date: 2020/12/29 14:16 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */
@SpringCloudApplication
@EnableBaseFeignClients
public class AuthApplication {
    public static void main(String[] args) {
        SpringApplication.run (AuthApplication.class,args);
    }
}