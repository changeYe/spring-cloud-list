package com.ytq.fast.config.result;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ytq.fast.dto.YtqResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

/**
 * @author yuantongqin
 * description: 当用户没有访问权限时的处理器，用于返回JSON格式的处理结果；
 * 2020/3/28
 */
@Component
@Slf4j
//public class RestfulAccessDeniedHandler implements AuthenticationFailureHandler {
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        String msg = HttpStatus.UNAUTHORIZED.getReasonPhrase() + accessDeniedException.getMessage();
        YtqResult<String> result = new YtqResult<>();
        result.setCode(HttpStatus.UNAUTHORIZED.value())
                .setMessage(msg);
        log.error("没有权限访问！",accessDeniedException);
        response.getWriter().write(objectMapper.writeValueAsString(result));
        response.getWriter().flush();

    }
}
