package com.cgb.contorller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;

@RequestMapping("/hello")
@RestController
public class HelloController {

    @GetMapping
    public String sayHello(){
        return "hello Springboot";
    }
}
