package org.javacore.binarytree;

/**
 * 二叉树的递归遍历
 * Created by znq on 2018/3/6.
 */
public class BinaryTree {


    /**
     * 前序遍历
     * 根节点-左孩子-右孩子
     *
     * @param head
     */
//    void preOrderRecur(Node head) {
//        if (null == head) {
//            return;
//        }
//        System.out.println(head.val + " ");
//        preOrderRecur(head.left);
//        preOrderRecur(head.right);
//    }
    StringBuffer sb = new StringBuffer();

    String preOrderRecur(Node head) {
        if (null == head) {
            return "";
        }
//        System.out.println(head.val + " ");
        sb.append(head.val);
        sb.append("!");
        if (head.left != null) {
            preOrderRecur(head.left);
        } else {
            sb.append("#!");
        }
        if (head.right != null) {
            preOrderRecur(head.right);
        } else {
            sb.append("#!");
        }

        return sb.toString();
    }

    /**
     * 中序遍历
     * 左孩子-根节点-右孩子
     *
     * @param head
     */
    void inOrderPocur(Node head) {
        if (null == head) {
            return;
        }

        inOrderPocur(head.left);
        System.out.println(head.val + " ");
        inOrderPocur(head.right);
    }

    /**
     * 后序
     * 左孩子-右孩子-根节点
     *
     * @param head
     */
    void posOrderRecur(Node head) {
        if (null == head) {
            return;
        }

        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.println(head.val + " ");

    }

    static class Node {
        private int val;

        private Node left;

        private Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    /**
     *  二叉树序列化
     * @param head
     * @return
     */
    String serialByPre(Node head) {
        if (null == head) {
            return "#!";
        }
        return preOrderRecur(head);

    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node a1 = new Node(2);
        Node a2 = new Node(3);
        Node a3 = new Node(4);
        Node a4 = new Node(5);
        Node a5 = new Node(6);
        a.left = a1;
        a.right = a2;
        a1.left = a3;
        a1.right = a4;
        a2.left = a5;
        BinaryTree binaryTree = new BinaryTree();
        System.out.println("前序遍历");
//        binaryTree.preOrderRecur(a);
        System.out.println("中序遍历");
        binaryTree.inOrderPocur(a);
        System.out.println("后序遍历");
        binaryTree.posOrderRecur(a);
        System.out.println("二叉树序列化");
        System.out.println(binaryTree.serialByPre(a));
    }
}
