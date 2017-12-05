package com.qf.ttshop.service.impl;

import com.qf.ttshop.common.dto.Order;
import com.qf.ttshop.common.dto.Page;
import com.qf.ttshop.common.dto.Result;
import com.qf.ttshop.common.util.IDUtils;
import com.qf.ttshop.dao.TbItemCustomMapper;
import com.qf.ttshop.dao.TbItemDescMapper;
import com.qf.ttshop.dao.TbItemMapper;
import com.qf.ttshop.dao.TbItemParamItemMapper;
import com.qf.ttshop.pojo.po.TbItem;
import com.qf.ttshop.pojo.po.TbItemDesc;
import com.qf.ttshop.pojo.po.TbItemExample;
import com.qf.ttshop.pojo.po.TbItemParamItem;
import com.qf.ttshop.pojo.vo.TbItemCustom;
import com.qf.ttshop.pojo.vo.TbItemQuery;
import com.qf.ttshop.service.ItemService;
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
public class ItemServiceImpl implements ItemService {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbItemMapper itemDao;
    @Autowired
    private TbItemCustomMapper itemCustomDao;
    @Autowired
    private TbItemDescMapper itemDescDao;
    @Autowired
    private TbItemParamItemMapper itemParamItemDao;

    @Override
    public TbItem getById(Long itemId) {
        return itemDao.selectByPrimaryKey(itemId);
    }

    @Override
    public Result<TbItemCustom> listItems(Page page, Order order, TbItemQuery query) {
        Result<TbItemCustom> result=null;
        try {
            //0.封装一个map
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("page",page);
            map.put("order",order);
            map.put("query",query);
            //1.先查询总记录数
            long total=itemCustomDao.countItems(map);
            //2.查询指定页码的集合
            List<TbItemCustom> list=itemCustomDao.listItems(map);
            //3.存放result中
            result=new Result<TbItemCustom>();
            result.setTotal(total);
            result.setRows(list);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return result;
    }

    @Transactional
    @Override
    public int itemsBatch(List<Long> ids) {
        int i=0;
        try {
            TbItem record = new TbItem();
            record.setStatus((byte) 3);
            //创建模板
            TbItemExample example = new TbItemExample();
            TbItemExample.Criteria criteria = example.createCriteria();
            criteria.andIdIn(ids);
            //执行更新操作
            i=itemDao.updateByExampleSelective(record,example);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }

    //添加了@Transactional这个注解方法叫做事务方法，事务方法并不是越多越好，凡是涉及查询的方法要求不加@Transactional
    //@Transactional尽量精细化，以后会经常调用一些第三方的接口，那么建议调用第三方接口的内容不要加到事务方法中，可以另外添加方法进行解耦操作
    @Transactional
    @Override
    public int saveItem(TbItem tbItem, String content, String paramData) {
        int i=0;
        try {
            //先存tb_item
            long itemId= IDUtils.getItemId();
            tbItem.setId(itemId);
            tbItem.setStatus((byte)1);
            tbItem.setCreated(new Date());
            tbItem.setUpdated(new Date());
            i=itemDao.insert(tbItem);
            //再存tb_item_desc
            TbItemDesc itemDesc = new TbItemDesc();
            itemDesc.setItemId(itemId);
            itemDesc.setItemDesc(content);
            itemDesc.setCreated(new Date());
            itemDesc.setUpdated(new Date());
            i+=itemDescDao.insert(itemDesc);
            //再存tb_item_param_item
            TbItemParamItem itemParamItem = new TbItemParamItem();
            itemParamItem.setItemId(itemId);
            itemParamItem.setParamData(paramData);
            itemParamItem.setCreated(new Date());
            itemParamItem.setUpdated(new Date());
            i += itemParamItemDao.insert(itemParamItem);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }
}
