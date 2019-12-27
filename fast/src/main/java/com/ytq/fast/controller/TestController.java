package com.ytq.fast.controller;

import com.ytq.fast.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuantongqin
 * description:
 * 2019/12/13
 */
@RestController
public class TestController {

    @Autowired
    private HelloService helloService;

    /**
     * 事件测试
     */
    @GetMapping("/hello")
    public String hello(String name) {
        helloService.testHello(name);
        return name + "你好!";
    }

    /**
     * 防止接口的重复提交
     * 幂等处理
     */
    @GetMapping("")
    public void repeatSubmit(){

    }

}
