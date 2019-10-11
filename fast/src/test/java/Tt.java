import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Test;
import org.springframework.web.bind.annotation.ExceptionHandler;

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

    /**
     * 1564160400000
     * 1380214800000
     */

    @Test
    public void sc(){
//        Optional<Object> o = Optional.of(null);
//        Optional.ofNullable()
//        com.google.common.base.Optional.fromNullable()
//        com.google.common.base.Optional<Ta> of = com.google.common.base.Optional.of(null);
//        of.isPresent();

//        Preconditions.checkArgument();


//        Objects.equal("","");
//        Integer a = 1;
//        Boolean bb = true;
//        int b =1;
//        System.out.println(java.util.Objects.equals(bb,true));
//        int result = ComparisonChain.start().co.compare(11, 2).result();
//        System.out.println(result);

        Ordering.natural();

    }

}
