package org.javacore.leetCode.tree;

import lombok.Data;

/**
 *  树节点构建，
 * Created by ddfhznq on 2017/11/22.
 */
@Data
public class TreeNode {

    public int val;

    public TreeNode right;
    public TreeNode left;

    public TreeNode(int val) {
        this.left = null;
        this.right = null;
        this.val = val;
    }


}
