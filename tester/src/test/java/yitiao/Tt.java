//package yitiao;
//
//import java.io.UnsupportedEncodingException;
//import java.math.BigDecimal;
//import java.security.KeyFactory;
//import java.security.Security;
//import java.security.Signature;
//import java.security.interfaces.RSAPrivateCrtKey;
//import java.security.interfaces.RSAPublicKey;
//import java.security.spec.PKCS8EncodedKeySpec;
//import java.security.spec.X509EncodedKeySpec;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Calendar;
//import java.util.Collections;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import com.yit.openapi.sdk.client.util.Base64Util;
//import org.bouncycastle.jce.provider.BouncyCastleProvider;
//import org.junit.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import static org.junit.Assert.assertTrue;
//
///**
// * @author yuantongqin
// * 2019/5/7
// */
//public class test {
//
//
//    private static final Logger logger = LoggerFactory.getLogger(test.class);
//
//    //regist Security Provider,use BouncyCastleProvider
//    static {
//        Security.addProvider(new BouncyCastleProvider());
//    }
//
//    /**
//     * sign
//     *
//     * @param privateKeyStr privatekey base64
//     */
//    public static String sign(String privateKeyStr, byte[] content) {
//        if (privateKeyStr == null || privateKeyStr.length() == 0) {
//            throw new RuntimeException("private key is empty.");
//        }
//        if (content == null) {
//            return null;
//        }
//        RSAPrivateCrtKey privateKey = null;
//        try {
//            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//            privateKey = (RSAPrivateCrtKey) keyFactory.generatePrivate(new PKCS8EncodedKeySpec(Base64Util.decode(privateKeyStr)));
//        } catch (Exception e) {
//            throw new RuntimeException("init private key failed!", e);
//        }
//        String sig = null;
//        try {
//            Signature signature = Signature.getInstance("SHA1WithRSA");
//            signature.initSign(privateKey);
//            signature.update(content);
//            sig = Base64Util.encodeToString(signature.sign());//do base64 encoding
//        } catch (Exception e) {
//            throw new RuntimeException("sign failed!", e);
//        }
//        return sig;
//    }
//
//    /**
//     * verify
//     *
//     * @param publicKeyStr publickey base64
//     */
//    public static boolean verify(String publicKeyStr, byte[] sign, byte[]
//            content) {
//        if (publicKeyStr == null || publicKeyStr.length() == 0) {
//            throw new RuntimeException("publickey is empty.");
//        }
//        if (sign == null || content == null) {
//            return false;
//        }
//        RSAPublicKey publicKey = null;
//        try {
//            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//            publicKey = (RSAPublicKey) keyFactory.generatePublic(new X509EncodedKeySpec(Base64Util.decode(publicKeyStr)));
//        } catch (Exception e) {
//            throw new RuntimeException("init public key failed!", e);
//        }
//        boolean isOk = false;
//        try {
//            Signature signature = Signature.getInstance("SHA1WithRSA");
//            signature.initVerify(publicKey);
//            signature.update(content);
//            isOk = signature.verify(sign);
//        } catch (Exception e) {
//            logger.error("rsa verify failed.", e);
//        }
//        return isOk;
//    }
//
//    //在当前⽬目录⽣生成公私密钥
//    //openssl genrsa -out privatekey.pem 1024
//    //openssl rsa -in privatekey.pem -pubout -out publickey.pem
//    private static final String DEMO_PRIKEY = "MIICXgIBAAKBgQDfmy3gl2xOqpN7kIa01Juak6uMJXns0pBpZyauIup58kv3qWWE\n"
//                                              + "zBQwvyV3/arnwluoxfa6dJLd48KU9CHKesYf3H92umkuxsPrc8tMslpXA2Fi/LAt\n"
//                                              + "8vJhrikY3YSlAmgwsdXA0DB99XkNQ1dcTPCWr+kg2DRF0+sowbb1E+OgcwIDAQAB\n"
//                                              + "AoGADahp1fUJzYhHt91tDPCLjJaGfOnxF5EI9xcw2qQRVF+DWl5DcCgS96NFQ53/\n"
//                                              + "6WYKuTVWS69BJUJ7KSP8SGTVYxGWcQ/Ky/K91oYGwyf2pJ0Dkp5kULUe7vgfR3Dt\n"
//                                              + "4FT024LK0p374r2jJVAZFVfqpdA+OznHzJ3NtcsHwZs0wTkCQQDzOU9io7mQpjei\n"
//                                              + "TZDUlSYxPYiy/60czN6zlnssjulIGjVZqRGY+M53JO6bxoSVP2ql1lFyrNy5kHYx\n"
//                                              + "rzQAfULNAkEA61oQsFqcUMw158rIzVjybPS+V9O8Bzh/59Gi/Gcq4xgKVORDuYUF\n"
//                                              + "aVwNkFNro3vacYuFh/9b9EgtXfwTADDwPwJBANKQngJ2XbM1w1pWrnjr+tmMPSlC\n"
//                                              + "IfuZ/X8aWt6ThrBuSBusO9jkJdKN/aiMr8GJ2mlh5rdRofFgeILA/FMkHk0CQQDg\n"
//                                              + "JcI5Q8MWjLdWUGLYeDtDHAFgwk6VDfF7hsRU4akN6iqE2XXK7e7OfpaIe3rLlDzi\n"
//                                              + "4T/G26TnTgqvNVGfX/yfAkEAzCSQA1W8YKT9om8QeoN/B/pk/eICIr+Ibn8Jdvr6\n"
//                                              + "n5jaz9q/W1jc0zqQjxLvq59Iv3cLz8715rKuRvouN7uJSA==";
//
//    private static final String DEMO_PUBKEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDfmy3gl2xOqpN7kIa01Juak6uM\n"
//                                              + "JXns0pBpZyauIup58kv3qWWEzBQwvyV3/arnwluoxfa6dJLd48KU9CHKesYf3H92\n"
//                                              + "umkuxsPrc8tMslpXA2Fi/LAt8vJhrikY3YSlAmgwsdXA0DB99XkNQ1dcTPCWr+kg\n"
//                                              + "2DRF0+sowbb1E+OgcwIDAQAB";
//
//
//    @Test
//    public void testRsaSignAndVerify() throws UnsupportedEncodingException {
//        //1.模拟请求构造
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("paramName2", "value2");
//        params.put("paramName1", "value1");
//        //2.参数名排序
//        List<String> paramNames = new ArrayList<String>(params.keySet());
//        Collections.sort(paramNames);
//        //3.构造签名前数据
//        StringBuilder sb = new StringBuilder();
//        for (String key : paramNames) {
//            sb.append(key);
//            sb.append('=');
//            sb.append(params.get(key));
//        }
//        System.out.println(sb.toString());
//        //4.进⾏行行签名
//        byte[] content = sb.toString().getBytes("utf-8");
//        String sig = sign(SecretKeyUtils.privateKeyProduct, content);
//        System.out.println("_sig=" + sig);
//        //5.模拟服务端签名验证
//        boolean verify = verify(SecretKeyUtils.publicKeyProduct, Base64Util.decode(sig), content);
//        System.out.println(verify);
//        assertTrue(verify);
//    }
//
//
//    @Test
//    public void ss() {
////            Calendar calendar = Calendar.getInstance();
//// 1562815894316
////            calendar.set(2019,6,1);
////            System.out.println(calendar.getTime().getTime());
//        List<User> lists = new ArrayList<>();
//        Item item1 =new Item(1,"张三");
//        List<Item> list1= new ArrayList<>();
//        list1.add(item1);
//        User user1 = new User(1,list1);
//        Item item2 =new Item(2,"张三2");
//        List<Item> list2= new ArrayList<>();
//        list2.add(item2);
//        User user2 = new User(2,list2);
//        Item item3 =new Item(3,"张三3");
//        List<Item> list3= new ArrayList<>();
//        list3.add(item3);
//        User user3 = new User(3,list3);
//        Item item4 =new Item(4,"张三4");
//        List<Item> list4= new ArrayList<>();
//        list4.add(item4);
//        User user4 = new User(4,list4);
//        Item item5 =new Item(5,"张三");
//        List<Item> list5= new ArrayList<>();
//        list5.add(item5);
//        Item item6 =new Item(6,"张三");
//        list5.add(item6);
//        User user5 = new User(5,list5);
//
//
//        lists.add(user1);
//        lists.add(user2);
//        lists.add(user3);
//        lists.add(user4);
//        lists.add(user5);
//        boolean flag = false;
//        System.out.println(lists.size());
//        for (int i = 0; i < lists.size(); i++) {
//            User user = lists.get(i);
//            for (int j = 1; (i + j) < lists.size(); j++) {
////                User user1 = (User) list.get(j + i);
//                if (user.getItem().get(0).getName().equals((lists.get(j + i)).getItem().get(0).getName())) {
//                    lists.get(i+j).getItem().addAll(user.getItem());
//                    flag = true;
//                    break;
//                }
//            }
//            if (!flag) {
//
//            } else {
//                flag = false;
//            }
//        }
//        System.out.println(lists);
//
////        for (User aLong : getUniqueList(lists)) {
////            System.out.println(aLong);
////        }
//    }
//
//
//    public static <T> List<T> getUniqueList(List<T> list) {
//        List<T> listAll = new ArrayList<T>();
//        if (list == null || list.size() < 0) {
//            return listAll;
//        }
//        boolean flag = false;
//        System.out.println(list.size());
//        for (int i = 0; i < list.size(); i++) {
//            User user = (User) list.get(i);
//            for (int j = 1; (i + j) < list.size(); j++) {
////                System.out.println(list.get(j)+"==="+list.get(i) +"=="+list.get(i+j));
////                User user1 = (User) list.get(j + i);
//                if (user.getItem().get(0).getName().equals(((User) list.get(j + i)).getItem().get(0).getName())) {
//                    ((User)list.get(i+j)).getItem().addAll(user.getItem());
//                    flag = true;
//                    break;
//                }
//            }
//            if (!flag) {
//                listAll.add((T) user);
//            } else {
//                flag = false;
//            }
//        }
//        return listAll;
//    }
//
//    @Test
//    public void testTime(){
//        Date initDate = new Date(1559318400088L);
//
//        Calendar instance = Calendar.getInstance();
//       instance.set(2019,5,20);
//        long aa = instance.getTimeInMillis();
//        System.out.println(instance.getTime());
//        instance.set(2019,5,21);
//        long bb = instance.getTimeInMillis();
//        System.out.println(bb-aa);
//        System.out.println(instance.getTime());
//
//        long a=24*60*60*1000;
//        System.out.println(a);
//
//        String msg = "com.kunchi.oms.spi.create.OrderStockOutCreateKAXsckKShopSpi:服务拒绝异常:{\"Response\":{\"return\":{\"resultInfo\":[],\"returnCode\":\"S102\",\"returnDesc\":\"SKU not exist 111110668000\",\"returnFlag\":\"0\"}}}";
//        String key = "returnDesc";
//        int startIndex = msg.lastIndexOf(key);
//        int endIndex = msg.lastIndexOf("returnFlag");
//        if(startIndex > 0 && (endIndex-1) > 0){
//            String substring = msg.substring(startIndex+key.length()+2, endIndex-2);
//            System.out.println(substring);
//        }
//        BigDecimal s = new BigDecimal(1020);
//        double v = s.doubleValue() / 10;
//
//        System.out.println(new BigDecimal(v));
//
//
//
//
//    }
//
//}
