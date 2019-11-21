package com.ytq.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.Test;

/**
 * @author yuantongqin
 * 2019/10/26
 */
public class Ta {

    private static final String keyToken = "ytq134";

    @Test
    public void ta(){

        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMjMiLCJuaWNrbmFtZSI6IuW8oOS4iSIsImlkIjoiNDU2IiwiZXhwIjoxNTcyMTQzNzIzLCJpYXQiOjE1NzIxNDM3MjN9.8XMw4zaYdcXUl466noSdZW6ffag9pmYinFINsurkRSs";
        Algorithm al = Algorithm.HMAC256(keyToken);
        JWTVerifier verifier = JWT.require(al)
                .build();
        DecodedJWT jwt;
        try {
            jwt = verifier.verify(token);
            String subject = jwt.getSubject();
            System.out.println("是不是");
            System.out.println(subject);
            if(Objects.isNull(subject)){
                System.out.println("空");
            }else{
                System.out.println("不为空");
            }

        }catch (JWTVerificationException e){
            e.printStackTrace();
        }

    }

    @Test
    public void tb(){

        Algorithm al = Algorithm.HMAC256(keyToken);
        String token = JWT.create()
                .withSubject(String.valueOf("123"))
                .withClaim("id","456")
                .withClaim("nickname","张三")
                .withExpiresAt(new Date())
                .withIssuedAt(new Date())
                .sign(al);
        System.out.println(token);
    }

}
