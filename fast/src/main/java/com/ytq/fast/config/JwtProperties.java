package com.ytq.fast.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author yuantongqin
 * description:
 * 2020/3/28
 */
@Data
@ConfigurationProperties("jwt")
public class JwtProperties {

    private String secretKey;
    private Integer expiration;
    private String tokenHeader;
    private String tokenHead;

}


