package com.microservice.tjm.dubbo.service;

import com.microservice.tjm.dubbo.api.HelloService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * HelloServiceImpl:
 *
 * @author: tjm
 * @date: 2020/12/15 18:13
 */
@DubboService
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello() {
        return "hello world: spring boot";
    }
}
