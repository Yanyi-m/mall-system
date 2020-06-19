package com.yym.mall.ordercenter.service.impl;

import com.yym.mall.ordercenter.constants.ExceptionConstants;
import com.yym.mall.ordercenter.exception.OrderException;
import com.yym.mall.ordercenter.model.dto.OrderDto;
import com.yym.mall.ordercenter.service.OrderLifeCircleHandler;

/**
 * 订单生命周期处理抽象类
 * @author yanyimin
 * @date 2020-06-18 21:28
 */
public abstract class AbstractOrderLifeCircleHandler implements OrderLifeCircleHandler {

    /**
     * 检查订单基本参数
     * @param orderDto 订单号
     */
    public void checkOrderParam(OrderDto orderDto) throws OrderException {
        if(orderDto.getProductId()==null){
            throw OrderException.build(ExceptionConstants.PARAM_INVALID.format("productId"));
        }

        if(orderDto.getUserId()==null){
            throw OrderException.build(ExceptionConstants.PARAM_INVALID.format("userId"));
        }
    }

}
