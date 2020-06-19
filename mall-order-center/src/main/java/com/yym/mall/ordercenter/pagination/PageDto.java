package com.yym.mall.ordercenter.pagination;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.util.List;

/**
 * 
 * 分页实体类
 * @author yanyimin
 * @date 2020-06-17 17:08
 */
@Data
public class PageDto<T> {

	/**
	 * 总数
	 */
	private Long totalCount;

	/**
	 * 总页数
	 */
	private Long totalPages;

	/**
	 * 当前页内容
	 */
	private List<T> data;

	/**
	 * 初始化
	 * @param page mybatis-plus的分页实体
	 */
	public PageDto<T> initPage(IPage<T> page){
		setData(page.getRecords());
		setTotalCount(page.getTotal());
		setTotalPages(page.getPages());
		return this;
	}

}
