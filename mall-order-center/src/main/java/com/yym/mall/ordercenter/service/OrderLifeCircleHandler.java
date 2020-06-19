package com.yym.mall.ordercenter.service;

import com.yym.mall.ordercenter.exception.OrderException;
import com.yym.mall.ordercenter.model.dto.OrderDto;
import com.yym.mall.ordercenter.model.vo.OrderVo;
import org.springframework.stereotype.Service;

/**
 * 订单生命周期
 * @author yanyimin
 * @date 2020-06-17 17:00
 */
public interface OrderLifeCircleHandler {

    /**
     * 创建订单
     * @param orderDto 订单号
     * @return
     */
     OrderDto createOrder(OrderDto orderDto) throws OrderException;

    /**
     * 订单已支付
     */
    void onOrderPayed();

    /**
     * 订单过期
     */
    void onOrderExpired();

    /**
     * 取消订单
     */
    void onOrderCancel();

    /**
     * 订单退款
     */
    void onOrderRefund();


}
