package com.microservice.tjm;

import com.microservice.tjm.filter.RequestAfterFilter;
import com.microservice.tjm.filter.RequestBeforeFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@ServletComponentScan
@EnableEurekaClient
public class DemoZuulServiceApplication {

    /**
     * 请求【前】拦截
     * @return
     */
    @Bean
    RequestBeforeFilter requestBeforeFilter() {
        return new RequestBeforeFilter();
    }

    /**
     * 请求【后】拦截
     * @return
     */
    @Bean
    RequestAfterFilter requestAfterFilter() {
        return new RequestAfterFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoZuulServiceApplication.class, args);
        System.out.println("━ ━ ━ ━ ━ DemoZuulServiceApplication Success ━ ━ ━ ━ ━");
    }

}
