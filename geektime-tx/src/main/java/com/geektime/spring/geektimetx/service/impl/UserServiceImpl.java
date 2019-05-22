package com.geektime.spring.geektimetx.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.geektime.spring.geektimetx.dao.UserMapper;
import com.geektime.spring.geektimetx.po.User;
import com.geektime.spring.geektimetx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;

/**
 * @author yuantongqin
 * 2019/5/12
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public List<User> getUser() {
        List<User> user = userMapper.getUser();
        System.out.println(user);
        return null;
    }



}
