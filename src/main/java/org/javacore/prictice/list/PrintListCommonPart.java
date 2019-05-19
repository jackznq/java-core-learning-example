package org.javacore.prictice.list;

import org.javacore.leetCode.Solution;

/**
 * 打印两个链表的公共部分
 * 出自<程序员代码面试指南>
 *
 * @Date 19/5/19 下午3:59
 * @Auther znq
 * @ClassName PrintListCommonPart
 **/
public class PrintListCommonPart {

    public static void main(String[] args) {

        printListCommonPart(new Solution.ListNode(1), new Solution.ListNode(1));
    }


    private static void printListCommonPart(Solution.ListNode l1, Solution.ListNode l2) {
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

}
