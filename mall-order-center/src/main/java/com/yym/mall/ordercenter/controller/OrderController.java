package com.yym.mall.ordercenter.controller;

import com.yym.mall.common.comm.MyHttpResponse;
import com.yym.mall.ordercenter.exception.OrderException;
import com.yym.mall.ordercenter.model.dto.OrderDto;
import com.yym.mall.ordercenter.model.dto.OrderQueryDto;
import com.yym.mall.ordercenter.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 订单控制层
 * @author yanyimin
 * @date 2020-06-17 16:55
 */
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/queryOrders")
    public MyHttpResponse queryOrders(OrderQueryDto orderQueryDto){
        return MyHttpResponse.success(orderService.queryOrders(orderQueryDto));
    }

    @PostMapping("/createOrders")
    public MyHttpResponse createOrders(@RequestBody OrderDto orderDto) throws OrderException {
        orderService.createOrder(orderDto);
        return MyHttpResponse.success("");
    }
}
