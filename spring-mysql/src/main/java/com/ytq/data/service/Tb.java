package com.ytq.data.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author yuantongqin
 * 2019/10/30
 */
@Component
public class Tb implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("启动是运行");
    }
}
