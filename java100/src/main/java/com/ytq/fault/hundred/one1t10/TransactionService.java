package com.ytq.fault.hundred.one1t10;

import com.ytq.fault.hundred.dao.UserMapper;
import com.ytq.fault.hundred.entity.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yuantongqin
 * desc:
 * 2020-06-21
 */
@Service
public class TransactionService {

    @Autowired
    private UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    public String back(){

        UserPO userPO = new UserPO();

        userMapper.insert(userPO);

        return null;
    }



}
