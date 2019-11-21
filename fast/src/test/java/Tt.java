import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Test;


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

}
