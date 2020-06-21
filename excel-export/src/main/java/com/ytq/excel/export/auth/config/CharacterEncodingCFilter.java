package com.ytq.excel.export.auth.config;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author yuantongqin
 * description: 字符编码过滤器
 * 2020/5/22
 */
@WebFilter(urlPatterns = "/*",filterName = "CharacterEncodingCFilter")
@Component
public class CharacterEncodingCFilter implements Filter {

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
        }

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            servletRequest.setCharacterEncoding("UTF-8");
            servletRequest.setCharacterEncoding("UTF-8");
            servletResponse.setContentType("application/json;charset=UTF-8");
            filterChain.doFilter(servletRequest , servletResponse);
        }

        @Override
        public void destroy() {

        }

}


