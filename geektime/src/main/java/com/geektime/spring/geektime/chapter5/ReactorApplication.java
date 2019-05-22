package com.geektime.spring.geektime.chapter5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**
 * @author yuantongqin
 * 2019/5/18
 */
@SpringBootApplication
public class ReactorApplication implements ApplicationRunner{

    private static final Logger log = LoggerFactory.getLogger(ReactorApplication.class);


        public static void main(String[] args) {
            SpringApplication.run(ReactorApplication.class, args);
        }

        @Override
        public void run(ApplicationArguments args) throws Exception {

//            Flux.range(5,5).flatMap(new Function<Integer, Publisher<Integer>>() {
//                @Override
//                public Publisher<Integer> apply(Integer integer) {
//                    log.info("==内容=="+integer);
//
//                    return Mono.just(integer);
//                }
//            }).collectList();
//
//            List<String>  lists = new ArrayList<>();
//            lists.add("AAA");
//            lists.add("B");
//            lists.add("c");
//            lists.add("s");
//
//            lists.stream().flatMap(str -> Arrays.stream(new String[]{str})).collect(Collectors.toList());

            List<String> words = new ArrayList<String>();
            words.add("hello");
            words.add("word");
            List<String> stringList = words.stream()

                    .flatMap(new Function<String, Stream<? extends String>>() {
                        @Override
                        public Stream<? extends String> apply(String s) {
                            System.out.println("内容="+s);

                            
                            return Arrays.stream(s.split("o"));
                        }
                    })
                    .distinct()
                    .collect(Collectors.toList());




//            Flux.range(1, 6)
//                    .doOnRequest(i -> log.info("Request {} Number=="+i))
//                    .publishOn(Schedulers.parallel())
//                    .doOnComplete(()-> log.info("Publisher complete 1"))
//                    .map(i->{
//                        log.info("Publish==" +Thread.currentThread()+"==i"+i);
//                        return i;
//                    }).doOnComplete(()-> log.info("Publisher complete 2"))
//                    .subscribeOn(Schedulers.single())
////                    .onErrorReturn(-1)
//                    .subscribe(i -> {
//                        log.info("消费者 " + Thread.currentThread() + "===" + i);
//                    }, t -> {
//                        log.info("错误消息{} " + t.toString());
//                    }, () -> {
//                        log.info("subscriber 完成");
//                    }, new Consumer<Subscription>() {
//                        @Override
//                        public void accept(Subscription subscription) {
//                            subscription.request(4);
//                            log.info("支取几条 " + Thread.currentThread() + "===" );
//                        }
//                    });



//            Flux.range(1, 6)
//                    .doOnRequest(n -> log.info("Request {} number", n)) // 注意顺序造成的区别
////				.publishOn(Schedulers.elastic())
//                    .doOnComplete(() -> log.info("Publisher COMPLETE 1"))
//                    .map(i -> {
//                        log.info("Publish {}, {}", Thread.currentThread(), i);
//                        return 10 / (i - 3);
////					return i;
//                    })
//                    .doOnComplete(() -> log.info("Publisher COMPLETE 2"))
////				.subscribeOn(Schedulers.single())
////				.onErrorResume(e -> {
////					log.error("Exception {}", e.toString());
////					return Mono.just(-1);
////				})
////				.onErrorReturn(-1)
//                    .subscribe(i -> log.info("Subscribe {}: {}", Thread.currentThread(), i),
//                               e -> log.error("error {}", e.toString()),
//                               () -> log.info("Subscriber COMPLETE")//,
////						s -> s.request(4)
//                    );
            Thread.sleep(2000);
        }


}
