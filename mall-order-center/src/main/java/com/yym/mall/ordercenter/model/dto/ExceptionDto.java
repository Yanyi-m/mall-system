package com.yym.mall.ordercenter.model.dto;

import lombok.Data;

/**
 * 异常信息
 * @author yanyimin
 * @date 2020-06-18 10:45
 */
@Data
public class ExceptionDto {

    private Integer code;
    private String key;
    private Object[] objs;

    public ExceptionDto(Integer code, String key){
        this.code = code;
        this.key = key;
    }

    public ExceptionDto(Integer code, String key, Object... objs){
        this.code = code;
        this.key = key;
        this.objs = objs;
    }

    public ExceptionDto format(Object... objs){
        this.objs = objs;
        return this;
    }
}
