package com.kunchi.spring.api.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;
import com.kunchi.spring.model.exception.ISBException;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanMap;

/**
 * yuantongqin
 * 2019/3/4
 */
public class ISBBeanUtil {

    /**
     * 对象转换成map
     */
    public static  <T> Map<String,Object> BeanToMap(T bean){
        HashMap<String, Object> map = Maps.newHashMap();
        BeanMap beanMap = BeanMap.create(bean);
        for (Object key : beanMap.keySet()) {
            if(beanMap.get(key) == null){
                continue;
            }
            map.put(key.toString(),beanMap);
        }
        return map;
    }


    public static <T,P> List<T> convertToDTOList(Class<T> tClass, List<P> poList){
        if(poList == null){
            return null;
        }
        List<T> targetList = new ArrayList<>(poList.size());
        try {
            T instance = tClass.newInstance();
            for (P p : poList) {
                BeanUtils.copyProperties(p,instance);
                targetList.add(instance);
            }

        } catch (InstantiationException e) {
            throw new ISBException("0", "系统异常:在尝试convertToDtoList时发生了错误, 请检查PO和DTO是否可以相互copy属性",e);
        } catch (IllegalAccessException e) {
            throw new ISBException("0", "系统异常:在尝试convertToDtoList时发生了错误, 请检查PO和DTO是否可以相互copy属性", e);

        }
        return targetList;
    }


}
