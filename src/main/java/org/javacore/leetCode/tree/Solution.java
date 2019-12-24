package org.javacore.leetCode.tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Solution {

    public static void main(String[] args) {

        BST bst = new BST();
//        bst.addForeach(3);
//        bst.addForeach(6);
//        bst.addForeach(1);
//        bst.addForeach(2);
//        bst.addForeach(5);
//        bst.addForeach(7);
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            bst.addRecur(random.nextInt(10000));
        }

        List<Integer> result = new ArrayList<>();
        while (!bst.isEmpty()) {
            result.add((Integer) bst.removeMin().e);
        }
        System.out.println(result);
//        System.out.println(bst);
//        bst.preOrderForeach();
//        System.out.println("----");
//        bst.inOrderTraversal();
//        System.out.println("----");
//        bst.levelOrder();
//        System.out.println(bst.removeMin());
//        System.out.println(bst.toString());
//
//        System.out.println(bst.removeMax());
//        System.out.println(bst.toString());
    }


}
