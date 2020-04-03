package com.ytq.security.controller;

import com.ytq.security.model.dto.UserDTO;
import com.ytq.security.model.dto.UserLoginDTO;
import com.ytq.security.server.UserServer;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuantongqin
 * description:
 * 2020/3/30
 */
@RestController
public class AdminController {

    @Autowired
    private UserServer userServer;

    @PostMapping("/login")
    public UserLoginDTO.Result login(@Validated @RequestBody UserLoginDTO.Param userDTO){
        return userServer.login(userDTO);
    }

    @GetMapping("/user")
    @PreAuthorize("hasAuthority('user:read')")
    @ApiOperation("获取用户")
    public String getUser(@RequestParam(value = "userId") Long userId){
        userServer.getUser(new UserDTO.Param().setUserId(userId));
        return "这是用户信息";
    }

    @GetMapping("/hello")
    @PreAuthorize("hasAuthority('user:write')")
    @ApiOperation("获取用户")
    public String hello(){
        userServer.getUser(new UserDTO.Param().setUserId(2L));
        return "这是用户信息";
    }


}
