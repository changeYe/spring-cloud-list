import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.LongAdder;

import org.junit.Test;

/**
 * @author yuantongqin
 * description:
 * 2020/3/30
 */
public class Ta {

    @Test
    public void tea(){
        ConcurrentHashMap<Integer, LongAdder> chm1 = new ConcurrentHashMap<>(10000);
        ConcurrentHashMap<Integer,LongAdder> chm2 = new ConcurrentHashMap<>(10000);
        for (int i = 0; i < 10000; i++) {
            int a = new Random().nextInt(10);
            int b = ThreadLocalRandom.current().nextInt(10);
            chm1.computeIfAbsent(a, key -> new LongAdder()).increment();
            chm2.computeIfAbsent(b, key -> new LongAdder()).increment();
        }

       chm1.forEach((integer, longAdder) -> System.out.println(integer + "=" + longAdder.longValue()));
       chm2.forEach((integer, longAdder) -> System.out.println(integer + "=" + longAdder.longValue()));

    }

}
