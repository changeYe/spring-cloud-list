package com.ytq.data.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang3.StringUtils;

/**
 * @author yuantongqin
 * description:
 * 2020/3/11
 */
public class MD5Digest {

    public static String getMD5Str(String param){
        if (StringUtils.isBlank(param)){
            return null;
        }
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            // 对字符串进行加密
            md5.update(param.getBytes());
            // 加密之后的byte数据
            byte[] encryptStr = md5.digest();
            int i;
            StringBuffer sb = new StringBuffer();
            for (int offset = 0; offset < encryptStr.length; offset++) {
                i = encryptStr[offset];
                if (i < 0){
                    i+=256;
                }
                if(i < 16){
                    sb.append(0);
                }
                //通过Integer.toHexString方法把值变为16进制
                sb.append(Integer.toHexString(i));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

}
