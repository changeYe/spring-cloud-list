package com.ytq.security.server.impl;

import com.ytq.security.model.dto.UserDTO;
import com.ytq.security.model.dto.UserLoginDTO;
import com.ytq.security.model.dto.UserRegisterDTO;
import com.ytq.security.server.UserServer;
import com.ytq.security.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yuantongqin
 * description:
 * 2020/4/2
 */
@Service
@Slf4j
public class UserServerImpl implements UserServer {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public UserRegisterDTO.Result register(UserRegisterDTO.Param userDTO) {
        return null;
    }

    @Override
    public UserLoginDTO.Result login(UserLoginDTO.Param param) {
        UserLoginDTO.Result result = new UserLoginDTO.Result();
        if(param.getUserName().equals("admin") && param.getPassword().equals("123456")){
            String token = jwtUtil.generateToken(param.getUserName());
            result.setToken(token);
            return result;
        }
        throw new SecurityException("登录失败");
    }

    @Override
    public UserDTO.Result getUser(UserDTO.Param param) {
        return null;
    }
}
