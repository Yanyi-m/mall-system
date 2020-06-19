package com.yym.mall.inventorycenter.service;

import com.yym.mall.inventorycenter.model.dto.InventoryRecordDto;
import com.yym.mall.inventorycenter.model.dto.ProductDto;

/**
 * 库存服务接口
 * @author yanyimin
 * @date 2020-06-18 21:43
 */
public interface InventoryService {

    /**
     * 检查库存记录
     * @param orderNo 订单号
     * @param productId 产品id
     * @return
     */
    boolean checkInventoryRecord(String orderNo,Long productId);

    /**
     * 检查库存
     * @param productId 产品id
     * @return
     */
    boolean deduct(Long productId);

    /**
     * 获取产品
     * @param productId 产品id
     * @return
     */
    ProductDto queryProduct(Long productId);

    /**
     * 插入库存记录
     * @param inventoryRecordDto 库存记录实体
     */
    void saveInventoryRecord(InventoryRecordDto inventoryRecordDto);
}
