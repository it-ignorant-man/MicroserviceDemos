package com.microservice.tjm;

import com.microservice.tjm.feign.ClientEurekaProviderFeignClient;
import com.microservice.tjm.hystrix.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ClientEurekaConsumerApplication {
    private static final Logger logger = LoggerFactory.getLogger(ClientEurekaConsumerApplication.class);

    public static void main( String[] args ) {
        SpringApplication.run(ClientEurekaConsumerApplication.class, args);
        System.out.println("━ ━ ━ ━ ━ ClientEurekaConsumerApplication Success ━ ━ ━ ━ ━");
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    static String PROVIDER = "http://eureka-client-provider";

    @GetMapping("/consumers/{userName}")
    public String test(@PathVariable String userName) {
        logger.info("invoke provider {}, userName: {}", PROVIDER, userName);
        String responseUser = restTemplate.getForObject(String.format(PROVIDER + "/users/%s", userName), String.class);
        logger.info("provider {} response data: {}", PROVIDER, responseUser);
        return responseUser;
    }


    @Autowired
    private ClientEurekaProviderFeignClient clientEurekaProviderFeignClient;

    @GetMapping("/feign/consumers/{userName}")
    public String testFeign(@PathVariable String userName) {
        logger.info("invoke provider {}, userName: {}", PROVIDER, userName);
        String responseUser = clientEurekaProviderFeignClient.user(userName);
        logger.info("provider {} response data: {}", PROVIDER, responseUser);
        return responseUser;
    }

    @Autowired
    private ClientService clientService;

    @GetMapping("/hystrix/timeout")
    public String testHystrixTimeout(@RequestParam int sleep) {
        return clientService.sleep(sleep);
    }

    @GetMapping("/client-consumer/consumers/{name}")
    public String getContext(@PathVariable String name) {
        return "client-consumer: " + name;
    }

}
