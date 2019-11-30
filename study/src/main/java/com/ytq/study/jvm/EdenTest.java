package com.ytq.study.jvm;

/**
 * @author yuantongqin
 * 2019/11/22
 */
public class EdenTest {

    public static void main(String[] args) {
        System.out.println("cc");
//        byte[] bytes = new byte[20 * 1024 * 1024];

//        String[] s = new String[1024*1024];
//        User[] ss = new User[1];
        int a  = 10;
        int c = 1+a;
//        ss[0] = new User();
//        ss[0].getS();
        User user = getUser();
        user.setAge(10);


    }

    public static User getUser(){
        User u = new User();
        return u;
    }

}
