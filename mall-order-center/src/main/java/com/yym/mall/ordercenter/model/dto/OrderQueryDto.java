package com.yym.mall.ordercenter.model.dto;

import com.yym.mall.ordercenter.pagination.PageParam;
import lombok.Data;

/**
 * @author yanyimin
 * @date 2020-06-18 17:13
 */
@Data
public class OrderQueryDto extends PageParam {

    /**
     * 订单号
     */
    protected String orderNo;

    /**
     * 产品id
     */
    protected Long productId;

    /**
     * 用户id
     */
    protected Long userId;

    /**
     * 订单状态
     */
    protected Integer orderStatus;


}
