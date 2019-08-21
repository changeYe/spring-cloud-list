package com.ytq.m.controller;

import javax.validation.Valid;

import com.ytq.m.entity.HelloDTO;
import com.ytq.m.validate.VdataUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuantongqin
 * 2019/7/31
 */
@RestController
public class TestController {

    Logger logger = LoggerFactory.getLogger(TestController.class);

//    @Value("${ad.namea}")
//    private String namea;

    @PostMapping("/hello.do")
    public String hello(@Validated @RequestBody HelloDTO name){
        VdataUtil<HelloDTO> vdataUtil = new VdataUtil();
        vdataUtil.verification(name);

        logger.info("==name:"+name);
        return "你好:"+name;
    }


}
