package com.ytq.fast;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ytq.fast.design.ConcreteProtoType;
import com.ytq.fast.design.Prototype;
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

    public static void main(String[] args) {
        String str1= "abc";
        String str2= new String("abc");
        // 之引用值,并不引用对象
        String str3= str2.intern();
        System.out.println(str1==str2);
        System.out.println(str2==str3);
        System.out.println(str1==str3);

        ConcreteProtoType co = new ConcreteProtoType();
        System.out.println(co.hashCode());
        ConcreteProtoType clone = (ConcreteProtoType) co.clone();

        System.out.println(clone.hashCode());

        try {
            Class<?> aClass = Class.forName("com.ytq.fast.entity.ColumnTypeDTO$Param");
            System.out.println(aClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



}
