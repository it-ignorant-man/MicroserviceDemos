package com.microservice.tjm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 服务网关
 *
 * @author: tjm
 * @date: 2020/12/14 13:44
 */
@SpringBootApplication
@EnableDiscoveryClient
public class DemoGatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoGatewayServiceApplication.class, args);
        System.out.println("━ ━ ━ ━ ━ DemoGatewayServiceApplication Success ━ ━ ━ ━ ━");
    }

}
