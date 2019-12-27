package com.ytq.fast.intercept;

import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author yuantongqin
 * description:
 * 2019/12/22
 */
public interface PathIntercept extends HandlerInterceptor {

    /**
     * 拦截的url
     * @return
     */
    default String pathPattern(){
        return "/**";
    };

}
