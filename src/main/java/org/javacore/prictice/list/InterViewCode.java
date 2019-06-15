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
//        removeLastKthNode(one, 2);
//        revertList(one);
        ListNode head1 = new ListNode(10);
        head1.next = one;
        ListNode head2 = new ListNode(9);
        head2.next = one;
//        printCommonPart(head1, head2);
//        printListCommonPart(head1, head2);
        printListNode(removeLastKthNode(one,3));
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


    /**
     * 反转单向链表
     * 1->2->3->4->5
     *
     * @param head
     */
    public static ListNode revertList(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode pre = null;
        ListNode cur = null;
        while (head != null) {
            cur = head.next;
            head.next = pre;
            pre = head;
            head = cur;
        }

        return pre;
    }

    /**
     * 程序员代码面试指南 打印公共的部分
     *
     * @param one
     * @param two
     */
    public static void printCommonPart(ListNode one, ListNode two) {
        if (one == null || two == null) {
            System.out.println("non common part");
            return;
        }
        System.out.println("print common part");
        while (one != null && two != null) {
            if (one.val == two.val) {
                System.out.println("commont part is " + one.val);
                one = one.next;
                two = two.next;
            } else if (one.val < two.val) {
                two = two.next;
            } else {
                one = one.next;
            }
            System.out.println();
        }
    }


    public static void printListNode(ListNode l) {
        if (l == null) return;
        while (l != null) {
            System.out.println(l.val);
            l = l.next;

        }
    }
}
