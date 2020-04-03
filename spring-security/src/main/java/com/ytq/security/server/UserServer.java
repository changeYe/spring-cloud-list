package com.ytq.security.server;

import com.ytq.security.model.dto.UserDTO;
import com.ytq.security.model.dto.UserLoginDTO;
import com.ytq.security.model.dto.UserRegisterDTO;

/**
 * @author yuantongqin
 * description:
 * 2020/4/2
 */
public interface UserServer {

    /**
     * 用户注册
     */
    UserRegisterDTO.Result register(UserRegisterDTO.Param userDTO);

    /**
     * 用户登录
     */

    UserLoginDTO.Result login(UserLoginDTO.Param param);

    UserDTO.Result getUser(UserDTO.Param param);


}
