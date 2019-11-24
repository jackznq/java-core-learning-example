package org.javacore.leetCode.linkedlist;

/**
 * 关于链表的18个问题 @see http://cslibrary.stanford.edu/105/LinkedListProblems.pdf
 *
 * @program: java-core-learning-example
 * @description: list utils
 * @author: znq
 * @create: 2019-11-22 22:40
 **/
public class ListUtil {

    /**
     * 有序的链表中插入一个元素
     *
     * @param listNode
     * @param e
     * @param <E>
     */
    public static <E extends Comparable<? super E>> ListNode sortedInsert(ListNode listNode, E e) {
        sorted(listNode);
        if (listNode.next.e.compareTo(e) > 0) {
            ListNode head = new ListNode(e);
            head.next = listNode;
            return head;
        }
        ListNode cur = listNode;
        ListNode pre = listNode;
        while (cur != null) {
            if (cur.e.compareTo(e) > 0) {
                ListNode next = pre.next;
                ListNode newNode = new ListNode(e);
                pre.next = newNode;
                newNode.next = next;
                break;
            }
            if (cur.next == null) {
                ListNode newNode = new ListNode(e);
                cur.next = newNode;
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        return listNode;
    }

    /**
     * 链表排序
     *
     * @param head
     * @param <E>
     */
    public static <E extends Comparable<? super E>> void sorted(ListNode head) {
        if (head == null) return;
        ListNode<E> cur = head;
        E temp;
        while (cur != null) {
            ListNode<E> next = cur.next;
            while (next != null) {
                if (next.e.compareTo(cur.e) < 0) {
                    temp = next.e;
                    next.e = cur.e;
                    cur.e = temp;
                }
                next = next.next;
            }
            cur = cur.next;
        }
    }

    public static ListNode append(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode cur = l1;
        while (cur != null) {
            if (cur.next == null) {
                break;
            }
            cur = cur.next;
        }
        cur.next = l2;
        return l1;
    }


    /**
     * @param sou
     * @param des
     */
    public static void moveNode(ListNode des, ListNode sou) {
        des=null;
        sou=null;
    }

    /**
     * 13
     * @param listNode1
     * @param listNode2
     * @return
     */
    public static ListNode shuffleMerge(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null) return listNode2;
        if (listNode2 == null) return listNode1;
        ListNode cur1 = listNode1;
        ListNode cur2 = listNode2;
        ListNode dummyHead = new ListNode(-1);
        ListNode resultCur = dummyHead;
        while (cur1 != null || cur2 != null) {

            if (cur1 != null) {
                resultCur.next = new ListNode(cur1.e);
                resultCur = resultCur.next;
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                resultCur.next = new ListNode(cur2.e);
                resultCur = resultCur.next;
                cur2 = cur2.next;
            }
        }
        return dummyHead.next;
    }
}
