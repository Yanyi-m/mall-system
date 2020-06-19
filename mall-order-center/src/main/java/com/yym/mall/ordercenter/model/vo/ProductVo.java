package com.yym.mall.ordercenter.model.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;

/**
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

    /**
     * 名称
     */
    protected String name;
}
