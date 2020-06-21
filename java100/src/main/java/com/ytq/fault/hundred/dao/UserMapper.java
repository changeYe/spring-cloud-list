package com.ytq.fault.hundred.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ytq.fault.hundred.entity.UserPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author yuantongqin
 * description:
 * 2020/3/31
 */
@Mapper
public interface UserMapper extends BaseMapper<UserPO> {

    @Select("select * from user where create_time >= #{beginTime} and create_time < #{endTime}")
    Integer count(@Param("beginTime")Long beginTime ,@Param("endTime")Long endTime);


}
