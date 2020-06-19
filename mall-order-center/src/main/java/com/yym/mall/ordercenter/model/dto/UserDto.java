package com.yym.mall.ordercenter.model.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

/**
 * 用户实体
 * @author yanyimin
 * @date 2020-06-19 15:39
 */
@Data
@Builder
public class UserDto {

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    protected Long id;

    /**
     * 送货地址
     */
    protected String shipAddress;
}
