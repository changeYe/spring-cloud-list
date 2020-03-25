package com.ytq.fault.hundred.controller;

import java.util.stream.IntStream;

import com.ytq.fault.hundred.server.lock.impl.LockServerImpl;
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
