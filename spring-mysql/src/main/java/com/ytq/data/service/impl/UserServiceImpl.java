package com.ytq.data.service.impl;

import java.util.Objects;

import com.ytq.data.dao.UserMapper;
import com.ytq.data.dto.ApiOAuthDTO;
import com.ytq.data.po.UserPO;
import com.ytq.data.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @author yuantongqin
 * description:
 * 2020/3/11
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    /**
     * 有效期为5分钟
     */
    private static final Long expire = 5 * 60 * 1000L;
    /**
     * 秘钥
     */
    @Value("${secretApp}")
    private String secretApp;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ApiAuth apiAuth;

    @Override
    public Boolean ApiOAuthByName(ApiOAuthDTO.Param param) {
        if(apiAuth.isExpire(param.getTimestamp())){
            return false;
        }
        UserPO user = userMapper.getUserPasswordByName(param.getUserName());
        if(Objects.isNull(user)){
            log.error("用户名为 {[]} 信息不存在。",param.getUserName());
            return false;
        }
        return apiAuth.auth(param, user.getPassword());

    }



    @Transactional(propagation = Propagation.NESTED)
    @Override
    public String hello(String name) {
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
            @Override
            public void suspend() {

            }

            @Override
            public void resume() {

            }

            @Override
            public void flush() {

            }

            @Override
            public void beforeCommit(boolean readOnly) {

            }

            @Override
            public void beforeCompletion() {

            }

            @Override
            public void afterCommit() {

            }

            @Override
            public void afterCompletion(int status) {

            }
        });
        String transactionName = TransactionSynchronizationManager.getCurrentTransactionName();
        System.out.println("事务名称："+transactionName);
        return name;
    }
}
