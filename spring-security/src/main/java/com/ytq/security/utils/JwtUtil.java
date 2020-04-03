package com.ytq.security.utils;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ytq.security.config.filter.JwtProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author yuantongqin
 * description:
 * 2020/3/26
 */
@EnableConfigurationProperties(JwtProperties.class)
@Component
public class JwtUtil {

    private static final Logger LOG = LoggerFactory.getLogger(JwtUtil.class);

    @Autowired
    private JwtProperties jwtProperties;


    private static ConcurrentHashMap<String,Algorithm> algorithmMap = new ConcurrentHashMap<>(8);
    private static ConcurrentHashMap<String,DecodedJWT> decodedJWTMap = new ConcurrentHashMap<>(8);

    /**
     * 根据秘钥获取算法对象
     */
    public Algorithm getAlgorithm(String secretKey){
        if(StringUtils.isEmpty(secretKey)){
            return null;
        }
        return algorithmMap.computeIfAbsent(secretKey, key -> Algorithm.HMAC512(key));
    }

    /**
     * 用于根据登录用户信息生成token
     * @return
     */
    public String generateToken(String userName){
        Algorithm algorithm = getAlgorithm(jwtProperties.getSecretKey());
        String sign = JWT.create()
                .withSubject(userName)
                .withExpiresAt(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(jwtProperties.getExpiration())))
                .withIssuedAt(new Date()).sign(algorithm);
        return sign;
    }

    /**
     * ：从token中获取登录用户的信息
     */
    public String getUserNameFromToken(String token){
        DecodedJWT decodedJWT = validateToken(token);
        String username = decodedJWT.getSubject();
        if(StringUtils.isEmpty(username)){
            LOG.error("从token活用用户信息为空");
            return null;
        }
        if (isTokenExpired(decodedJWT)) {
            LOG.error("token信息已失效");
            return null;
        }
        return username;
    }

    /**
     * ：判断token是否还有效
     */
    public DecodedJWT validateToken(String token){
        return decodedJWTMap.computeIfAbsent(token, key -> {
            Algorithm algorithm = getAlgorithm(jwtProperties.getSecretKey());
            JWTVerifier build = JWT.require(algorithm).build();
            DecodedJWT verify = null;
            try {
                verify = build.verify(token);
            } catch (Exception e) {
                LOG.error("token 无效", e);
            }
            return verify;
        });
    }

    /**
     * 判断token是否已经失效
     */
    public boolean isTokenExpired(String token) {
        Date expiresAt = validateToken(token).getExpiresAt();
        return expiresAt.before(new Date());
    }

    public boolean isTokenExpired(DecodedJWT decodedJWT) {
        Date expiresAt = decodedJWT.getExpiresAt();
        return expiresAt.before(new Date());
    }

    public void ss(String token){
        DecodedJWT verify = validateToken(token);

        verify.getExpiresAt();

    }



}
