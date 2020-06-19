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
    protected Long orderId;

    /**
     * 产品id
     */
    protected Long productId;

    /**
     * 产品价格
     */
    protected BigDecimal productPrice;

    /**
     * 产品名称
     */
    protected String productName;

    /**
     * 用户id
     */
    protected Long userId;

    /**
     * 送货地址
     */
    protected String shipAddress;

    /**
     * 总金额
     */
    protected BigDecimal totalAmount;

    /**
     * 创建时间
     */
    protected Date createTime;

    /**
     * 更新时间
     */
    protected Date updateTime;

    /**
     * 订单状态
     * @see OrderStatusEnum
     */
    protected Integer orderStatus;
}
