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
        System.out.print(node.getVal() + " ");
    }

    /**
     * 初始化传入数组时就开始构建
     *
     * @param array
     */
    public TreeNodeTraversal(int[] array) {
        root = createBinaryTreeByArray(array, 0);
    }

    /**
     * 用数组构建二叉树
     * int a[] = {1, 2, 2, 3, 4, 4, 3};
     *
     * @param array 传入数组
     * @param index 数组索引，一般从0开始即根节点开始
     * @return TreeNode
     */
    public TreeNode createBinaryTreeByArray(int[] array, int index) {
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

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 6, 7};
        TreeNodeTraversal treeNode = new TreeNodeTraversal(a);
//        System.out.println("中序遍历");
//        theInOrderTraversal(treeNode.getRoot());
        System.out.println("先序序遍历");
//        theFirstTraversal_Stack(treeNode.getRoot());
        String s ="1,2,3";
        char s1[] =s.toCharArray();
        System.out.println(s1.toString());
    }
}
