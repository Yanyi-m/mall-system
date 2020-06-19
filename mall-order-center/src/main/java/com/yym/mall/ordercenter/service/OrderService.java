package com.yym.mall.ordercenter.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yym.mall.ordercenter.dao.OrderMapper;
import com.yym.mall.ordercenter.exception.OrderException;
import com.yym.mall.ordercenter.model.dto.OrderDto;
import com.yym.mall.ordercenter.model.dto.OrderQueryDto;
import com.yym.mall.ordercenter.model.vo.OrderVo;
import com.yym.mall.ordercenter.pagination.PageDto;
import com.yym.mall.ordercenter.service.impl.MallOrderLifeCircleHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 订单服务层
 * @author yanyimin
 * @date 2020-06-18 10:37
 */
@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrderService {

    @Autowired
    MallOrderLifeCircleHandler mallOrderLifeCircleHandler;

    @Autowired
    OrderMapper orderMapper;

    /**
     * 分页获取用户订单
     * @param orderQueryDto 订单请求实体
     * @return 订单列表
     */
    public PageDto<OrderVo> queryOrders(OrderQueryDto orderQueryDto){
        Page<OrderDto> page = new Page<>(orderQueryDto.getOffset(),orderQueryDto.getLimit());
        IPage<OrderVo> iPage = orderMapper.queryOrders(page,orderQueryDto);
        return new PageDto<OrderVo>().initPage(iPage);
    }

    public OrderDto createOrder(OrderDto orderDto) throws OrderException {
        return mallOrderLifeCircleHandler.createOrder(orderDto);
    }
}
