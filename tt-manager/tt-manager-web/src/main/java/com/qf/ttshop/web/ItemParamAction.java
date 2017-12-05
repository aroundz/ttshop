package com.qf.ttshop.web;

import com.qf.ttshop.common.dto.Order;
import com.qf.ttshop.common.dto.Page;
import com.qf.ttshop.common.dto.Result;
import com.qf.ttshop.pojo.po.TbItemParam;
import com.qf.ttshop.pojo.vo.TbItemParamCustom;
import com.qf.ttshop.service.ItemParamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ItemParamAction {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ItemParamService itemParamService;
    //@Autowired(来自于spring框架，按类型注入) @Resource（来自于javaee,按名称注入）

    //带条件分页查询
    @ResponseBody
    @RequestMapping(value = "/itemParams",method = RequestMethod.GET)
    public Result<TbItemParamCustom> countItemParam(Page page,Order order){
        Result<TbItemParamCustom> result=null;
        try {
            result=itemParamService.countItemParam(page,order);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return result;
    }

    //新增规格参数
    @ResponseBody
    @RequestMapping(value = "/itemParam/{cid}",method = RequestMethod.POST)
    public int saveItemParam(@PathVariable("cid") Long cid, @RequestParam("paramData") String paramData){
        int i=0;
        try {
            i=itemParamService.saveItemParam(cid,paramData);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }

    //新增商品ajax返回规格参数
    @ResponseBody
    @RequestMapping(value = "/itemParam/{cid}",method = RequestMethod.GET)
    public TbItemParam getByCid(@PathVariable("cid") Long cid){
        TbItemParam tbItemParam=null;
        try {
            tbItemParam=itemParamService.getByCid(cid);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return tbItemParam;
    }

}
