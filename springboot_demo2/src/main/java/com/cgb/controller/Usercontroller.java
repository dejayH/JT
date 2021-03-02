package com.cgb.controller;

import com.cgb.pojo.JsonResult;
import com.cgb.pojo.UserPojo;
import com.cgb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class Usercontroller {

    @Autowired
    private UserService userService;

    @GetMapping
    public JsonResult findUser(){
        List user = userService.findUser();
        System.out.println(user);

        return new JsonResult(user);
    }

}
