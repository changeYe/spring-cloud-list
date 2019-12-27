package com.ytq.fast.intercept;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ytq.fast.config.LoginCheck;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author yuantongqin
 * description:
 * 2019/12/22
 */
@Component
@Slf4j
public class LoginIntercept implements PathIntercept {

    @Override
    public String pathPattern() {
        return "/**";
    }

    @Resource
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler != null && handler instanceof HandlerMethod){
            HandlerMethod hm = (HandlerMethod) handler;
            // 发现类中是否有注解
            AnnotationUtils.findAnnotation(handler.getClass(), LoginCheck.class);
            LoginCheck loginCheck = hm.getClass().getAnnotation(LoginCheck.class);
            // 如果有登录注解,从request中获取token信息
            if(loginCheck != null){
                // 第一种方式jwt
                String accessToken = request.getHeader("accessToken");
                if(!StringUtils.isEmpty(accessToken)){
                    // 根据AccessToken获取用户信息
                }

                // 第二种方式sessionId
//                request.getCookies();

            }

        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
