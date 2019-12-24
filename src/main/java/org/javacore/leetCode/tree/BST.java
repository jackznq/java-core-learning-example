package org.javacore.leetCode.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @program: java-core-learning-example
 * @description: 二分搜索树
 * @author: znq
 * @create: 2019-12-03 19:49
 **/
public class BST<E extends Comparable<E>> {

    private TreeNode root;

    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public BST(TreeNode root) {
        this.root = root;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addRecur(E e) {
        root = add(root, e);
    }

    public TreeNode add(TreeNode node, E e) {
        if (node == null) {
            size++;
            return new TreeNode(e);
        }

        if (node.e.compareTo(e) < 0) {
            node.right = add(node.right, e);
        } else {
            node.left = add(node.left, e);
        }
        return node;
    }


    public void addForeach(E e) {
        if (root == null) {
            root = new TreeNode(e);

        } else {
            TreeNode node = root;
            while (node != null) {

                if (node.e.compareTo(e) > 0) {
                    if (node.left == null) {
                        node.left = new TreeNode(e);
                        break;
                    } else {
                        node = node.left;
                    }
                } else if (node.e.compareTo(e) < 0) {
                    if (node.right == null) {
                        node.right = new TreeNode(e);
                        break;
                    } else {
                        node = node.right;
                    }
                } else {
                    break;
                }
            }
        }
        size++;
    }

    public void preOrderForeach() {//先序遍历
        //先序遍历
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        stack.push(cur);
        while (stack.size() > 0) {
            TreeNode pop = stack.pop();
            if (pop != null) {
                System.out.println(pop.e);
                if (pop.right != null) {
                    stack.push(pop.right);
                }
                if (pop.left != null) {
                    stack.push(pop.left);
                }
            }
        }

    }

    public void inOrderTraversal() {  //中序遍历
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || stack.size() > 0) {
            if (node != null) {
                stack.push(node);   //直接压栈
                node = node.getLeft();
            } else {
                node = stack.pop(); //出栈并访问
                System.out.println(node.e);
                node = node.getRight();

            }
        }
    }

    /**
     * 有点：更快的找到元素
     * 采用队列进行广度遍历
     */
    public void levelOrder() {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            System.out.println(node.e);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        generateString(root, 0, sb);
        return sb.toString();
    }

    private void generateString(TreeNode node, int depth, StringBuilder sb) {
        if (node == null) {
            sb.append(genetateDepthString(depth) + "\n");
            return;
        }

        sb.append(genetateDepthString(depth) + node.e + "\n");
        generateString(node.left, depth + 1, sb);
        generateString(node.right, depth + 1, sb);

    }

    private String genetateDepthString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }
        return sb.toString();
    }

}
