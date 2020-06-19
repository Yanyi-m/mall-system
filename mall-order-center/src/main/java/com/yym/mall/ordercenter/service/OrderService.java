package com.yym.mall.ordercenter.service;

import com.yym.mall.ordercenter.exception.OrderException;
import com.yym.mall.ordercenter.model.dto.OrderDto;
import com.yym.mall.ordercenter.model.dto.OrderQueryDto;
import com.yym.mall.ordercenter.model.vo.OrderVo;
import com.yym.mall.ordercenter.pagination.PageDto;

/**
 * 订单服务层
 * @author yanyimin
 * @date 2020-06-18 10:37
 */
public interface OrderService {

    /**
     * 获取订单
     * @param orderQueryDto
     * @return
     */
    PageDto<OrderVo> queryOrders(OrderQueryDto orderQueryDto);

    /**
     * 创建订单
     * @param orderDto
     * @return
     */
    OrderDto createOrder(OrderDto orderDto) throws OrderException;


}
