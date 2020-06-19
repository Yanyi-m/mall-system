package com.yym.mall.inventorycenter.model.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 商品视图层
 * @author yanyimin
 * @date 2020-06-18 21:58
 */
@Data
public class ProductVo {

    /**
     * id
     */
    @TableId
    protected Long id;

    /**
     * 价格
     */
    protected BigDecimal price;
}
