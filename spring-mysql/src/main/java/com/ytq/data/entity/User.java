package com.ytq.data.entity;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

/**
 * @author yuantongqin
 * 2019/10/30
 */
@Component
public class User {


    private String name = "张三";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
