package com.ytq.data.controller;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;

import java.util.List;
import java.util.Set;

import com.ytq.data.config.valid.ISBResult;
import com.ytq.data.dao.OrderMapper;
import com.ytq.data.design.CurtainDecorator;
import com.ytq.data.dto.ApiOAuthDTO;
import com.ytq.data.entity.Card;
import com.ytq.data.entity.Tb;
import com.ytq.data.service.OrderService;
import com.ytq.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    @PostMapping("/bind/card")
    public String bindCard(@Valid @RequestBody Tb tb){
        return null;
    }

    @PostMapping("/hello.do")
    public String hello(@Valid @RequestBody  Tb tb){
        ISBResult<List<Card>> isb = new ISBResult<>();
        isb.setBody(tb.getCards());
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        List<Card> cards = tb.getCards();
        for (Card card : cards) {
            Set<ConstraintViolation<Card>> validates = validator.validate(card);
            StringBuffer sb = new StringBuffer();
            for(ConstraintViolation constraintViolation:validates) {
                sb.append("字段："+constraintViolation.getPropertyPath().toString()+"--").append(constraintViolation.getMessage());
            }
            if(sb.length() > 0){
                throw new RuntimeException(sb.toString());
            }
        }

        int a = 10;
//        orderMapper.getOrderById(tb.getId());

//        curtainDecorator.decorate();
        return "id = "+tb.toString();
    }

    @GetMapping("/say")
    public String say(String say){
        orderService.sendMessage(say);
        return "你好："+say;
    }


    @PostMapping("/auth")
    public String apiOAuth(@Validated @RequestBody ApiOAuthDTO.Param authDTO){
        Boolean aBoolean = userService.ApiOAuthByName(authDTO);
        return "是否成功："+aBoolean;
    }



}
