package com.ytq.fault.hundred.controller;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import com.ytq.fault.hundred.entity.UserPO;
import com.ytq.fault.hundred.server.transaction.UserTransactionServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuantongqin
 * description:
 * 2020/3/15
 */
@RestController
@Slf4j
public class ConcurrentUtilController {


    ThreadLocal<Byte[]> a =new ThreadLocal<>();
    @Autowired
    private UserTransactionServer userTransactionServer;

    @GetMapping("/say")
    public void hell(){
//        a.set(new Byte[1024*1024*5]);
//        System.out.println("gg");
//        ForkJoinPool forkJoinPool = new ForkJoinPool(10);
//        for (int i = 0; i < 20; i++) {
//            forkJoinPool.execute(()->{
//                System.out.println("jj=="+j);
//                int i1 = ThreadLocalRandom.current().nextInt(10);
//                System.out.println("i==="+i1);
//            });
//        }

        userTransactionServer.saveUser(new UserPO());



    }



    private ConcurrentHashMap<String, Long> getData(int count) {
        log.info(count+"");
        return LongStream.rangeClosed(1, count)
                .boxed()
                .collect(Collectors.toConcurrentMap(i -> UUID.randomUUID().toString(), Function.identity(),
                                                    (o1, o2) -> o1, ConcurrentHashMap::new));
    }

    @GetMapping("wrong")
    public String getWrong() throws InterruptedException {
        ConcurrentHashMap<String, Long> data = getData(900);
//        data.computeIfAbsent()
        log.info("初始原始大小 {}",data.size());
        ForkJoinPool forkJoinPool = new ForkJoinPool(10);
        forkJoinPool.execute(() -> IntStream.rangeClosed(1, 10).parallel().forEach(i -> {
            int gap = 1000 - data.size();
            log.info("gap size:{}", gap);
            data.putAll(getData(gap));
        }));
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.HOURS);

        log.info("finish size:{}", data.size());
        return "OK";
    }

//    public static void main(String[] args) {

//        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 5, 60, TimeUnit.SECONDS,
//                                                                       new CustomBlockingQueue<>(100),
//                                                                       new ThreadFactoryBuilder().setNameFormat("demo-thread-name-%d").get(),
//                                                                       new CustomPolicy());
//
//        ThreadUtils.printStats(threadPool);
////        ThreadPoolExecutor
////        ForkJoinPool
//        IntStream.rangeClosed(1,120).forEach(i->{
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            threadPool.execute(()->{
//                try {
//                    TimeUnit.HOURS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//        });

//        ConcurrentHashMap<String,String> a= new ConcurrentHashMap();
//        a.put("abc","124");
//        a.putIfAbsent("abc","456");
//        a.computeIfAbsent("", s -> "");
//        System.out.println(a.get("abc"));
//    }

}
