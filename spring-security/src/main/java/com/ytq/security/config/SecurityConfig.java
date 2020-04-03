package com.ytq.security.config;

import com.ytq.security.config.filter.AdminAuthorizationFilter;
import com.ytq.security.config.result.FailAccessDeniedHandler;
import com.ytq.security.config.result.LoginFailHandler;
import com.ytq.security.server.impl.AdminAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author yuantongqin
 * description:
 * 2020/4/3
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AdminAuthorizationFilter adminAuthorizationFilter;
    @Autowired
    private AdminAuthService adminUserDetailService;
    @Autowired
    private FailAccessDeniedHandler failAccessDeniedHandler;
    @Autowired
    private LoginFailHandler loginFailHandler;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/login","/register").permitAll()
                .antMatchers(HttpMethod.OPTIONS).permitAll() // 跨域的允许通过
//                .antMatchers("/*").permitAll() // 测试使用
                .anyRequest().authenticated();
        // token 验证处理
        http.addFilterBefore(adminAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
        // 定义未授权与为登录返回结果
        http.exceptionHandling().accessDeniedHandler(failAccessDeniedHandler)
                .authenticationEntryPoint(loginFailHandler);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(adminUserDetailService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
