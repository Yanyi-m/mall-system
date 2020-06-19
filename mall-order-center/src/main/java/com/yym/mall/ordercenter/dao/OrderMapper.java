package com.yym.mall.ordercenter.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yym.mall.ordercenter.model.dto.OrderDto;
import com.yym.mall.ordercenter.model.dto.OrderQueryDto;
import com.yym.mall.ordercenter.model.vo.OrderVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 订单持久层
 * @author yanyimin
 * @date 2020-06-17 17:21
 */
@Repository
public interface OrderMapper extends BaseMapper<OrderDto> {

    /**
     * 获取订单
     * @param page
     * @param orderQueryDto
     * @return
     */
    IPage<OrderVo> queryOrders(Page<?> page, @Param("orderQueryDto") OrderQueryDto orderQueryDto);


}
