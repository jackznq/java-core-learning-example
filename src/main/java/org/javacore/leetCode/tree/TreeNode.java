package org.javacore.leetCode.tree;

import lombok.Data;
import lombok.ToString;

/**
 * 树节点构建，
 * Created by ddfhznq on 2017/11/22.
 */
@Data
@ToString
public class TreeNode<E extends Comparable<E>> {

    public E e;
    public TreeNode right;
    public TreeNode left;

    public TreeNode(int val) {
        this.left = null;
        this.right = null;
    }

    public TreeNode(E e) {
        this.e = e;
        this.left = null;
        this.right = null;
    }

    public TreeNode() {
        this.left = null;
        this.right = null;
        this.e = null;
    }

    public TreeNode createBinaryTreeByArray(E[] array, int index) {
        TreeNode tn = null;
        if (index < array.length) {
            E value = array[index];
            tn = new TreeNode(value);
            tn.left = createBinaryTreeByArray(array, 2 * index + 1);
            tn.right = createBinaryTreeByArray(array, 2 * index + 2);
            return tn;
        }
        return tn;
    }

}
