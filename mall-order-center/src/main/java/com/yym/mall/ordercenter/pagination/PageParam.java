package com.yym.mall.ordercenter.pagination;

import lombok.Data;

/**
 * @author yanyimin
 * @date 2020-06-18 20:04
 */
@Data
public class PageParam {

    /**
     * 默认第一页
     */
    private static final int DEFAULT_NO = 1;

    /**
     * 默认每页20条
     */
    private static final int DEFAULT_SIZE = 20;

    /**
     * 页码
     */
    protected Integer pageNo = DEFAULT_NO;

    /**
     * 每页记录数
     */
    protected Integer pageSize = DEFAULT_SIZE;

    public Integer getOffset() {
        return (pageNo - 1) * pageSize;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo == null || pageNo <= 0 ? DEFAULT_NO : pageNo;
    }

    public Integer getLimit() {
        return getPageSize();
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize == null || pageSize <= 0 ? DEFAULT_SIZE : pageSize;
    }
}
