package org.javacore.leetCode.tree;

/**
 * @program: java-core-learning-example
 * @description: avl
 * @author: znq
 * @create: 2020-02-26 16:21
 **/
public class AVLTree<K extends Comparable<? super K>, V> {


    private class Node {
        public K k;
        public V v;
        public Node right;
        public Node left;
        public int height;


        public Node(K e, V v) {
            this.k = e;
            this.v = v;
            this.left = null;
            this.right = null;
            height = 1;
        }


    }

    private Node root;

    private int size;

    public AVLTree() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    //记录节点的高度
    private int getHeight(Node node) {
        if (null == node) return 0;
        return node.height;
    }

    //获取平衡因子
    private int getBalanceFactor(Node node) {
        if (null == node) return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    public void add(K k, V v) {
        root = add(root, k, v);
    }

    private Node add(Node node, K k, V v) {
        if (node == null) {
            size++;
            return new Node(k, v);
        }

        if (node.k.compareTo(k) < 0) {
            node.right = add(node.right, k, v);
        } else {
            node.left = add(node.left, k, v);
        }
        node.height = 1 + Math.max(getHeight(node.right), getHeight(node.left));
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) >= 2) {
            System.out.println("不平衡");
        }
        return node;
    }


}
