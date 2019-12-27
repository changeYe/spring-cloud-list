package com.ytq.study.jvm;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @author yuantongqin
 * description:
 * 2019/12/3
 */
public class JavaMethodAreaOOM {

    /**
     * 动态代理,反射
     * 元空间不是保存在jvm内存中,而是保存在本地内存中
      */
    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                    return proxy.invokeSuper(obj, args);
                }
            });
            //无限创建动态代理，生成Class对象
            enhancer.create();
        }
    }



    static class OOMObject {

    }
}
