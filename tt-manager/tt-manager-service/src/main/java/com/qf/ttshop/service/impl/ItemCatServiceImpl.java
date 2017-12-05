package com.qf.ttshop.service.impl;

import com.qf.ttshop.common.dto.TreeNode;
import com.qf.ttshop.dao.TbItemCatMapper;
import com.qf.ttshop.pojo.po.TbItemCat;
import com.qf.ttshop.pojo.po.TbItemCatExample;
import com.qf.ttshop.service.ItemCatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService{

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbItemCatMapper itemCatDao;

    @Override
    public List<TreeNode> listItemCatsForTree(Long parentId) {
        List<TreeNode> nodeList=null;
        try {
            //创建模版
            TbItemCatExample example = new TbItemCatExample();
            TbItemCatExample.Criteria criteria = example.createCriteria();
            criteria.andParentIdEqualTo(parentId);
            //执行查询
            List<TbItemCat> itemCatList = itemCatDao.selectByExample(example);
            nodeList=new ArrayList<TreeNode>();
            for(TbItemCat itemCat:itemCatList){
                TreeNode treeNode = new TreeNode();
                treeNode.setId(itemCat.getId());
                treeNode.setText(itemCat.getName());
                treeNode.setState(itemCat.getIsParent()?"closed":"open");
                nodeList.add(treeNode);
            }
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return nodeList;
    }
}
