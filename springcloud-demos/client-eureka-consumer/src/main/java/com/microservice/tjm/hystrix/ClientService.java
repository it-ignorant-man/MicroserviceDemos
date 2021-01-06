package com.microservice.tjm.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

/**
 * ClientService
 *
 * @author: tjm
 * @date: 2020/12/15 00:40
 */
@Service
public class ClientService {

    /**
     * fallbackMethod: 指定熔断后执行的方法
     * value：         超时时间（单位：ms）
     * 说明：执行该方法，如果发生熔断，执行fallbackMethod
     */
    @HystrixCommand(fallbackMethod = "sleepFallback",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
            })
    public String sleep(int sleep) {
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "success";
    }

    /**
     * 熔断后执行的方法
     */
    private String sleepFallback(int sleep) {
        return "fallback";
    }
}
