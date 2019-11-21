package com.ytq.data.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;


/**
 * <p>
 * 大牌说
 * </p>
 *
 * @author yuantongqin
 * @since 2019-07-02
 *
 *
 */
@TableName("order")
public class OrderPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("order_no")
    private Integer orderNo;

    @TableField("pay_money")
    private BigDecimal payMoney;

    @TableField("status")
    private Integer status;

    @TableField("create_date")
    private LocalDateTime createDate;

    @TableField("delete_flag")
    private Integer deleteFlag;

}
