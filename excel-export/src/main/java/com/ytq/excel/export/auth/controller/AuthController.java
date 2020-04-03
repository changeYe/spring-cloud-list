package com.ytq.excel.export.auth.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuantongqin
 * description:
 * 2020/3/28
 */
@RestController
@Slf4j
public class AuthController {

    @GetMapping("/hello")
    public String hello(){
        return "nihao";
    }

    @GetMapping("/user")
    public Authentication getUser(Authentication authentication) {
        log.info("resource: user {}", authentication);
        return authentication;
    }

}
