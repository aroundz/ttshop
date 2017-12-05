package com.qf.ttshop.service;

import com.qf.ttshop.common.dto.TreeNode;

import java.util.List;

public interface ItemCatService {
    List<TreeNode> listItemCatsForTree(Long parentId);
}
