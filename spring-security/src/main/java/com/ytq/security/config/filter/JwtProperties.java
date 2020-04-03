package com.ytq.security.config.filter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author yuantongqin
 * description:
 * 2020/4/3
 */
@ConfigurationProperties("jwt")
@Data
public class JwtProperties {

    // 秘钥
    private String secretKey;

    // 过期时间
    private Long expiration;



}
