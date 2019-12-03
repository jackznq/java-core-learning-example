package org.javacore.prictice;


import org.javacore.leetCode.tree.TreeNode;

/**
 * 对称二叉树
 * Created by ddfhznq on 2017/11/20.
 */
public class SymmetricTree {

    public static TreeNode root = null;

    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.e.compareTo(t2.e) == 0)
            && isMirror(t1.right, t2.left)
            && isMirror(t1.left, t2.right);
    }


    /**
     * 递归创建二叉树
     *
     * @param node
     * @param data
     */
    public static void buildTree(TreeNode node, int data) {
        if (root == null) {
            root = new TreeNode(data);
        } else {
            if (node.e.compareTo(data) > 0) {
                if (node.left == null) {
                    node.left = new TreeNode(data);
                } else {
                    buildTree(node.left, data);
                }
            } else {
                if (node.right == null) {
                    node.right = new TreeNode(data);
                } else {
                    buildTree(node.right, data);
                }
            }
        }
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 6, 7};
        for (int i = 0; i < a.length; i++) {
//            buildTree(root, a[i]);
        }
//        System.out.println(isSymmetric(root));
        System.out.println(5 ^ 30);
    }
}
