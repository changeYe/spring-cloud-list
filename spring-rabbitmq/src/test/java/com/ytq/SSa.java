package com.ytq;

import java.math.BigDecimal;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ytq.m.annotation.BigDecimalFormat;

/**
 * @author yuantongqin
 * 2019/9/19
 */
public class SSa {

    @BigDecimalFormat("###.##")
    private BigDecimal age;

    @JsonSerialize()
    private String name;

    public BigDecimal getAge() {
        return age;
    }

    public void setAge(BigDecimal age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
