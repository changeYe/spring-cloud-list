package com.ytq.fault.hundred;

import com.ytq.fault.hundred.exception.HundredException;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yuantongqin
 * description:
 * 2020/4/8
 */
public class Tb {


    @Test
    public void dd(){
        
    }

    @Test
    public void sa(){

        try {
            aa();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("这里是aa的错误");
        }
        try {
            bb();
        }catch (Exception e){
            System.out.println("这里是bb的错误");
            e.printStackTrace();
        }

    }


    @Transactional(value = "12345")
    public void aa(){
        throw HundredException.a();
    }

    public void bb(){
        throw HundredException.a();
    }

    @Test
    public void right() {
        try {
            System.out.println("try");
            throw new RuntimeException("try");
        } finally {
            System.out.println("finally");
            try {
                throw new RuntimeException("finally");
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("finally 异常");
            }
        }
    }

    @Test
    public void sb(){
        int a = cc();
        System.out.println(a);
    }

    public int cc(){
        int a = 0;
        try {
           a = 1;
        }catch (Exception e){
            a = 2;
            return a;
        }finally {
            a = 3;

        }
        return a;
    }

}
