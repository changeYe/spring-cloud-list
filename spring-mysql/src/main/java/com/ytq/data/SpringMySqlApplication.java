package com.ytq.data;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yuantongqin
 * 2019/10/22
 */
@SpringBootApplication
@MapperScan(value = {"com.ytq.data.dao"})
public class SpringMySqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMySqlApplication.class, args);
    }
}
