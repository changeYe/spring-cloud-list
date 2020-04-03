package com.ytq.jwt;

import java.util.concurrent.ForkJoinPool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yuantongqin
 * description:
 * 2020/3/25
 */
@SpringBootApplication
public class JwtApp {

    public static void main(String[] args) {
        SpringApplication.run(JwtApp.class,args);

        ForkJoinPool forkJoinPool = new ForkJoinPool(10);
        forkJoinPool.execute(()->{

        });
    }
}
