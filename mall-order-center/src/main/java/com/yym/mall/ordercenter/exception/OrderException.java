package com.yym.mall.ordercenter.exception;

import com.yym.mall.ordercenter.model.dto.ExceptionDto;
import lombok.Data;

/**
 * 订单服务异常类
 * @author yanyimin
 * @date 2020-06-18 11:05
 */
@Data
public class OrderException extends Exception{

    private Integer code;
    private String key;
    private Object[] objs;

    public OrderException(Integer code,String key){
        super(key);
        this.code = code;
        this.key = key;
    }

    public OrderException(Integer code,String key,Object... objs){
        super(key);
        this.code = code;
        this.key = key;
        this.objs = objs;
    }

    public static OrderException build(ExceptionDto exceptionDto){
        return new OrderException(exceptionDto.getCode(),exceptionDto.getKey(),exceptionDto.getObjs());
    }
}
