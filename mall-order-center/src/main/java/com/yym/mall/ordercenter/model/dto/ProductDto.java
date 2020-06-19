package com.yym.mall.ordercenter.model.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author yanyimin
 * @date 2020-06-18 21:39
 */
@Data
public class ProductDto {

    /**
     * id
     */
    protected Long id;

    /**
     * 价格
     */
    protected BigDecimal price;

    /**
     * 库存
     */
    protected Integer stock;

    /**
     * 创建时间
     */
    protected Date createTime;

    /**
     * 更新时间
     */
    protected Date updateTime;
}
