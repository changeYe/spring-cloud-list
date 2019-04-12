package com.ytq.test.controller;

import java.io.File;
import java.io.IOException;

import com.ytq.test.entity.User;
import com.ytq.test.utils.Tools;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * yuantongqin
 * 2019/3/25
 */
@RestController
public class ZipController {

    @GetMapping("/hello.do")
    public String sayHello(String name){
        return name+"==你好！";
    }

    @PostMapping("/sayHello.do")
    public String hello(@Validated User user){
        System.out.println(user.getName());
        return "你好："+user.getName();
    }

    @PostMapping("/upload.do")
    public String uploadZip(@RequestParam(value = "fileData") MultipartFile file) {
        try {
            Tools.uncompress(file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  ": OK";
    }

    @PostMapping("/upload1.do")
    public String uploadZip1(@RequestParam(value = "fileData") MultipartFile file) {

        try {
            System.out.println(file.getBytes().length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "hhh";
    }



}
