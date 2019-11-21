package com.algorithm;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Scanner;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @author yuantongqin
 * 2019/11/7
 */
public class AesArithmetic {
    //对数据进行加密处理
    /*
     * 加密
     * 1.构造密钥生成器
     * 2.根据ecnodeRules规则初始化密钥生成器
     * 3.产生密钥
     * 4.创建和初始化密码器
     * 5.内容加密
     * 6.返回字符串
     */
    public  String AESEncode(String encodeRules,String content){
        try {
            //1.构造密钥生成器，指定为AES算法,不区分大小写
            KeyGenerator keygen=KeyGenerator.getInstance("AES");
            //2.根据ecnodeRules规则初始化密钥生成器
            //生成一个128位的随机源,根据传入的字节数组
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(encodeRules.getBytes());
            keygen.init(128, secureRandom);
            //keygen.init(128, new SecureRandom(encodeRules.getBytes()));
            //3.产生原始对称密钥
            SecretKey original_key=keygen.generateKey();
            //4.获得原始对称密钥的字节数组
            byte [] raw=original_key.getEncoded();
            //5.根据字节数组生成AES密钥
            SecretKey key=new SecretKeySpec(raw, "AES");
            //6.根据指定算法AES自成密码器
            Cipher cipher=Cipher.getInstance("AES");
            //7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.ENCRYPT_MODE, key);
            //8.获取加密内容的字节数组(这里要设置为utf-8)不然内容中如果有中文和英文混合中文就会解密为乱码
            byte [] byte_encode=content.getBytes("utf-8");
            //9.根据密码器的初始化方式--加密：将数据加密
            byte [] byte_AES=cipher.doFinal(byte_encode);
            //10.将加密后的数据转换为字符串
            //这里用Base64Encoder中会找不到包
            //解决办法：
            //在项目的Build path中先移除JRE System Library，再添加库JRE System Library，重新编译后就一切正常了。
            String AES_encode=new String(new BASE64Encoder().encode(byte_AES));
            //11.将字符串返回
            return AES_encode;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //如果有错就返加nulll
        return null;
    }

    /*
     * 解密
     * 解密过程：
     * 1.同加密1-4步
     * 2.将加密后的字符串反纺成byte[]数组
     * 3.将加密内容解密
     */
    public  String AESDncode(String encodeRules,String content){
        try {
            //1.构造密钥生成器，指定为AES算法,不区分大小写
            KeyGenerator keygen=KeyGenerator.getInstance("AES");
            //2.根据ecnodeRules规则初始化密钥生成器
            //生成一个128位的随机源,根据传入的字节数组
		           /* SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
		            random.setSeed(encodeRules.getBytes());*/
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG" );
            secureRandom.setSeed(encodeRules.getBytes());
            keygen.init(128,secureRandom);
            //keygen.init(128, new SecureRandom(encodeRules.getBytes()));
            //3.产生原始对称密钥
            SecretKey original_key=keygen.generateKey();
            //4.获得原始对称密钥的字节数组
            byte [] raw=original_key.getEncoded();
            //5.根据字节数组生成AES密钥
            SecretKey key=new SecretKeySpec(raw, "AES");
            //6.根据指定算法AES自成密码器
            Cipher cipher=Cipher.getInstance("AES");
            //7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.DECRYPT_MODE, key);
            //8.将加密并编码后的内容解码成字节数组
            byte [] byte_content= new BASE64Decoder().decodeBuffer(content);
            /*
             * 解密
             */
            byte [] byte_decode=cipher.doFinal(byte_content);
            String AES_decode=new String(byte_decode,"utf-8");
            return AES_decode;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }

        //如果有错就返加nulll
        return null;
    }


    public static void main(String[] args) {

		/*String test="UgczfjEpU9a1dKzd+2nnw4TG/TAPqwzYai/rMP+j5oSBn0ASp1bldhcWGE14I7fCZvXUV7VE2D0PCnXtGOTMmzIkAC2mjdry61zHamgWKu69HI2NCsTthlyhAtBNtVRmZbUi0O0ZKdG27tlKDaZj9tE52Ews/I1eM6JlmRUBMNxV7JLHX6fi9jGnmCpKWdIjpPQ2IUyrofokTfitmfFM7AdYJu9edbnyQ+lqQ/bvg9tTG/Xj0KCBzLz4U3XP0FM4e8Uqt1CNe8m2LbaCDng7T6X7A4a0Si0/qWagUxtKUAhFFHgEq4dQU6M+bUqXwLnBFB1rUcq9DhdpoLK59ThTt6i4AfqMGjFnEcMVbSFrLVHKgmftc4QxmLoHDfYW5uyqXdWyxRcNvBUyoBSrjLVl5QC07tFJtJ6+w8//XJXIDl69b08IZlx0ip3Yh5EpUiEDKUt21DkvjF2n0k3dlR+ibX2DSdbsgK6GrnXRnisaaszu7p9Sd5TMZqumxltj30qgbC9lcDwLwJHXVhg+CvTMXkNy2+TFoFmXj2jW5sE6ii8qN62gJhxsjQt/3TCR4UnqsfiZHNaZjLVDE3a1aXFdURP6DPnkgp36DIJVDs5C1dM=";
		String testkey="(蒙A837EM,02)";
		DataEncryptionAES se=new DataEncryptionAES();
		 System.out.println("根据输入的规则解密后的明文是:"+se.AESDncode(testkey, test));*/
        long l = System.currentTimeMillis();
        AesArithmetic se=new AesArithmetic();
////        Scanner scanner=new Scanner(System.in);
//
//        // * 加密
////
////        System.out.println("使用AES对称加密，请输入加密的规则");
//        String encodeRules="hhhh";
//        System.out.println("请输入要加密的内容:");
//        String content = "1111";
////        System.out.println("根据输入的规则"+encodeRules+"加密后的密文是:");
////
////        String ciphertext = se.AESEncode(encodeRules, content);
////        System.out.println(ciphertext);
//        // * 解密
//
//        System.out.println("使用AES对称解密，请输入加密的规则：(须与加密相同)");
//        encodeRules="hhhh";
//        System.out.println("请输入要解密的内容（密文）:");
//        content = "MllkI6ShlCUICFHc49RG3g==";
//        System.out.println("根据输入的规则"+encodeRules+"解密后的明文是:"+se.AESDncode(encodeRules, content));

        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);
    }


}
