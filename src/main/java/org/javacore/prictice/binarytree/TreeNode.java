package org.javacore.prictice.binarytree;

/**
 *  树节点构建，
 * Created by ddfhznq on 2017/11/22.
 */
public class TreeNode {

    public int val;

    public TreeNode right;
    public TreeNode left;

    public TreeNode(int val) {
        this.left = null;
        this.right = null;
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }


}
