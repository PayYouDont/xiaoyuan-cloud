
package com.gospell.xiaoyuan.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author
 * 网关应用
 */
@SpringCloudApplication
public class BaseGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseGateWayApplication.class, args);
	}
}
