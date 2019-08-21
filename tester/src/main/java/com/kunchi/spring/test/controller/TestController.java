package com.kunchi.spring.test.controller;

import com.kunchi.spring.test.service.DogService;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private DogService service;

    @GetMapping("getdog")
    public String getDog(@Length(max = 10) String name){
        return name+":过来";
    }



}
