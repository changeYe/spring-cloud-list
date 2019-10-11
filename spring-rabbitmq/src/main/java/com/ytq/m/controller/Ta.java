package com.ytq.m.controller;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yuantongqin
 * 2019/7/31
 */
public class Ta {

    public void ss(){

        try {
            int a = 10;
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void ssa(){
        synchronized (Ta.this){
            System.out.println("hhh");
        }
    }

}