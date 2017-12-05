package com.qf.ttshop.common.dto;

public class Page {
    //当前页
    private int page;
    //每页显示条数
    private int rows;
    //偏移量（每页第一条的索引号）
    private int offset;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getOffset() {
        return (page-1)*rows;
    }
}
