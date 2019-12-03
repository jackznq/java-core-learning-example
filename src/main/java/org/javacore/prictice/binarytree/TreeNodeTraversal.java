package org.javacore.prictice.binarytree;

import org.javacore.leetCode.tree.TreeNode;

import java.util.Stack;

/**
 * 二叉树各种遍历，通过堆栈实现前序遍历，中序遍历，后序遍历
 * Created by ddfhznq on 2017/11/22.
 */
public class TreeNodeTraversal {

    private static TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public static void printNode(TreeNode node) {
        System.out.print(node.e + " ");
    }

    /**
     * 初始化传入数组时就开始构建
     *
     * @param array
     */
    public TreeNodeTraversal(Integer[] array) {
//        root = TreeNode.createBinaryTreeByArray(array, 0);
    }



    /**
     * 中序遍历
     * <p>
     * 中序：1.访问左子树
     * <p>
     * 　　　  2.访问根结点
     * <p>
     * 　　     3.访问右子树
     *
     * @param root
     */
    public static void theInOrderTraversal(TreeNode root) {  //中序遍历
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || stack.size() > 0) {
            if (node != null) {
                stack.push(node);   //直接压栈
                node = node.getLeft();
            } else {
                node = stack.pop(); //出栈并访问
                printNode(node);
                node = node.getRight();

            }
        }
    }

    /**
     * 先序： 1.访问根结点
     * <p>
     * 　　　　2.访问左子树
     * <p>
     * 　　　　3.访问右子树
     *
     * @param root root
     */
    public static void theFirstTraversal_Stack(TreeNode root) {
        //先序遍历
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || stack.size() > 0) {
            if (node != null) {
                printNode(node);
                stack.push(node);
                node = node.getLeft();

            } else {
                node = stack.pop();
                node = node.getRight();
            }
        }
    }

}
