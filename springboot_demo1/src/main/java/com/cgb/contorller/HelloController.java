package com.cgb.contorller;

import com.cgb.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")
@RestController
public class HelloController {

    @GetMapping
    public String sayHello(){
        return "hello Springboot";
    }

    @PostMapping
    public String setUser(){
        User user = new User();
        user.setAge(0).setId(0).setSex("ou").setName("fy");
        return "";
    }
}
