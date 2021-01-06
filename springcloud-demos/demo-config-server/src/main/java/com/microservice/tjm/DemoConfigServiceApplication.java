package com.microservice.tjm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 分布式配置中心
 *
 * @author: tjm
 * @date: 2020/12/14 13:44
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class DemoConfigServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoConfigServiceApplication.class, args);
        System.out.println("━ ━ ━ ━ ━ DemoConfigServiceApplication Success ━ ━ ━ ━ ━");
    }

}
