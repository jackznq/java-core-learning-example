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
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }

        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }
        return node;
    }

    //左旋
    private Node leftRotate(Node y) {
        Node x = y.right;
        Node T3 = x.left;
        x.left = y;
        y.right = T3;
        y.height = Math.max(getHeight(y.right), getHeight(x.left)) + 1;
        x.height = Math.max(getHeight(x.right), getHeight(x.left)) + 1;
        return x;
    }

    //右旋
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T3 = x.right;
        x.right = y;
        y.left = T3;
        y.height = Math.max(getHeight(y.right), getHeight(x.left)) + 1;
        x.height = Math.max(getHeight(x.right), getHeight(x.left)) + 1;
        return x;
    }


}
