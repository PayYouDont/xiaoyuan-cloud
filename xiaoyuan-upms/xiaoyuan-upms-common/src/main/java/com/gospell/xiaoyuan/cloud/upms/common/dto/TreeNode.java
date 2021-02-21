package com.gospell.xiaoyuan.cloud.upms.common.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * description: TreeNode <br>
 * date: 2021/1/8 10:24 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */
@Data
public class TreeNode {
    protected Long id;
    protected Long parentId;
    private Integer sort;
    protected List<TreeNode> children = new ArrayList<> ();

    public void addChildren(TreeNode treeNode) {
        children.add(treeNode);
    }

    public List<TreeNode> getChildren() {
        if(children.size()<=0){
            return null;
        }
        return children;
    }
}
