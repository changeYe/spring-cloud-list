import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.google.common.base.Splitter;
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

    @Test
    public void aa(){

        String sa = "";
        String[] split = sa.split(",");

        List<String> strings = Splitter.on(",")
                .trimResults()
                .omitEmptyStrings()
                .splitToList("fdafda,fdsafda,fdsafdsa,fdsa,fdas,fd,saf,ds,f,das,");

        System.out.println(strings.size());
    }

    @Test
    public void saa(){

        BigDecimal b = BigDecimal.valueOf(100.000);
        BigDecimal price = Optional.ofNullable(b).orElse(BigDecimal.ZERO);
        System.out.println(price.setScale(2, RoundingMode.HALF_UP).toString());


    }

}
