package com.ytq.study.jvm;

import java.io.Serializable;

/**
 * @author yuantongqin
 * 2019/11/21
 */
public class JvmStudy implements Serializable {

    private String name;
    private int age;
    private int a ;
    private User user;
    private int d = 10;

    private final String address = "shanghai";
    private static String phone = "12345";

     {
        this.a = 10;
    }

    public int ss(int c){
        this.age = c +10;
        User u = new User();
        aa();
        return u.getAge();
    }

    public void aa(){

    }

    public JvmStudy() {

    }


}
