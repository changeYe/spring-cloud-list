package com.ytq.data.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import jodd.util.concurrent.ThreadFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @author yuantongqin
 * description:
 * 2020/3/14
 */
@RestController
@RequestMapping("/bug")
public class BugController {




    @GetMapping("/oom")
    public void executorBug() throws InterruptedException {

        ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
        printStats(threadPool);
        for (int i = 0; i < 10000000; i++) {
            threadPool.execute(()->{
                String payload = IntStream.rangeClosed(1,100000).mapToObj(value -> "a").collect(Collectors.joining());
                try {
                    TimeUnit.HOURS.sleep(1);
                }catch (InterruptedException e){

                }
                System.out.println(payload);
            });
        }
        threadPool.shutdown();
        threadPool.awaitTermination(1,TimeUnit.HOURS);

    }

    /**
     * 这里实现了最简陋的监控，每秒输出线程池的内部信息，线程数，活跃线程数，完成任务，队列中积压任务
     * @param threadPoolExecutor
     */
    public void printStats(ThreadPoolExecutor threadPoolExecutor){
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(()->{
            System.out.println("线程池大小："+threadPoolExecutor.getPoolSize());
            System.out.println("当前活动线程数："+threadPoolExecutor.getActiveCount());
            System.out.println("任务完成数量："+threadPoolExecutor.getCompletedTaskCount());
            System.out.println("阻塞队列中剩余任务数："+threadPoolExecutor.getQueue().size());
        },0,1,TimeUnit.SECONDS);
    }




    @GetMapping("right")
    public int customExecutor() throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger();
        ThreadFactory threadFactory = ThreadFactoryBuilder.create().setNameFormat("demo-thread-pool-%d").get();
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 5, 10, TimeUnit.SECONDS,
                                                                       new ArrayBlockingQueue<>(10), threadFactory,
                                                                       new ThreadPoolExecutor.AbortPolicy());
        printStats(threadPool);
        IntStream.rangeClosed(1,20).forEach(i->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int index = atomicInteger.incrementAndGet();
            try {
                threadPool.submit(()->{
                    System.out.println("下标："+index);
                    try {
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("此时："+index);
                atomicInteger.decrementAndGet();
            }
        });

        TimeUnit.SECONDS.sleep(60);
        return atomicInteger.intValue();
    }

    private ThreadLocal<Integer> local = ThreadLocal.withInitial(()->null);

    @RequestMapping("/sayHello")
    public  Map<String,String> hello(@RequestParam("userId")Integer userId){
        // 设置用户信息之前先查询一次threadLocal信息
        String before = Thread.currentThread().getName()+":"+ local.get();
        // 设置用户信息
        local.set(userId);
        //设置用户信息之后在查询一下
        String after = Thread.currentThread().getName()+":"+local.get();
        Map<String,String> result = new HashMap<>();
        result.put("before",before);
        result.put("after",after);
        return result;
    }

    private ConcurrentMap<String, Long> getData(int count){
        return LongStream.rangeClosed(1,count)
                .boxed()
                .collect(Collectors.toConcurrentMap(i -> UUID.randomUUID().toString(),
                                                    Function.identity(), (o1,o2)->o1, ConcurrentHashMap::new));
    }

    public void sa() throws InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool(10);
//        forkJoinPool.execute();
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1,TimeUnit.HOURS);
    }

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @GetMapping("/mapping")
    public void getMapping(){
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = requestMappingHandlerMapping.getHandlerMethods();
        handlerMethods.forEach((requestMappingInfo, handlerMethod) -> {
            PatternsRequestCondition patternsCondition = requestMappingInfo.getPatternsCondition();
            Set<String> patterns = patternsCondition.getPatterns();
            patterns.forEach(s -> System.out.println("ss:" + s));
        });
    }

}
