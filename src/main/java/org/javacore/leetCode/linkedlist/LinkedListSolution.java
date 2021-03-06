package org.javacore.leetCode.linkedlist;


import org.javacore.leetCode.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Date 18/11/26 下午9:55
 * @Auther znq
 * @ClassName LinkedListSolution
 **/
public class LinkedListSolution {

    public static void main(String[] args) {
        Integer arr2[] = {1, 2, 3, 4, 5};
        ListNode listNode1 = new ListNode(arr2);
//        ListUtil.sorted(listNode1);
//        System.out.println(ListUtil.sortedInsert(listNode1,10).toString());
//        Integer arr1[] = {4, 5, 6};

//        ListNode listNode2 = new ListNode(arr1);
//        ListUtil.append(listNode1,listNode2);
//        swapPairs(node1);
//        ListNode listNode = addTwoNumbers(listNode1, listNode2);
//        ListNode[] listNodes = ListUtil.moveNode(listNode1, listNode2);
//        System.out.println(ArrayUtils.toString(listNodes));
//        System.out.println(ListUtil.shuffleMerge(listNode1,listNode2));
        //3
//        delelteNode(listNode1);
        //4
//        System.out.println(ListUtil.sortedMerge(listNode1,listNode2));
//        List<ListNode> listNodes = ListUtil.divide(listNode1, one, two);
//        System.out.println(listNodes);
//        System.out.println(ListUtil.reverse(listNode1));
//        System.out.println(ListUtil.addTwoNumbers(listNode1, listNode2));
//        ListNode listNode = reverseBetween(listNode1, 1, 4);
//        System.out.println(listNode);
    }

    /**
     * 1367. Linked List in Binary Tree
     *
     * @param head 头
     * @param root 根
     * @return boolean
     */
    public boolean isSubPath(ListNode head, TreeNode root) {
        List<Boolean> result = new ArrayList();
        return result.contains(true);

    }

    private void match(ListNode head, TreeNode root, List result) {
        if (root == null) {
            result.add(false);
            return;
        }
        if (head == null) {
            result.add(true);
            return;
        }
        if (root.e.equals(head.e)) {
            head = head.next;
        }

        match(head, root.left, result);
        match(head, root.right, result);
    }

    /**
     * Reverse a singly linked list.
     * <p>
     * Example:
     * <p>
     * Input: 1->2->3->4->5->NULL
     * Output: 5->4->3->2->1->NULL
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode<Integer> head) {
        ListNode pre = null;
        ListNode<Integer> cur = head;
        while (cur != null) {
            ListNode<Integer> next = cur.next;
            if (next != null && next.e == 10) {
                cur.e++;
                next.e = 0;
            }
            cur.next = pre;
            pre = cur;
            cur = next;

        }
        return pre;
    }

    /**
     * Given 1->2->3->4, you should return the list as 2->1->4->3.
     *
     * @param head
     * @return
     */
    private static ListNode swapPairs(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        int count = 1;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                return cur;
            }
            ListNode next_next = next.next;
            if (next_next == null) {
                return cur;
            }
            cur.next = next_next;
            pre = next;
            pre.next = cur;
            cur = pre;
        }
        return pre;
    }

    /**
     * 判断链表是否有环
     *
     * @param head
     * @return
     */
//    public static boolean hasCycle(ListNode head) {
//        if (head == null||head.next == null) return false;
//        if (head.next == head) return true;
//        Map<ListNode, Integer> listNodes = new HashMap<>();
//        Boolean hasCycle = false;
//        while (null != head) {
//            if (listNodes.containsKey(head)) {
//                hasCycle = true;
//                break;
//            } else {
//                listNodes.put(head, null);
//            }
//            head = head.next;
//        }
//        return hasCycle;
//    }
    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 2
     * You are given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order and each of their nodes contain a single digit.
     * Add the two numbers and return it as a linked list.
     * <p>
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     * <p>
     * Example:
     * <p>
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            int sum = ((l2 == null) ? 0 : l2.e) + ((l1 == null) ? 0 : l1.e) + carry;
            cur.e = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = cur;

            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return head.next;
    }

    /**
     * 148. Sort List
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode<Integer> head) {

        List<Integer> list = new ArrayList();
        while (head != null) {
            list.add(head.e);
            head = head.next;
        }
        Collections.sort(list);
        ListNode pre = new ListNode(-1);
        ListNode resl = pre;
        for (Integer i : list) {
            pre.next = new ListNode(i);
            pre = pre.next;
        }
        return resl.next;
    }

    /**
     * 203
     * Remove all elements from a linked list of integers that have value val.
     * <p>
     * Example:
     * <p>
     * Input:  1->2->6->3->4->5->6, val = 6
     * Output: 1->2->3->4->5
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode<Integer> head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode<Integer> pre = dummyHead;
        while (pre.next != null) {
            if (pre.next.e == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return dummyHead.next;
    }

    /**
     * @param head
     * @param val
     * @return
     * @see org.javacore.leetCode.linkedlist.LinkedListSolution#removeElements
     */
    public static ListNode removeElementsRecurSion(ListNode<Integer> head, int val, int depth) {
        String depthString = getDepthString(depth);
        System.out.print(depthString);
        System.out.println("call:remove " + val + " in " + head);
        if (head == null) {
            System.out.print(depthString);
            System.out.println("return: " + head);
            return null;
        }
        ListNode rest = removeElementsRecurSion(head.next, val, depth + 1);
        System.out.print(depthString);
        System.out.println("after:remove " + rest);
        ListNode restult;
        if (head.e == val) {
            restult = rest;
        } else {
            head.next = rest;
            restult = head;
        }
        System.out.print(depthString);
        System.out.println("return:  " + restult);
        return restult;
    }

    private static String getDepthString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public static ListNode<Integer> reverseBetween(ListNode<Integer> head, int m, int n) {

        if (head == null || m == n) {
            return head;
        }
        ListNode<Integer> cur = head, pre = null;
        int position = m;
        while (m > 1) {
            pre = cur;
            cur = cur.next;
            m--;
        }
        ListNode listNode = reverseBetween(cur, n - position);
        if (pre != null) {
            pre.next = listNode;
            return head;
        }
        return listNode;
    }

    //
    private static ListNode reverseBetween(ListNode<Integer> head, int n) {
        ListNode<Integer> pre = null, tail = head;
        while (n >= 0) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;

            n--;
        }
        if (head == null) {
            return pre;
        }
        tail.next = head;
        return pre;
    }

//    public static ListNode<Integer> reverseBetween(ListNode<Integer> head, int m, int n) {
//        if (head == null || m == n) return head;
//        ListNode dummy = new ListNode(0);
//        ListNode pre = dummy;
//        dummy.next = head;
//
//        for(int i = 0;i<m-1;i++) pre = pre.next;
//
//        ListNode start = pre.next;
//        for (int i = 0; i < n - m; i++) {
//            ListNode then = start.next;
//            start.next = then.next;
//            then.next = pre.next;
//            pre.next = then;
//        }
//        return dummy.next;
//
//    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        return null;
    }


}

