package org.javacore.prictice.list;

import lombok.Getter;

/**
 * 出自<程序员代码面试指南>
 *
 * @Date 19/5/19 下午3:59
 * @Auther znq
 * @ClassName InterViewCode
 **/
public class InterViewCode {

    public static void main(String[] args) {

//        printListCommonPart(new ListNode(1), new ListNode(1));
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        removeLastKthNode(one, 2);
        System.out.println();
    }


    /**
     * @param * @param null
     * @author znq
     * @description //打印两个链表的公共部分
     * @date 下午4:12 19/5/19
     * @Return
     */
    private static void printListCommonPart(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return;
        }
        while (l1 != null && l2 != null) {
            if (l1.val == l2.val) {
                System.out.println(l1.val);
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1.val < l2.val) {
                l1 = l1.next;
            } else {

                l2 = l2.next;
            }
        }
    }

    /**
     * 在单链表和双链表中删除倒数第K个节点
     * 要求:时间复杂度O(n)，空间复杂度O(1)
     *
     * @param head
     */
    public static ListNode removeLastKthNode(ListNode head, int k) {

        if (head == null || k < 1) {
            return head;
        }
        ListNode pre = head;
        while (pre != null) {
            pre = pre.next;
            k--;
        }

        if (k == 0) {
            head = head.next;
        }
        if (k < 0) {
            pre = head;
            while (++k != 0) {
                pre = pre.next;
            }
            pre.next = pre.next.next;
        }
        return head;
    }

    public static class ListNode {
        public int val;
        @Getter
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "当前节点的值为" + val;
        }
    }

}
