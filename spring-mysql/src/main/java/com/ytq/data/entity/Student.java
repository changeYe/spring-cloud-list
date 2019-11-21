package com.ytq.data.entity;

import org.springframework.stereotype.Component;

/**
 * @author yuantongqin
 * 2019/10/30
 */
@Component
public class Student {

    private String name = "李四";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
