package com.ytq.fast.config.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author yuantongqin
 * description:
 * 2020/3/27
 */
@Component
@Slf4j
public class TimerFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("过滤之前");
        long before = System.currentTimeMillis();
        filterChain.doFilter(servletRequest,servletResponse);
        long after = System.currentTimeMillis();
        log.info("过滤之后:"+(after-before));
    }

    @Override
    public void destroy() {

    }
}
