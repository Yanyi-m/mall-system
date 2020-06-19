package com.yym.mall.ordercenter.model.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yym.mall.ordercenter.enums.OrderStatusEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单dto
 * @author yanyimin
 * @date 2020-06-17 17:01
 */
@Data
@TableName("mall_order")
public class OrderDto {

    /**
     * 订单id
     */
    @TableId(value = "id", type = IdType.AUTO)
    protected Long id;

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
