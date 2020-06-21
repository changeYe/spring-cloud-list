package com.ytq;

import java.io.IOException;
import java.math.BigDecimal;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ytq.m.Application;
import com.ytq.m.entity.HelloDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author yuantongqin
 * 2019/8/1
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
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

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void ssb(){
//        ObjectMapper objectMapper = new ObjectMapper();

        SSa sSa = new SSa();
        sSa.setAge(new BigDecimal(10));
        sSa.setName("续航撒");
        try {
            String s = objectMapper.writeValueAsString(sSa);
            System.out.println(s);

            SSa sSa1 = objectMapper.readValue(s, SSa.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
