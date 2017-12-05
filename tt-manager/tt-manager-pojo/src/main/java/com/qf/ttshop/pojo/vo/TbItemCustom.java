package com.qf.ttshop.pojo.vo;

import com.qf.ttshop.pojo.po.TbItem;

/**
 * 商品表的VO类
 */
public class TbItemCustom extends TbItem{
    private String catName;
    private String statusName;

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
}
