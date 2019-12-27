package com.ytq.fast.event;

import java.util.concurrent.TimeUnit;

import com.ytq.fast.entity.User;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author yuantongqin
 * description:
 * 2019/12/13
 */
@Component
public class AsyncDemo{

    @EventListener
    @Async
    public void ss(User user){

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("对视:"+user.getName());

    }

}
