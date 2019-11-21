package com.ytq.data.controller;

import javax.validation.Valid;

import com.ytq.data.dao.OrderMapper;
import com.ytq.data.design.CurtainDecorator;
import com.ytq.data.design.Decorator;
import com.ytq.data.design.IDecorator;
import com.ytq.data.entity.Tb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuantongqin
 * 2019/10/22
 */
@RestController
public class OrderController {
//
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private CurtainDecorator curtainDecorator;


    @PostMapping("/hello.do")
    public String hello(@Validated @RequestBody Tb tb){
        orderMapper.getOrderById(tb.getId());

//        curtainDecorator.decorate();
        return "id = "+tb.toString();
    }




}
