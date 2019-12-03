package org.javacore.leetCode.tree;

/**
 * @program: java-core-learning-example
 * @description: 二分搜索树
 * @author: znq
 * @create: 2019-12-03 19:49
 **/
public class BST {

    private TreeNode treeNode;

    private int size;

    public BST() {
        treeNode = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
