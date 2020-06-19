package com.yym.mall.ordercenter.service;

import com.yym.mall.common.comm.MyHttpResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 库存服务
 * @author yanyimin
 * @date 2020-06-18 16:02
 */
@FeignClient("inventory-center")
public interface InventoryService {

    /**
     * 库存扣减
     * @param productId 产品id
     * @return
     */
    @RequestMapping("/deduct")
    MyHttpResponse inventoryDeduct(@RequestParam("productId") Long productId);
}
