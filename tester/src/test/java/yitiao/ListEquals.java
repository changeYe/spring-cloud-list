package yitiao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.kunchi.spring.test.entity.Dog;
import org.junit.Test;

/**
 * @author yuantongqin
 * description:
 * 2020/3/12
 */
public class ListEquals {

    @Test
    public void ss(){
        List<String> sa = new ArrayList<>();
        List<String> sb = new ArrayList<>();
        sa.add("abc");
        sb.add("abc");
        boolean equals = sa.equals(sb);
        System.out.println(equals);

        List<Dog> doga = new ArrayList<>();
        List<Dog> dogb = new ArrayList<>();

        doga.add(new Dog("旺财"));
        dogb.add(new Dog("阿才"));
        boolean equals1 = doga.equals(dogb);
        System.out.println(equals1);
//        a.equals()

        BigDecimal a = BigDecimal.valueOf(0.001);//BigDecimal.valueOf(0.001);
//        a.setScale(4);
        BigDecimal taxRate = Objects.isNull(a) ? a: a.setScale(4);
//        BigDecimal b = Optional.ofNullable(a).orElse(a.setScale(4));
//        System.out.println(b);

        System.out.println(a);
    }

}
