package org.javacore.leetCode.linkedlist;

import org.javacore.leetCode.Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date 18/11/26 下午9:55
 * @Auther znq
 * @ClassName LinkedListSolution
 **/
public class LinkedListSolution {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        swapPairs(node1);
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
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
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
        int count =1;
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
    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;
        if (head.next == null) return false;
        if (head.next == head) return true;
        Map<ListNode, Integer> listNodes = new HashMap<>();
        Boolean hasCycle = false;
        while (null != head) {
            if (listNodes.containsKey(head)) {
                hasCycle = true;
                break;
            } else {
                listNodes.put(head, null);
            }
            head = head.next;
        }
        return hasCycle;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}

