package com.ytq.fault.hundred.server.transaction.impl;

import java.util.concurrent.CopyOnWriteArrayList;

import com.ytq.fault.hundred.entity.UserPO;
import com.ytq.fault.hundred.server.transaction.UserTransactionServer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yuantongqin
 * description:
 * 2020/3/21
 */
@Service
public class UserTransactionServerImpl implements UserTransactionServer {

    @Transactional
    @Override
    public Integer saveUser(UserPO userPO) {
        CopyOnWriteArrayList list = new CopyOnWriteArrayList();
//        list.get()
        return null;
    }
}
