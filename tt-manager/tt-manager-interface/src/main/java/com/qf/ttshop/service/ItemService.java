package com.qf.ttshop.service;

import com.qf.ttshop.common.dto.Order;
import com.qf.ttshop.common.dto.Page;
import com.qf.ttshop.common.dto.Result;
import com.qf.ttshop.pojo.po.TbItem;
import com.qf.ttshop.pojo.vo.TbItemCustom;
import com.qf.ttshop.pojo.vo.TbItemQuery;

import java.util.List;

public interface ItemService {
    //通过商品主键查单个商品
    TbItem getById(Long itemId);

    Result<TbItemCustom> listItems(Page page, Order order, TbItemQuery query);

    //批量修改商品
    int itemsBatch(List<Long> ids);

    //新增商品
    int saveItem(TbItem tbItem, String content, String paramData);
}
