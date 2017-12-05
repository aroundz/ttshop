package com.qf.ttshop.dao;

import com.qf.ttshop.common.dto.Page;
import com.qf.ttshop.pojo.po.TbItem;
import com.qf.ttshop.pojo.vo.TbItemCustom;

import java.util.List;
import java.util.Map;

public interface TbItemCustomMapper {

    //符合条件的总记录数
    long countItems(Map<String,Object> map);

    //指定页码的记录集合
    List<TbItemCustom> listItems(Map<String,Object> map);
}