package com.yym.mall.inventorycenter.exception;

import com.yym.mall.inventorycenter.model.dto.ExceptionDto;
import lombok.Data;

/**
 * 库存异常
 * @author yanyimin
 * @date 2020-06-18 10:12
 */
@Data
public class InventoryException extends Exception{

    private Integer code;
    private String key;
    private Object[] objs;

    public InventoryException(Integer code,String key){
        super(key);
        this.code = code;
        this.key = key;
    }

    public InventoryException(Integer code,String key,Object... objs){
        super(key);
        this.code = code;
        this.key = key;
        this.objs = objs;
    }

    public static InventoryException build(ExceptionDto exceptionDto){
        return new InventoryException(exceptionDto.getCode(),exceptionDto.getKey(),exceptionDto.getObjs());
    }
}
