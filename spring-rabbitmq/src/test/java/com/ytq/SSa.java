package com.ytq;

import java.math.BigDecimal;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ytq.m.annotation.BigDecimalFormat;
import com.ytq.m.annotation.DecimalSerialize;
import org.junit.Test;

/**
 * @author yuantongqin
 * 2019/9/19
 */
public class SSa {

    @BigDecimalFormat("###.##")
    private BigDecimal age;

    @JsonSerialize(using = DecimalSerialize.class)
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

    @Test
    public void ss(){
        String name = Ta.class.getName();
        String simpleName = Ta.class.getSimpleName();
        System.out.println(name);
        System.out.println(simpleName);
    }
}
