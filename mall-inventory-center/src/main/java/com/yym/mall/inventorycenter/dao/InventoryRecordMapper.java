package com.yym.mall.inventorycenter.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yym.mall.inventorycenter.model.dto.InventoryRecordDto;
import org.springframework.stereotype.Repository;

/**
 * 库存记录
 * @author yanyimin
 * @date 2020-06-19 08:51
 */
@Repository
public interface InventoryRecordMapper extends BaseMapper<InventoryRecordDto> {

}
