package org.javacore.leetCode.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    /**
     * 102. Binary Tree Level Order Traversal
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> integerList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                integerList.add((Integer) poll.getE());
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }

            }
            result.add(integerList);
        }
        return result;
    }


}
