package com.geektime.spring.geektime;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * @author yuantongqin
 * 2019/5/18
 */
public class Tt {

    private Logger log = LoggerFactory.getLogger(Tt.class);

    @Test
    public void ss(){
        System.out.println("fdasfdsa");
        log.info("日志打印不出来");

        Flux.range(1, 6)
                .doOnRequest(i -> System.out.println("Request {} Number"+i))
                .doOnComplete(()-> System.out.println("Publisher complete 1"))
                .publishOn(Schedulers.elastic())
                .map(i->{
                    System.out.println("Publish" +Thread.currentThread()+"==i"+i);
                    return i;
                }).doOnComplete(()-> System.out.println("Publisher complete 2"))
                .subscribeOn(Schedulers.single())
                .onErrorReturn(-1)
                .subscribe(i -> {
                    System.out.println("消费者 "+ Thread.currentThread()+"==="+i);
                }, t -> {
                    System.out.println("错误消息{} "+ t.toString());
                }, ()->{
                    System.out.println("subscriber 完成");
                });

    }

    public  Stream<Character> characterStream(String s){
        List<Character> result = new ArrayList<>();
        for (char c : s.toCharArray())
            result.add(c);
        return result.stream();
    }

    @Test
    public void sa(){
        List<String> words = new ArrayList<String>();
        words.add("your");
        words.add("name");

        Stream<Stream<Character>> streamStream = words.stream().map(w -> characterStream(w));

        List<Stream<Character>> collect = streamStream.collect(Collectors.toList());
        collect.stream().forEach(i->{
            System.out.println(i.collect(Collectors.toList()).toString());
        });

        Stream<Character> characterStream = words.stream().flatMap(w -> characterStream(w));
        List<Character> collect1 = characterStream.collect(Collectors.toList());
        System.out.println(collect1.toString());


    }



}
