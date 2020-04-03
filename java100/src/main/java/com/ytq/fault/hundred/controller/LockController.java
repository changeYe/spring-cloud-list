package com.ytq.fault.hundred.controller;

import java.util.stream.IntStream;

import com.ytq.fault.hundred.dao.UserMapper;
import com.ytq.fault.hundred.server.lock.impl.LockServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuantongqin
 * description:
 * 2020/3/22
 */
@RestController
public class LockController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/count")
    public Integer count(){
        //20200331134015
        Long beginTime = 20200331134015L;
        Long endTime = 20200331135015L;

        Integer count = userMapper.count(beginTime, endTime);
        System.out.println(count);
        return count;
    }

    @GetMapping("lock/wrong")
    @Transactional
    public String lock(){
        LockServerImpl.reset();
        IntStream.rangeClosed(1,100000).parallel().forEach(i->{
            new LockServerImpl().wrongLock();
        });
//        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//        DuplicateKeyException
        return LockServerImpl.count+"";
    }



}
