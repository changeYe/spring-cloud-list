import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

import org.junit.Test;

/**
 * @author yuantongqin
 * 2019/5/22
 */
public class Tt {

    @Test
    public void ss(){
        List<Integer> ss = new ArrayList<>();
        ss.add(12);
        ss.add(23);
        ss.add(32);
        ss.add(45);
        ss.add(15);

        AtomicReference<Float> sumPrice = new AtomicReference<>(0f);

        ss.stream().filter(item -> Objects.nonNull(item)).map(item->{

                sumPrice.updateAndGet(v -> new Float((float) (v + item * 1.2f)));

            return item;
        }).forEach(item->{
            System.out.println(item+"=="+sumPrice.get());
        });
    }

}
