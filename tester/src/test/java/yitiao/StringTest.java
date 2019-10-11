package yitiao;

import org.junit.Test;

/**
 * @author yuantongqin
 * 2019/9/24
 */
public class StringTest {

    @Test
    public void ss(){
        String str1= "abc";
        String str2= new String("abc");
        String str3= str2.intern();
        System.out.println(str1==str2);
        System.out.println(str2==str3);
        System.out.println(str1==str3);
    }

}
