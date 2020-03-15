package com.ytq.data.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ytq.data.po.UserPO;
import org.apache.ibatis.annotations.Select;


/**

 * @author yuantongqin
 * @since 2019-07-02
 */
public interface UserMapper extends BaseMapper<UserPO> {

    @Select("select * from user where name = #{userName}")
    UserPO getUserPasswordByName(String userName);

}
