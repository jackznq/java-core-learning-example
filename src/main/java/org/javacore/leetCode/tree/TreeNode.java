package org.javacore.leetCode.tree;

import lombok.Data;

/**
 * 树节点构建，
 * Created by ddfhznq on 2017/11/22.
 */
@Data
public class TreeNode<E extends Comparable<E>> {

    public int val;
    public E e;
    public TreeNode right;
    public TreeNode left;

    public TreeNode(int val) {
        this.left = null;
        this.right = null;
        this.val = val;
    }

    public TreeNode(E e) {
        this.e = e;
        this.left = null;
        this.right = null;
    }

    public static TreeNode createBinaryTreeByArray(int[] array, int index) {
        TreeNode tn = null;
        if (index < array.length) {
            int value = array[index];
            tn = new TreeNode(value);
            tn.left = createBinaryTreeByArray(array, 2 * index + 1);
            tn.right = createBinaryTreeByArray(array, 2 * index + 2);
            return tn;
        }
        return tn;
    }

}
