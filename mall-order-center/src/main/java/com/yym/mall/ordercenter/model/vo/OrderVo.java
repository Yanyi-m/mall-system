package com.yym.mall.ordercenter.model.vo;

import com.yym.mall.ordercenter.enums.OrderStatusEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author yanyimin
 * @date 2020-06-17 17:08
 */
@Data
public class OrderVo {

    /**
     * 订单号
     */
    protected String orderNo;

    /**
     * 产品id
     */
    protected Long productId;

    /**
     * 总金额
     */
    protected BigDecimal totalAmount;

    /**
     * 创建时间
     */
    protected Date createTime;


    /**
     * 订单状态
     * @see OrderStatusEnum
     */
    protected Integer orderStatus;
}
