package org.javacore.leetCode.practice;


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



    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 6, 7};
        for (int i = 0; i < a.length; i++) {
//            buildTree(root, a[i]);
        }
//        System.out.println(isSymmetric(root));
        System.out.println(5 ^ 30);
    }
}
