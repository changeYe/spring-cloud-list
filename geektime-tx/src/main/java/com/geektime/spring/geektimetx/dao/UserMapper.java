package com.geektime.spring.geektimetx.dao;

import java.util.List;

import com.geektime.spring.geektimetx.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author yuantongqin
 * 2019/5/12
 */
@Mapper
public interface UserMapper {

    @Select("select * from user")
    List<User> getUser();
}
