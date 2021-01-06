package com.microservice.tjm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * feign 服务提供者
 *
 * @author: tjm
 * @date: 2020/12/14 13:44
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
public class ClientEurekaProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientEurekaProviderApplication.class, args);
        System.out.println("━ ━ ━ ━ ━ ClientEurekaProviderApplication Success ━ ━ ━ ━ ━");
    }

}
