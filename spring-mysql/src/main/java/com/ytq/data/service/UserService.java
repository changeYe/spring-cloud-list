package com.ytq.data.service;

import com.ytq.data.dto.ApiOAuthDTO;

/**
 * @author yuantongqin
 * description:
 * 2020/3/11
 */
public interface UserService {

    Boolean ApiOAuthByName(ApiOAuthDTO.Param param);

    String hello(String name);
}
