package com.microservice.tjm.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * ClientEurekaProviderFeignClient
 *
 * @author: tjm
 * @date: 2020/12/14 16:58
 */
@FeignClient("client-eureka-provider")
public interface ClientEurekaProviderFeignClient {

    @GetMapping("/users/{userName}")
    String user(@PathVariable(value = "userName") String userName);
}
