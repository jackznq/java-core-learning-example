package org.javacore.leetCode.tree;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 * <p>
 * 235. Lowest Common Ancestor of a Binary Search Tree
 */
class Solution {

    /**
     * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
     * <p>
     * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
     * <p>
     * Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
     * <p>
     * _______6______
     * /              \
     * ___2__          ___8__
     * /      \        /      \
     * 0      _4       7       9
     * /  \
     * 3   5
     * Example 1:
     * <p>
     * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
     * Output: 6
     * Explanation: The LCA of nodes 2 and 8 is 6.
     * Example 2:
     * <p>
     * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
     * Output: 2
     * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself
     * according to the LCA definition.
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return null;

    }


    /**
     * 100
     * Given two binary trees, write a function to check if they are the same or not.
     * <p>
     * Two binary trees are considered the same
     * if they are structurally identical and the nodes have the same value.
     *
     * @param p
     * @param q
     * @return
     */


    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        four.left = three;
        four.right = five;
        three.left = one;
        three.right = two;
        five.left = six;
        five.right = seven;
        List result = Lists.newArrayList();


        TreeNode one1 = new TreeNode(1);
        TreeNode one2 = new TreeNode(2);
        one1.left = one2;
        TreeNode two1 = new TreeNode(1);
        TreeNode two2 = new TreeNode(2);
        two1.right = two2;


    }


}
