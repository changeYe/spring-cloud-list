package com.ytq.data.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ytq.data.po.OrderPO;


/**
 * <p>
 * 大牌说 Mapper 接口
 * </p>
 *
 * @author yuantongqin
 * @since 2019-07-02
 */
public interface OrderMapper extends BaseMapper<OrderPO> {

    OrderPO getOrderById(Integer id);

}
