package com.yym.mall.ordercenter.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 订单号工具类
 * @author yanyimin
 * @date 2020-06-19 09:23
 */
public class OrderNoUtil {

    /**
     * 订单编号前缀
     */
    public static final String PREFIX = "1000_";

    /**
     * 订单编号后缀
     */
    private static long code;

    /**
     * 根据时间戳获取订单号
     * @return
     */
    public static synchronized String getOrderCode() {
        code++;
        String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        long m = Long.parseLong((str)) * 10000;
        m += code;
        return PREFIX + m;
    }

}
