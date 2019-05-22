package com.geektime.spring.geektimetx;

import java.util.function.Function;
import java.util.function.LongConsumer;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

/**
 * @author yuantongqin
 * 2019/5/15
 */
public class Tt {

    private static Logger logger = LoggerFactory.getLogger(Tt.class);

    @Test
    public void testReactor(){
//        Flux.range(1,6)
//                .doOnRequest(n-> logger.info("request {} number 请求了一个什么数",n))
//                .doOnComplete(()-> logger.info("第一次完成"))
//                .map(new Function<Integer, Object>() {
//                    @Override
//                    public Object apply(Integer integer) {
//                        return null;
//                    }
//                }).
    }

}
