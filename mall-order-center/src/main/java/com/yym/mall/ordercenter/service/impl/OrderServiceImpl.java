package com.yym.mall.ordercenter.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yym.mall.common.comm.MyHttpResponse;
import com.yym.mall.ordercenter.constants.ExceptionConstants;
import com.yym.mall.ordercenter.dao.OrderMapper;
import com.yym.mall.ordercenter.enums.OrderStatusEnum;
import com.yym.mall.ordercenter.exception.OrderException;
import com.yym.mall.ordercenter.model.dto.OrderDto;
import com.yym.mall.ordercenter.model.dto.OrderQueryDto;
import com.yym.mall.ordercenter.model.vo.OrderVo;
import com.yym.mall.ordercenter.model.vo.ProductVo;
import com.yym.mall.ordercenter.pagination.PageDto;
import com.yym.mall.ordercenter.service.InventoryService;
import com.yym.mall.ordercenter.service.OrderService;
import com.yym.mall.ordercenter.util.BeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.LinkedHashMap;

/**
 * 订单服务层
 * @author yanyimin
 * @date 2020-06-18 10:37
 */
@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl implements OrderService {

    @Autowired
    InventoryService inventoryService;

    @Autowired
    OrderMapper orderMapper;

    /**
     * 分页获取用户订单
     * @param orderQueryDto 订单请求实体
     * @return 订单列表
     */
    @Override
    public PageDto<OrderVo> queryOrders(OrderQueryDto orderQueryDto){
        Page<OrderDto> page = new Page<>(orderQueryDto.getOffset(),orderQueryDto.getLimit());
        IPage<OrderVo> iPage = orderMapper.queryOrders(page,orderQueryDto);
        return new PageDto<OrderVo>().initPage(iPage);
    }

    /**
     * 创建订单
     * @param orderDto
     * @return
     * @throws OrderException
     */
    @Override
    public OrderDto createOrder(OrderDto orderDto) throws OrderException {
        // 检查参数
        checkOrderParam(orderDto);
        // 扣减库存
        MyHttpResponse myHttpResponse = inventoryService.inventoryDeduct(orderDto.getProductId());
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

        order.setProductId(productVo.getId());
        order.setOrderStatus(OrderStatusEnum.PAY_PENDING.getIndex());
        order.setUserId(orderDto.getUserId());
        order.setCreateTime(now);
        order.setUpdateTime(now);
        order.setTotalAmount(productVo.getPrice());
        order.setProductPrice(productVo.getPrice());
        order.setProductName(productVo.getName());
        order.setShipAddress(orderDto.getShipAddress());

        // 插入订单
        orderMapper.insert(order);
        log.info("用户id:{},创建订单成功，商品id:{},订单号:{}",order.getUserId(),order.getProductId(),order.getId());
        return order;
    }

    /**
     * 检查订单基本参数
     * @param orderDto 订单实体
     */
    public void checkOrderParam(OrderDto orderDto) throws OrderException {
        if(orderDto.getProductId()==null){
            throw OrderException.build(ExceptionConstants.PARAM_INVALID.format("productId"));
        }

        if(orderDto.getUserId()==null){
            throw OrderException.build(ExceptionConstants.PARAM_INVALID.format("userId"));
        }

        if(orderDto.getShipAddress()==null){
            throw OrderException.build(ExceptionConstants.PARAM_INVALID.format("shipAddress"));
        }


    }
}
