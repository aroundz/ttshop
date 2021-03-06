package com.qf.ttshop.web;

import com.qf.ttshop.common.dto.TreeNode;
import com.qf.ttshop.service.ItemCatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ItemCatAction {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ItemCatService itemCatService;

    @ResponseBody
    @RequestMapping(value = "/itemCats",method = RequestMethod.GET)
    public List<TreeNode> listItemCatsForTree(@RequestParam("parentId")Long parentId){
        List<TreeNode> nodeList=null;
        try {
            nodeList=itemCatService.listItemCatsForTree(parentId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return nodeList;
    }
}
