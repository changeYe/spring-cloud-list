package com.ytq.fast.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuantongqin
 * description:
 * 2020/3/15
 */
@RestController
@Api(tags = "普通",value = "普通的api")
public class FastController {

    @GetMapping("/hello")
    @ApiOperation(value = "hello接口",httpMethod = "GET")
    @ApiImplicitParams({@ApiImplicitParam(name = "name",value = "name描述")})
    public String hello(String name){
        return name + "你好！";
    }

    @GetMapping("/sentry/wrong")
    @ApiOperation("错误")
    public String wrong(@ApiParam(name = "name",value = "name描述") String name){
//        int x = 1 / 0;
        return "Hello World!";
    }

}
