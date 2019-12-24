package org.javacore.leetCode.tree;


class Solution {

    public static void main(String[] args) {

        BST bst = new BST();
//        bst.addForeach(3);
//        bst.addForeach(6);
//        bst.addForeach(1);
//        bst.addForeach(2);
//        bst.addForeach(5);
//        bst.addForeach(7);
        bst.addRecur(3);
        bst.addRecur(6);
        bst.addRecur(1);
        bst.addRecur(2);
        bst.addRecur(5);
        bst.addRecur(7);
//        System.out.println(bst);
//        bst.preOrderForeach();
//        System.out.println("----");
//        bst.inOrderTraversal();
//        System.out.println("----");
//        bst.levelOrder();
        System.out.println("-------------------------");
        System.out.println(bst.removeMin());
        System.out.println(bst.toString());
        System.out.println("-------------------------");

        System.out.println(bst.removeMax());
        System.out.println(bst.toString());
        System.out.println("-------------------------");

        System.out.println(bst.removeMax());
        System.out.println(bst.toString());
    }


}
