package com.yym.mall.ordercenter;

import com.yym.mall.common.comm.MyHttpResponse;
import com.yym.mall.ordercenter.controller.OrderController;
import com.yym.mall.ordercenter.enums.OrderStatusEnum;
import com.yym.mall.ordercenter.exception.OrderException;
import com.yym.mall.ordercenter.model.dto.OrderDto;
import com.yym.mall.ordercenter.model.dto.OrderQueryDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class OrderCenterApplicationTests {

    @Autowired
    OrderController orderController;

    /**
     * 订单查询测试
     */
    @Test
    void queryOrders(){
        OrderQueryDto orderDto1 = new OrderQueryDto();

        orderDto1.setUserId(1L);
        MyHttpResponse myHttpResponse = orderController.queryOrders(orderDto1);
        log.info("用户id查询结果：{}",myHttpResponse.getDetails());

        OrderQueryDto orderDto2 = new OrderQueryDto();
        orderDto2.setUserId(1L);
        orderDto2.setOrderNo("1000_202006190927240001");
        myHttpResponse = orderController.queryOrders(orderDto2);
        log.info("用户id和订单号查询结果：{}",myHttpResponse.getDetails());

        OrderQueryDto orderDto3 = new OrderQueryDto();
        orderDto3.setUserId(2L);
        orderDto3.setOrderStatus(OrderStatusEnum.PAYED.getIndex());
        myHttpResponse = orderController.queryOrders(orderDto3);
        log.info("用户id和订单状态查询结果：{}",myHttpResponse.getDetails());
    }

    /**
     * 订单创建测试
     */
    @Test
    void createOrders(){
        // 参数测试
        OrderDto orderDto1 = new OrderDto();
        orderDto1.setUserId(1L);
        MyHttpResponse myHttpResponse = null;
        try {
            myHttpResponse = orderController.createOrders(orderDto1);
        } catch (OrderException e) {
            log.info("出现异常！",e);
        }

        // 参数测试
        OrderDto orderDto2 = new OrderDto();
        orderDto2.setProductId(1L);
        try {
            myHttpResponse = orderController.createOrders(orderDto2);
        } catch (OrderException e) {
            log.info("出现异常！",e);
        }

        // 无商品测试
        OrderDto orderDto3 = new OrderDto();
        orderDto3.setUserId(1L);
        orderDto3.setProductId(3L);
        try {
            myHttpResponse = orderController.createOrders(orderDto3);
        } catch (OrderException e) {
            log.info("出现异常！",e);
        }

        // 正常测试
        OrderDto orderDto4 = new OrderDto();
        orderDto4.setUserId(1L);
        orderDto4.setProductId(1L);
        try {
            myHttpResponse = orderController.createOrders(orderDto4);
        } catch (OrderException e) {
            log.info("出现异常！",e);
        }

        if(myHttpResponse.getCode().equals(0)) {
            log.info("创建订单测试成功");
        }
    }

}
