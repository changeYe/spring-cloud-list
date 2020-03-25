package com.ytq.fault.hundred.server.transaction;

import com.ytq.fault.hundred.entity.UserPO;

/**
 * @author yuantongqin
 * description:
 * 2020/3/21
 */
public interface UserTransactionServer {

    Integer saveUser(UserPO userPO);

}
