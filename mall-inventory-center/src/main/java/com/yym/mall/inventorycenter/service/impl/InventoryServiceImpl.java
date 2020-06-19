package com.yym.mall.inventorycenter.service.impl;

import com.yym.mall.inventorycenter.dao.InventoryMapper;
import com.yym.mall.inventorycenter.model.dto.ProductDto;
import com.yym.mall.inventorycenter.service.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 库存服务
 * @author yanyimin
 * @date 2020-06-18 21:45
 */
@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    InventoryMapper inventoryMapper;

    /**
     * 扣减库存
     * @param productId
     * @return
     */
    @Override
    public boolean deduct(Long productId) {
        return inventoryMapper.deduct(productId,new Date());
    }

    /**
     * 获取商品
     * @param productId
     * @return
     */
    @Override
    public ProductDto queryProduct(Long productId) {
        return inventoryMapper.queryProduct(productId);
    }
}
