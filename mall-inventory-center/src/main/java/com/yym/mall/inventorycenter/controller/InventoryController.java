package com.yym.mall.inventorycenter.controller;

import com.yym.mall.common.comm.MyHttpResponse;
import com.yym.mall.inventorycenter.constants.ExceptionConstants;
import com.yym.mall.inventorycenter.exception.InventoryException;
import com.yym.mall.inventorycenter.model.dto.InventoryRecordDto;
import com.yym.mall.inventorycenter.service.impl.InventoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存控制层
 * @author yanyimin
 * @date 2020-06-18 16:09
 */
@RestController
public class InventoryController {

    @Autowired
    InventoryServiceImpl inventoryService;

    /**
     * 扣减流程：
     * 1.检查订单号是否重复扣减
     * 2.扣减库存（数据库加锁）
     * 3.扣减记录
     * 4.返回商品
     *
     * @param productId
     * @return
     * @throws Exception 扣减失败则抛出异常
     */
    @RequestMapping("/deduct")
    public MyHttpResponse deduct(Long productId, String orderNo) throws Exception{
        // 检查扣减记录
        if(!inventoryService.checkInventoryRecord(orderNo,productId)){
            throw InventoryException.build(ExceptionConstants.DEDUCT_REPEAT.setObj(orderNo,productId));
        }
        // 库存扣减
        if(!inventoryService.deduct(productId)){
            throw InventoryException.build(ExceptionConstants.INVENTORY_NOT_ENOUGH.setObj(productId));
        }
        // 记录扣减记录
        InventoryRecordDto inventoryRecordDto = new InventoryRecordDto();
        inventoryRecordDto.setOrderNo(orderNo);
        inventoryRecordDto.setProductId(productId);
        inventoryService.saveInventoryRecord(inventoryRecordDto);
        // 获取商品
        return MyHttpResponse.success(inventoryService.queryProduct(productId));
    }
}
