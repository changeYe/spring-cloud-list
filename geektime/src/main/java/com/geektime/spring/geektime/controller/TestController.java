package com.geektime.spring.geektime.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuantongqin
 * 2019/5/11
 */
@RestController
public class TestController {

    @GetMapping("/hello.do")
    public String sayHello(String name){
        return name+"：你好";
    }

}
