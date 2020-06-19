package com.yym.mall.inventorycenter.model.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yym.mall.inventorycenter.enums.OptionTypeEnum;
import lombok.Data;

import java.util.Date;

/**
 * 库存记录
 * @author yanyimin
 * @date 2020-06-19 08:51
 */
@Data
@TableName("mall_inventory_records")
public class InventoryRecordDto {

    @TableId(value = "id", type = IdType.AUTO)
    protected Long id;

    /**
     * 产品id
     */
    protected Long productId;

    /**
     * 订单号
     */
    protected String orderNo;

    /**
     * 创建时间
     */
    protected Date createTime;

    /**
     * 更新时间
     */
    protected Date updateTime;

    /**
     * 操作类型，1 - 扣减，2 - 回滚
     * @see OptionTypeEnum
     */
    protected Integer optionType;
}
