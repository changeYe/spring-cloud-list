package com.ytq.jwt.utils;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author yuantongqin
 * description:
 * 2020/3/26
 */
@Component
public class JwtUtil {

    private static final Logger LOG = LoggerFactory.getLogger(JwtUtil.class);

    @Value("${secretKey}")
    private String secretKey;
    // 过期时间 秒
    @Value("${expiration}")
    private Integer expiration;


    private static ConcurrentHashMap<String,Algorithm> algorithmMap = new ConcurrentHashMap<>(8);

    /**
     * 根据秘钥获取算法对象
     */
    public Algorithm getAlgorithm(String secretKey){
        if(StringUtils.isEmpty(secretKey)){
            return null;
        }
        return algorithmMap.computeIfPresent(secretKey, (key, algorithm) -> {
            if(algorithm == null){
                return Algorithm.HMAC512(key);
            }
            return algorithm;
        });
    }

    /**
     * 用于根据登录用户信息生成token
     * @return
     */
    public String generateToken(String userId){
        Algorithm algorithm = getAlgorithm(secretKey);
        String sign = JWT.create()
                .withSubject(userId)
                .withExpiresAt(new Date(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(expiration)))
                .withIssuedAt(new Date()).sign(algorithm);
        return sign;
    }

    /**
     * ：从token中获取登录用户的信息
     */
    public String getUserIdFromToken(String token){
        DecodedJWT decodedJWT = validateToken(token);
        String userId = decodedJWT.getSubject();
        if(StringUtils.isEmpty(userId)){
            LOG.error("从token活用用户信息为空");
            return null;
        }
        return userId;
    }

    /**
     * ：判断token是否还有效
     */
    public DecodedJWT validateToken(String token){
        Algorithm algorithm = getAlgorithm(secretKey);
        JWTVerifier build = JWT.require(algorithm).build();
        DecodedJWT verify = null;
        try {
            verify = build.verify(token);
        }catch (Exception e){
            LOG.error("token 无效", e);
        }
        return verify;
    }



}
