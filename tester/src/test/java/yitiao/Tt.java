package yitiao;

import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.Security;
import java.security.Signature;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yit.openapi.sdk.client.util.Base64Util;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.Assert.assertTrue;

/**
 * @author yuantongqin
 * 2019/5/7
 */
public class Tt {




        private static final Logger logger = LoggerFactory.getLogger(Tt.class);

        //regist Security Provider,use BouncyCastleProvider
        static {
            Security.addProvider(new BouncyCastleProvider());
        }

        /**
         * sign
         *
         * @param privateKeyStr privatekey base64
         * @param content
         * @return
         */
        public static String sign(String privateKeyStr, byte[] content) {
            if (privateKeyStr == null || privateKeyStr.length() == 0) {
                throw new RuntimeException("private key is empty.");
            }
            if (content == null) {
                return null;
            }
            RSAPrivateCrtKey privateKey = null;
            try {
                KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                privateKey = (RSAPrivateCrtKey) keyFactory.generatePrivate(new PKCS8EncodedKeySpec(Base64Util.decode(privateKeyStr)));
            } catch (Exception e) {
                throw new RuntimeException("init private key failed!", e);
            }
            String sig = null;
            try {
                Signature signature = Signature.getInstance("SHA1WithRSA");
                signature.initSign(privateKey);
                signature.update(content);
                sig = Base64Util.encodeToString(signature.sign());//do base64 encoding
            } catch (Exception e) {
                throw new RuntimeException("sign failed!", e);
            }
            return sig;
        }

        /**
         * verify
         *
         * @param publicKeyStr publickey base64
         * @param sign
         * @param content
         * @return
         */
        public static boolean verify(String publicKeyStr, byte[] sign, byte[]
                content) {
            if (publicKeyStr == null || publicKeyStr.length() == 0) {
                throw new RuntimeException("publickey is empty.");
            }
            if (sign == null || content == null) {
                return false;
            }
            RSAPublicKey publicKey = null;
            try {
                KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                publicKey = (RSAPublicKey) keyFactory.generatePublic(new X509EncodedKeySpec(Base64Util.decode(publicKeyStr)));
            } catch (Exception e) {
                throw new RuntimeException("init public key failed!", e);
            }
            boolean isOk = false;
            try {
                Signature signature = Signature.getInstance("SHA1WithRSA");
                signature.initVerify(publicKey);
                signature.update(content);
                isOk = signature.verify(sign);
            } catch (Exception e) {
                logger.error("rsa verify failed.", e);
            }
            return isOk;
        }

        //在当前⽬目录⽣生成公私密钥
        //openssl genrsa -out privatekey.pem 1024
        //openssl rsa -in privatekey.pem -pubout -out publickey.pem
        private static final String DEMO_PRIKEY = "MIICXgIBAAKBgQDfmy3gl2xOqpN7kIa01Juak6uMJXns0pBpZyauIup58kv3qWWE\n"
                                                  + "zBQwvyV3/arnwluoxfa6dJLd48KU9CHKesYf3H92umkuxsPrc8tMslpXA2Fi/LAt\n"
                                                  + "8vJhrikY3YSlAmgwsdXA0DB99XkNQ1dcTPCWr+kg2DRF0+sowbb1E+OgcwIDAQAB\n"
                                                  + "AoGADahp1fUJzYhHt91tDPCLjJaGfOnxF5EI9xcw2qQRVF+DWl5DcCgS96NFQ53/\n"
                                                  + "6WYKuTVWS69BJUJ7KSP8SGTVYxGWcQ/Ky/K91oYGwyf2pJ0Dkp5kULUe7vgfR3Dt\n"
                                                  + "4FT024LK0p374r2jJVAZFVfqpdA+OznHzJ3NtcsHwZs0wTkCQQDzOU9io7mQpjei\n"
                                                  + "TZDUlSYxPYiy/60czN6zlnssjulIGjVZqRGY+M53JO6bxoSVP2ql1lFyrNy5kHYx\n"
                                                  + "rzQAfULNAkEA61oQsFqcUMw158rIzVjybPS+V9O8Bzh/59Gi/Gcq4xgKVORDuYUF\n"
                                                  + "aVwNkFNro3vacYuFh/9b9EgtXfwTADDwPwJBANKQngJ2XbM1w1pWrnjr+tmMPSlC\n"
                                                  + "IfuZ/X8aWt6ThrBuSBusO9jkJdKN/aiMr8GJ2mlh5rdRofFgeILA/FMkHk0CQQDg\n"
                                                  + "JcI5Q8MWjLdWUGLYeDtDHAFgwk6VDfF7hsRU4akN6iqE2XXK7e7OfpaIe3rLlDzi\n"
                                                  + "4T/G26TnTgqvNVGfX/yfAkEAzCSQA1W8YKT9om8QeoN/B/pk/eICIr+Ibn8Jdvr6\n"
                                                  + "n5jaz9q/W1jc0zqQjxLvq59Iv3cLz8715rKuRvouN7uJSA==";

    private static final String DEMO_PUBKEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDfmy3gl2xOqpN7kIa01Juak6uM\n"
                                              + "JXns0pBpZyauIup58kv3qWWEzBQwvyV3/arnwluoxfa6dJLd48KU9CHKesYf3H92\n"
                                              + "umkuxsPrc8tMslpXA2Fi/LAt8vJhrikY3YSlAmgwsdXA0DB99XkNQ1dcTPCWr+kg\n"
                                              + "2DRF0+sowbb1E+OgcwIDAQAB";


        @Test
        public void testRsaSignAndVerify() throws UnsupportedEncodingException {
            //1.模拟请求构造
            Map<String, String> params = new HashMap<String, String>();
            params.put("paramName2", "value2");
            params.put("paramName1", "value1");
            //2.参数名排序
            List<String> paramNames = new ArrayList<String>(params.keySet());
            Collections.sort(paramNames);
            //3.构造签名前数据
            StringBuilder sb = new StringBuilder();
            for (String key : paramNames) {
                sb.append(key);
                sb.append('=');
                sb.append(params.get(key));
            }
            System.out.println(sb.toString());
            //4.进⾏行行签名
            byte[] content = sb.toString().getBytes("utf-8");
            String sig = sign(SecretKeyUtils.privateKeyProduct, content);
            System.out.println("_sig=" + sig);
            //5.模拟服务端签名验证
            boolean verify = verify(SecretKeyUtils.publicKeyProduct, Base64Util.decode(sig), content);
            System.out.println(verify);
            assertTrue(verify);
        }


        @Test
    public void ss(){
            Calendar calendar = Calendar.getInstance();

            calendar.set(2018,11,5);
            System.out.println(calendar.getTime().getTime());
        }

}
