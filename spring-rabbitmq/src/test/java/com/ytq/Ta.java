package com.ytq;

import com.alibaba.fastjson.JSON;
import com.ytq.m.entity.HelloDTO;
import org.junit.Test;

/**
 * @author yuantongqin
 * 2019/8/1
 */
public class Ta {


    @Test
    public void ss(){

        HelloDTO helloDTO = new HelloDTO();
        helloDTO.setName("张三");
        helloDTO.setAddress("上海");
        helloDTO.setAge(10);
        helloDTO.setPhone("123456");
        String s = JSON.toJSONString(helloDTO);
        System.out.println(s);
    }

    public void sa(){
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
    }
}
