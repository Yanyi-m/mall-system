package com.yym.mall.common.comm;

import lombok.Data;

/**
 * 统一响应实体
 * @author yanyimin
 * @date 2020-06-18 10:42
 */
@Data
public class MyHttpResponse {


    public static final Integer SUCCESS = 100;
    public static final Integer ERROR = 101;

    /**
     * 100 - 成功，101 - 系统异常
     */
    private Integer code;

    /**
     * 返回消息
     */
    private String msg;

    /**
     * 返回内容
     */
    private Object details;

    public MyHttpResponse(){
        super();
    }

    /**
     * @param code
     * @param msg
     */
    public MyHttpResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * @param code
     * @param msg
     * @param details
     */
    public MyHttpResponse(Integer code, String msg, Object details) {
        this.code = code;
        this.msg = msg;
        this.details = details;
    }

    /**
     *
     * @param msg
     * @param details
     * @return
     */
    public static MyHttpResponse success(String msg, Object details){
        return new MyHttpResponse(SUCCESS,msg,details);
    }

    public static MyHttpResponse success(Object details){
        return new MyHttpResponse(SUCCESS,"",details);
    }

    /**
     *
     * @param msg
     * @return
     */
    public static MyHttpResponse error(String msg){
        return new MyHttpResponse(ERROR,msg);
    }
}
