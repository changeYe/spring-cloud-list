package com.ytq.fast.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuantongqin
 * description:
 * 2020/3/15
 */
@RestController
public class FastController {

    @GetMapping("/hello")
    public String hello(){
        return "你好！";
    }

}
