import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import com.ytq.fast.entity.Article;
import com.ytq.fast.entity.User;
import org.junit.Test;
import org.springframework.format.datetime.DateFormatter;

/**
 * @author yuantongqin
 * 2019/8/1
 */
public class Tt {

    @Test
    public void ss(){

        String[] a = new String[2];
        String[] b = new String[2];

        a[0]="张三";

        b[1]=("张三");


        boolean s = Arrays.equals(a,b);
        System.out.println(s);

//        Optional.ofNullable()

        List<String> ssa = new ArrayList<>();
        ssa.stream().collect(Collectors.toList());

    }

    @Test
    public void ssb(){
        ConcurrentHashMap<String,String> chm = new ConcurrentHashMap<>(8);
        chm.put("0","a0");
//        for (int i = 0; i < 10; i++) {
//
//            chm.put(""+i,"a"+i);
//        }


    }


    @Test
    public void ssa(){
        DateFormatter df = new DateFormatter("yyyy/MM/dd");
        String print = df.print(new Date(), Locale.CHINA);
        System.out.println(print);
    }
    public static void main(String[] args) {
//        long rs= Integer.numberOfLeadingZeros(16) | (1 << (16 - 1));
//        long ll = ((rs << 16) + 2);
//        System.out.println("aa"+rs);
//        System.out.println("ll"+ll);
        int a = 15;

        int b = a << 1;
        int i = Integer.numberOfLeadingZeros(16);
        System.out.println(i);
       int bb = 27|30;
        System.out.println(bb);

        int cc = bb << 16 +2 ;
        System.out.println(cc);

        Long i1 = Long.parseLong("111110000000000000010", 10);
        System.out.println(i1);
        System.out.println(b);

        DateFormatter df = new DateFormatter("yyyy/mm/dd");
        df.print(new Date(), Locale.CHINA);
    }


    @Test
    public void ssc(){

        User user = new User();
        user.setAge(10);
        user.setName("张三");
        user.setAddress("上海");
        ssd(user);

    }

    public String ssd(Object o){
        try {
            // 判断某个类上是否有指定的注解
            Class<?> aClass = Class.forName(o.getClass().getName());
            Annotation[] declaredAnnotations = aClass.getDeclaredAnnotations();
            aClass.getDeclaredAnnotation(declaredAnnotations[0].annotationType());

            Method tu = aClass.getDeclaredMethod("tu", Article.class);
            tu.invoke(o,new Article());


            Field[] fields = aClass.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                String name = field.getName();
                String value= field.get(o).toString();
                System.out.println(value);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }


}
