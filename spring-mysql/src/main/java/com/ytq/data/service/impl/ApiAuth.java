package com.ytq.data.service.impl;

import java.util.Map;
import java.util.stream.Collectors;

import com.ytq.data.dto.ApiOAuthDTO;
import com.ytq.data.util.MD5Digest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author yuantongqin
 * description:
 * 2020/3/11
 */
@Component
@Slf4j
public class ApiAuth {

    /**
     * 有效期为5分钟
     */
    private static final Long expire = 5 * 60 * 1000L;
    /**
     * 秘钥
     */
    @Value("${secretApp}")
    private String secretApp;

    private String token;
    /**
     * 是否过期
     */
    public boolean isExpire(Long timestamp){
        long currentTime = System.currentTimeMillis();
        if(currentTime - timestamp > expire){
            log.error("token 已经过期");
            return true;
        }
        return false;
    }

    /**
     * 验证token
     * @param param
     * @param password
     * @return
     */
    public boolean auth(ApiOAuthDTO.Param param,String password){
        StringBuffer sb = new StringBuffer();
        sb.append("userName="+param.getUserName());
        sb.append("&password="+password);
        sb.append("&timestamp="+param.getTimestamp());
        sb.append("&secret="+secretApp);
//        String token = generateToken(new HashMap<>());
        System.out.println(sb.toString());
        String md5Str = MD5Digest.getMD5Str(sb.toString());
        System.out.println(md5Str);
        if(!md5Str.equals(param.getToken())){
            log.error("签名错误！");
            return false;
        }
        return true;
    }

    public String generateToken(Map<String,String> param){
        if(param == null){
            return null;
        }
        String collect = param.keySet().stream().sorted(String::compareTo)
                .map(info -> "&" + info + "=" + param.get(info)).collect(Collectors.joining());
        System.out.println(collect);
        return collect;
    }


}
