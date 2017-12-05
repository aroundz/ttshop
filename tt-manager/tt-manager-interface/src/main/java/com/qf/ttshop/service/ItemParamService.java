package com.qf.ttshop.service;

import com.qf.ttshop.common.dto.Order;
import com.qf.ttshop.common.dto.Page;
import com.qf.ttshop.common.dto.Result;
import com.qf.ttshop.pojo.po.TbItemParam;
import com.qf.ttshop.pojo.vo.TbItemParamCustom;

public interface ItemParamService {
    Result<TbItemParamCustom> countItemParam(Page page,Order order);

    int saveItemParam(Long cid, String paramData);

    TbItemParam getByCid(Long cid);
}
