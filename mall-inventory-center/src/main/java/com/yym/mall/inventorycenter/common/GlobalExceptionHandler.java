package com.yym.mall.inventorycenter.common;

import com.yym.mall.common.comm.MyHttpResponse;
import com.yym.mall.inventorycenter.exception.InventoryException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;

/**
 * 统一异常处理
 * @author yanyimin
 * @date 2020-06-18 10:42
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public MyHttpResponse globalException(HttpServletRequest request, Exception e) {

        if (e instanceof InventoryException) {
            InventoryException orderException = (InventoryException) e;
            return new MyHttpResponse(orderException.getCode(), MessageFormat.format(orderException.getMessage(),orderException.getObjs()),"");
        }

        // 系统异常打印请求内容
        log.error("请求url：{}，请求Method：{}，接口异常，{}", request.getServletPath(),
                request.getMethod(), e);
        return MyHttpResponse.error("服务异常");
    }
}
