package com.ytq.security.config.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.ytq.security.server.impl.AdminAuthService;
import com.ytq.security.utils.JwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @author yuantongqin
 * description:
 * 2020/4/3
 */
@Component
public class AdminAuthorizationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AdminAuthService adminAuthService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String accessToken = request.getHeader("accessToken");
        // 如果是需要认证的api，需要判断token是否有效
        if(StringUtils.isNotEmpty(accessToken)){
            // 认证token信息有效性
            String userName = jwtUtil.getUserNameFromToken(accessToken);
            if(StringUtils.isNotEmpty(userName) && SecurityContextHolder.getContext().getAuthentication() ==null){
                //认证用户信息
                UserDetails userDetails = adminAuthService.loadUserByUsername(userName);
                // 拿到权限
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails.getUsername(),
                                                                userDetails.getPassword(),
                                                                userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        filterChain.doFilter(request,response);
    }
}
