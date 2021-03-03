package com.jt.controller;

import com.jt.pojo.User;
import com.jt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@RestController
@Controller
//@RequestMapping("/user")
//@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<User> users = userService.selectUser();
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        ids.add(4);
        model.addAttribute("userList",users);
        model.addAttribute("msg","走开啦你");
        model.addAttribute("ids",ids);

        return "userList";
    }

}
