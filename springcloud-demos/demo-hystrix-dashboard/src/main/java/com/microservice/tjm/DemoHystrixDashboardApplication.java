package com.microservice.tjm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * 熔断器
 *
 * @author: tjm
 * @date: 2020/12/14 13:44
 */
@EnableHystrixDashboard
@SpringBootApplication
@EnableHystrix
@EnableTurbine
public class DemoHystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoHystrixDashboardApplication.class, args);
        System.out.println("━ ━ ━ ━ ━ DemoHystrixDashboardApplication Success ━ ━ ━ ━ ━");
    }

}
