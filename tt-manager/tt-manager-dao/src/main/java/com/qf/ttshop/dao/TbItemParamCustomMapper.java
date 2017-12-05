package com.qf.ttshop.dao;

import com.qf.ttshop.common.dto.Page;
import com.qf.ttshop.pojo.po.TbItemParam;
import com.qf.ttshop.pojo.vo.TbItemParamCustom;

import java.util.List;
import java.util.Map;

public interface TbItemParamCustomMapper {

    //总记录数
    long countItemParams();

    //分页查询
    List<TbItemParamCustom> listItemParams(Map<String,Object> map);
}
