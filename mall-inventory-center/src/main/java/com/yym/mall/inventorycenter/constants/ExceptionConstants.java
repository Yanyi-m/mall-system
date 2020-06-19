package com.yym.mall.inventorycenter.constants;

import com.yym.mall.inventorycenter.model.dto.ExceptionDto;

/**
 * 异常常量类
 * @author yanyimin
 * @date 2020-06-19 09:15
 */
public class ExceptionConstants {

    public static final ExceptionDto INVENTORY_NOT_ENOUGH = new ExceptionDto(100001,"产品{0}库存不足!");

    public static final ExceptionDto DEDUCT_REPEAT = new ExceptionDto(100002,"订单号{0}，产品{1}重复扣减!");
}
