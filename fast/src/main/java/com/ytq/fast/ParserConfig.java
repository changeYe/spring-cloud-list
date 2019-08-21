package com.ytq.fast;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author yuantongqin
 * 2019/8/1
 */
public class ParserConfig {

    public static void  parserAllFieldToCache(Class<?> clazz,Map</**fieldName*/String , Field> fieldCacheMap){
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            if (!fieldCacheMap.containsKey(fieldName)) {
                fieldCacheMap.put(fieldName, field);
            }
        }
        if (clazz.getSuperclass() != null && clazz.getSuperclass() != Object.class) {
            parserAllFieldToCache(clazz.getSuperclass(), fieldCacheMap);
        }
    }


    public void sa(Class<?> clazz){
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            field.getName();
        }

    }

}
