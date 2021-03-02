package com.cgb.contorller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {
    @Value("${redis.host}")
    private String host;
    @Value("${redis.port}")
    private String port;

    @GetMapping
    public String getNode(){
        return "redis节点:"+host+":"+port;
    }
}
