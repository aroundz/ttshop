package com.qf.ttshop.common.dto;

import java.util.List;

public class Result<T> {
    //符合条件的记录总数
    private Long total;
    //指定页码查询出来记录集合
    private List<T> rows;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
