package com.ytq.study;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * @author yuantongqin
 * 2019/11/21
 */
public class StudyApplication {

    public static void main(String[] args) {

        BigDecimal a = BigDecimal.valueOf(10.11);
        BigDecimal b = BigDecimal.valueOf(9.91);
        BigDecimal c = a.multiply(b).setScale(2,BigDecimal.ROUND_HALF_UP);
        System.out.println(c);


    }


}
