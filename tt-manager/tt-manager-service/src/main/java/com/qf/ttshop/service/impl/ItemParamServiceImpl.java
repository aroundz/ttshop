package com.qf.ttshop.service.impl;

import com.qf.ttshop.common.dto.Order;
import com.qf.ttshop.common.dto.Page;
import com.qf.ttshop.common.dto.Result;
import com.qf.ttshop.dao.TbItemParamCustomMapper;
import com.qf.ttshop.dao.TbItemParamMapper;
import com.qf.ttshop.pojo.po.TbItemParam;
import com.qf.ttshop.pojo.po.TbItemParamExample;
import com.qf.ttshop.pojo.vo.TbItemParamCustom;
import com.qf.ttshop.service.ItemParamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemParamServiceImpl implements ItemParamService{

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbItemParamCustomMapper itemParamCustomDao;
    @Autowired
    private TbItemParamMapper itemParamDao;

    //分页查询规格参数
    @Override
    public Result<TbItemParamCustom> countItemParam(Page page, Order order) {
        Result<TbItemParamCustom> result=null;
        try {
            //0.封装一个map
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("page",page);
            map.put("order",order);
            //1.先查询总记录数
            long total=itemParamCustomDao.countItemParams();
            //2.查询指定页码的集合
            List<TbItemParamCustom> list=itemParamCustomDao.listItemParams(map);
            //3.放入result中
            result=new Result<TbItemParamCustom>();
            result.setTotal(total);
            result.setRows(list);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return result;
    }

    //新增规格参数
    @Transactional
    @Override
    public int saveItemParam(Long cid, String paramData) {
        int i=0;
        try{
            TbItemParam itemParam=new TbItemParam();
            itemParam.setItemCatId(cid);
            itemParam.setParamData(paramData);
            itemParam.setCreated(new Date());
            itemParam.setUpdated(new Date());
            i=itemParamDao.insertSelective(itemParam);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }

    //根据cid查询规格参数
    @Override
    public TbItemParam getByCid(Long cid) {
        TbItemParam tbItemParam=null;
        try {
            //创建模版
            TbItemParamExample example = new TbItemParamExample();
            TbItemParamExample.Criteria criteria = example.createCriteria();
            criteria.andItemCatIdEqualTo(cid);
            List<TbItemParam> list = itemParamDao.selectByExampleWithBLOBs(example);
            if(list!=null&&list.size()>0) {
                tbItemParam = list.get(0);
            }
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return tbItemParam;
    }
}
