package com.microservice.tjm;

import com.microservice.tjm.dubbo.api.HelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDubbo
@RestController
public class SpringBootNacosConsumerApplication  {
    public static void main( String[] args ) {
        SpringApplication.run(SpringBootNacosConsumerApplication.class, args);
        System.out.println("━ ━ ━ ━ ━ ClientNacosConsumerApplication Success ━ ━ ━ ━ ━");
    }

    @DubboReference
    HelloService helloService;

    @GetMapping("/hello")
    public String hello() {
        return helloService.sayHello();
    }
}
