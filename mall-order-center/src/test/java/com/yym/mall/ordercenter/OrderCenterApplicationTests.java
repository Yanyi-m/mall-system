package com.yym.mall.ordercenter;

import com.yym.mall.common.comm.MyHttpResponse;
import com.yym.mall.ordercenter.controller.OrderController;
import com.yym.mall.ordercenter.enums.OrderStatusEnum;
import com.yym.mall.ordercenter.exception.OrderException;
import com.yym.mall.ordercenter.model.dto.OrderDto;
import com.yym.mall.ordercenter.model.dto.OrderQueryDto;
import com.yym.mall.ordercenter.model.dto.UserDto;
import com.yym.mall.ordercenter.model.vo.OrderVo;
import com.yym.mall.ordercenter.pagination.PageDto;
import com.yym.mall.ordercenter.service.impl.OrderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
@Slf4j
class OrderCenterApplicationTests {

    @Autowired
    OrderController orderController;

    @Autowired
    OrderServiceImpl orderService;

    public UserDto user1 = UserDto.builder().id(1L).shipAddress("长沙岳麓区").build();
    public UserDto user2 = UserDto.builder().id(2L).shipAddress("长沙开福区").build();


    /**
     * 测试获取用户订单列表
     * 参数用户id = 1
     */
    @Test
    void testQueryOrderByUser(){
        OrderQueryDto orderDto = new OrderQueryDto();
        orderDto.setUserId(user1.getId());

        PageDto<OrderVo> pageDto = orderService.queryOrders(orderDto);
        // 期望用户id = 1 ，订单列表大小为3
        Assert.assertNotNull(pageDto.getData());
        Assert.assertEquals(3,pageDto.getData().size());
    }

    /**
     * 测试根据订单id获取用户订单列表
     * 参数用户id = 2, orderId = 1
     */
    @Test
    void testQueryOrderByOrderId(){
        OrderQueryDto orderDto = new OrderQueryDto();
        orderDto.setUserId(user1.getId());
        orderDto.setOrderId(1L);

        PageDto<OrderVo> pageDto = orderService.queryOrders(orderDto);
        // 期望用户id = 1 , orderId = 1 , 订单列表大小为1
        Assert.assertNotNull(pageDto.getData());
        Assert.assertEquals(1,pageDto.getData().size());
    }

    /**
     * 测试无产品id创建订单
     */
    @Test
    void testCreateOrderWithOutProductId() {
        OrderDto orderDto = new OrderDto();
        orderDto.setUserId(user1.getId());
        OrderDto orderDto1 = null;
        try {
            orderDto1 = orderService.createOrder(orderDto);
        } catch (OrderException e) {
            Assert.assertEquals(200001,e.getCode().intValue());
        }

        Assert.assertNull(orderDto1);
    }

    /**
     * 测试创建订单
     */
    @Test
    void testCreateOrder() {
        OrderDto orderDto = new OrderDto();
        orderDto.setUserId(user2.getId());
        orderDto.setShipAddress(user2.getShipAddress());
        orderDto.setProductId(1L);

        try {
            orderDto = orderService.createOrder(orderDto);
        } catch (OrderException e) {
            e.printStackTrace();
        }
        // 期望捕捉到参数非法的异常
        Assert.assertEquals("产品1",orderDto.getProductName());
        Assert.assertEquals("长沙开福区",orderDto.getShipAddress());
    }

}
