package com.yym.mall.inventorycenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yym.mall.inventorycenter.dao.InventoryMapper;
import com.yym.mall.inventorycenter.dao.InventoryRecordMapper;
import com.yym.mall.inventorycenter.enums.OptionTypeEnum;
import com.yym.mall.inventorycenter.model.dto.InventoryRecordDto;
import com.yym.mall.inventorycenter.model.dto.ProductDto;
import com.yym.mall.inventorycenter.service.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

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

    @Autowired
    InventoryRecordMapper inventoryRecordMapper;

    /**
     *
     * @param orderNo
     * @param productId
     * @return
     */
    @Override
    public boolean checkInventoryRecord(String orderNo, Long productId) {
        QueryWrapper<InventoryRecordDto> wrapper = new QueryWrapper<>();
        wrapper.eq("order_no",orderNo);
        wrapper.eq("product_id",productId);
        List<InventoryRecordDto> list = inventoryRecordMapper.selectList(wrapper);
        // 如果list大小不为空，则已扣减过
        if(!CollectionUtils.isEmpty(list)){
            return false;
        }
        return true;
    }

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

    @Override
    public void saveInventoryRecord(InventoryRecordDto inventoryRecordDto) {
        Date now = new Date();
        inventoryRecordDto.setCreateTime(now);
        inventoryRecordDto.setUpdateTime(now);
        inventoryRecordDto.setOptionType(OptionTypeEnum.DEDUCT.getIndex());
        inventoryRecordMapper.insert(inventoryRecordDto);
    }
}
