package com.qf.ttshop.web;

import com.qf.ttshop.common.dto.Order;
import com.qf.ttshop.common.dto.Page;
import com.qf.ttshop.common.dto.Result;
import com.qf.ttshop.pojo.po.TbItem;
import com.qf.ttshop.pojo.vo.TbItemCustom;
import com.qf.ttshop.pojo.vo.TbItemQuery;
import com.qf.ttshop.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ItemAction {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ItemService itemService;

    @ResponseBody
    @RequestMapping(value="/item/{itemId}",method= RequestMethod.GET)
    public TbItem printJsonById(@PathVariable("itemId")Long itemId){
        return itemService.getById(itemId);
    }

    //    @ResponseBody
//    @RequestMapping(value = "/items", method = RequestMethod.GET)
//    public List<TbItem> listItems() {
//        List<TbItem> tbItemList = null;
//        try {
//            tbItemList = itemService.listItems();
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//            e.printStackTrace();
//        }
//        return tbItemList;
//    }

    //带条件分页查询
    @ResponseBody
    @RequestMapping(value = "/items",method = RequestMethod.GET)
    public Result<TbItemCustom> listItems(Page page, Order order, TbItemQuery query){
        Result<TbItemCustom> result=null;
        try {
            result=itemService.listItems(page,order,query);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return result;
    }

    //批量删除（修改）
    @ResponseBody
    @RequestMapping(value = "/items/batch",method = RequestMethod.POST)
    public int itemsBatch(@RequestParam("ids[]")List<Long> ids){
        int i=0;
        try{
            i=itemService.itemsBatch(ids);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }

    //新增商品
    @ResponseBody
    @RequestMapping(value = "/item",method = RequestMethod.POST)
    public int saveItem(TbItem tbItem,String content,String paramData){
        int i=0;
        try{
            i=itemService.saveItem(tbItem,content,paramData);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }
}
