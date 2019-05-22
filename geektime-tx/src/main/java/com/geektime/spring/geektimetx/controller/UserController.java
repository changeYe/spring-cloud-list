package com.geektime.spring.geektimetx.controller;

import com.geektime.spring.geektimetx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuantongqin
 * 2019/5/12
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello.do")
    public String hello(String name){
        userService.getUser();
        return name+":你好";
    }
}
