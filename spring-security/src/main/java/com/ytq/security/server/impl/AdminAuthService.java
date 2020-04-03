package com.ytq.security.server.impl;

import java.util.ArrayList;
import java.util.List;

import com.ytq.security.model.entity.MyUser;
import com.ytq.security.model.entity.UserPO;
import com.ytq.security.model.entity.UserPermissionPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author yuantongqin
 * description:
 * 2020/3/28
 */
@Service
public class AdminAuthService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserPO userPO = new UserPO();
        userPO.setUserName(username);
        userPO.setPassword(passwordEncoder.encode("123456"));
        List<UserPermissionPO> up = new ArrayList<>();
        UserPermissionPO userPermissionPO = new UserPermissionPO();
        userPermissionPO.setUrl("user:write");
        up.add(userPermissionPO);
        return new MyUser(userPO, up);
    }
}
