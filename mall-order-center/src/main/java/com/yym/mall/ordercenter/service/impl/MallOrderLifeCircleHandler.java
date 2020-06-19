package com.yym.mall.ordercenter.service.impl;

import com.yym.mall.common.comm.MyHttpResponse;
import com.yym.mall.ordercenter.dao.OrderMapper;
import com.yym.mall.ordercenter.enums.OrderStatusEnum;
import com.yym.mall.ordercenter.exception.OrderException;
import com.yym.mall.ordercenter.model.dto.OrderDto;
import com.yym.mall.ordercenter.model.vo.ProductVo;
import com.yym.mall.ordercenter.service.InventoryService;
import com.yym.mall.ordercenter.util.BeanUtils;
import com.yym.mall.ordercenter.util.OrderNoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedHashMap;

/**
 * 商城订单处理
 * @author yanyimin
 * @date 2020-06-18 21:30
 */
@Service
@Slf4j
public class MallOrderLifeCircleHandler extends AbstractOrderLifeCircleHandler {

    @Autowired
    InventoryService inventoryService;

    @Autowired
    OrderMapper orderMapper;

    /**
     * 创建订单流程
     * 1.生成全局唯一订单号
     * 2.扣减商品库存
     * 3.持久化订单
     * 4.返回订单
     *
     * @param orderDto 订单实体
     * @return
     */
    @Override
    public OrderDto createOrder(OrderDto orderDto) throws OrderException {
        // 检查参数
        checkOrderParam(orderDto);
        // 生成订单号
        String orderNo = OrderNoUtil.getOrderCode();
        // 扣减库存
        MyHttpResponse myHttpResponse = inventoryService.inventoryDeduct(orderDto.getProductId(),orderNo);
        ProductVo productVo;
        if(myHttpResponse.getCode().equals(MyHttpResponse.SUCCESS)){
            LinkedHashMap map = (LinkedHashMap) myHttpResponse.getDetails();
            productVo = BeanUtils.mapToBean(map, ProductVo.class);
        } else {
            throw new OrderException(myHttpResponse.getCode(),myHttpResponse.getMsg());
        }
        // 构建订单
        Date now = new Date();
        OrderDto order = new OrderDto();
        order.setOrderNo(orderNo);
        order.setProductId(productVo.getId());
        order.setOrderStatus(OrderStatusEnum.PAY_PENDING.getIndex());
        order.setUserId(orderDto.getUserId());
        order.setCreateTime(now);
        order.setUpdateTime(now);
        order.setTotalAmount(productVo.getPrice());

        // 插入订单
        orderMapper.insert(order);
        log.info("用户id:{},创建订单成功，商品id:{},订单号:{}",order.getUserId(),order.getProductId(),order.getOrderNo());
        return order;
    }

    @Override
    public void onOrderPayed() {

    }

    @Override
    public void onOrderExpired() {

    }

    @Override
    public void onOrderCancel() {

    }

    @Override
    public void onOrderRefund() {

    }
}
