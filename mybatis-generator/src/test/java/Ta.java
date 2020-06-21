import java.math.BigDecimal;

import org.junit.Test;

/**
 * @author yuantongqin
 * description:
 * 2020/4/20
 */
public class Ta {

    @Test
    public void ta(){
        BigDecimal a = BigDecimal.valueOf(10);
        int i = a.compareTo(BigDecimal.valueOf(12));
        System.out.println(i);
    }

}
