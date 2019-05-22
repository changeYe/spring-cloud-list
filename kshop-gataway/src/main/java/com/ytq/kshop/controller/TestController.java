package com.ytq.kshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuantongqin
 * 2019/4/24
 */
@RestController
public class TestController {

    @GetMapping("/hello.do")
    public String hello(String name){
        return name+": 你好";
    }

}
