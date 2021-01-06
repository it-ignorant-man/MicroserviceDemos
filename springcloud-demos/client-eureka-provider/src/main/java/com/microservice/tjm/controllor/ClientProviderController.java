package com.microservice.tjm.controllor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClientProviderController:
 *
 * @author: tjm
 * @date: 2020/12/14 13:44
 */
@RestController
@RefreshScope
public class ClientProviderController {
    @Value("${value}")
    private String userName;

    @GetMapping("/users/{userName}")
    public String user(@PathVariable String userName) {
        return "user: " + this.userName;
    }
}
