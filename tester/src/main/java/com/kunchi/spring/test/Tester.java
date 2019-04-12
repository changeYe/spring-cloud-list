package com.kunchi.spring.test;

import java.util.regex.Pattern;

import org.springframework.http.HttpStatus;

public class Tester {

    public static void main(String[] args) {

        System.out.println("");
//        HttpStatus
        String name = "123456789111-web1.png";
        String key = name.substring(1,name.lastIndexOf("."));
        System.out.println(key);
        boolean matches = Pattern.matches("^\\d{2,14}-(web|mob|main)[1-5].(png|jpg)$", name);
        System.out.println(matches);

    }



}
