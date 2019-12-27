package com.ytq.fast.config;

import com.ytq.fast.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author yuantongqin
 * description:
 * 2019/12/21
 */
@Configuration
public class FastConfig {

    @Bean(initMethod = "",destroyMethod = "")
    @Scope("SCOPE_PROTOTYPE")
    public User user(){
        return null;
    }



}
