package com.geektime.spring.geektimetx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class GeektimeTxApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeektimeTxApplication.class, args);
    }

}
