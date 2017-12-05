package com.qf.ttshop.pojo.vo;

/**
 * 模糊查询的简单实体类
 */
public class TbItemQuery {
    private String title;
    private Byte status;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
