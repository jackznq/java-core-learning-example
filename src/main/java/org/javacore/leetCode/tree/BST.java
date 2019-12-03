package org.javacore.leetCode.tree;

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

    private TreeNode add(TreeNode node, E e) {
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
            size++;
        } else {
            TreeNode node = root;
            while (node != null) {

                if (node.e.compareTo(e) < 0) {
                    if (node.left == null) {
                        size++;
                        node.left = new TreeNode(e);
                        break;
                    } else {
                        node = node.left;
                    }
                } else if (node.e.compareTo(e) > 0) {
                    if (node.right == null) {
                        size++;
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
    }

    @Override
    public String toString() {
        return "BST{" +
            "root=" + root +
            '}';
    }

    public static void main(String[] args) {
        Integer arr[] = {1, 2, 3, 5, 6, 7};
        TreeNode treeNode = new TreeNode();
        TreeNode result = treeNode.createBinaryTreeByArray(arr, 0);
        BST bst = new BST(result);
        bst.addForeach(4);
        bst.toString();
    }
}
