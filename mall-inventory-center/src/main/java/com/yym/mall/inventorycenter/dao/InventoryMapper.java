package com.yym.mall.inventorycenter.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yym.mall.inventorycenter.model.dto.ProductDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * 库存持久层
 * @author yanyimin
 * @date 2020-06-18 21:47
 */
@Repository
public interface InventoryMapper extends BaseMapper<ProductDto> {

    /**
     * 扣减库存
     * @param productId 产品id
     * @param updateTime 更新时间
     */
    boolean deduct(@Param("productId") Long productId, @Param("updateTime") Date updateTime);

    /**
     * 获取商品
     * @param productId 产品id
     * @return
     */
    ProductDto queryProduct(Long productId);

}
