package com.ytq.fast;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.ytq.fast.entity.User;

/**
 * @author yuantongqin
 * 2019/8/1
 */
public class Ta {

    public void ss(){
        User user = new User();
        user.setName("张三");
        user.setAddress("上海");
        user.setAge(10);
        Class<? extends User> beanType = user.getClass();
        Map<String,Field> fieldCacheMap = new HashMap<String,Field>();
        ParserConfig.parserAllFieldToCache(beanType, fieldCacheMap);


    }

}
