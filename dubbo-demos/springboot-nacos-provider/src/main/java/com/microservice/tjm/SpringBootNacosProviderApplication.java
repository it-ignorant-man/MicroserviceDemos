package com.microservice.tjm;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDubbo(scanBasePackages = "com.microservice.tjm.dubbo.service")
public class SpringBootNacosProviderApplication {

    public static void main( String[] args ) {
        SpringApplication.run(SpringBootNacosProviderApplication.class, args);
        System.out.println("━ ━ ━ ━ ━ SpringBootNacosProviderApplication Success ━ ━ ━ ━ ━");
    }
}
