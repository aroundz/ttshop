package com.qf.ttshop.common.dto;

import java.util.ArrayList;
import java.util.List;

public class Order {
    //字段名
    private String sort;
    //desc或者asc
    private String order;

    public List<String> getOrderParams() {
        String[] sorts = this.sort.split(",");
        String[] orders = this.order.split(",");
        List<String> list=new ArrayList<String>();
        for(int i=0;i<sorts.length;i++){
            String str=sorts[i]+" "+orders[i];
            list.add(str);
        }
        return list;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
