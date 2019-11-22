package org.javacore.leetCode.linkedlist;


/**
 * 关于链表的18个问题 @see http://cslibrary.stanford.edu/105/LinkedListProblems.pdf
 *
 * @program: java-core-learning-example
 * @description: 自定义链表实现
 * @author: znq
 * @create: 2019-10-27 13:41
 **/
public class LinkedList<E extends Comparable<? super E>> {


    private ListNode<E> dummyHead;

    private int size;

    public LinkedList(ListNode head) {
        this.dummyHead = head;
    }

    public LinkedList() {
        dummyHead = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void add(int index, E e) {
        //check index
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed");
        }
        //找到要插入的前一个节点
        ListNode pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = new ListNode(e, pre.next);
        size++;

    }

    public void addLast(E e) {
        this.add(size, e);
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("get faild");
        }
        ListNode cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return (E) cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("get faild");
        }
        ListNode pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        ListNode delNode = pre.next;
        pre.next = delNode.next;
        delNode.next = null;
        size--;
        return (E) delNode;
    }

    public E removeFirst() {
        return this.remove(0);
    }

    public E removeLast() {
        return this.remove(size - 1);
    }

    public boolean contains(E e) {
        ListNode cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public void clear() {
        ListNode cur = dummyHead.next;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
    }

    /**
     * 给一个链表排序
     */
    public void sorted() {
        if (dummyHead == null) return;
        ListNode<E> cur = dummyHead;
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

    @Override
    public String toString() {
        return dummyHead.toString();
    }

    /**
     * @param e
     */
    public void sortedInsert(E e) {
        this.sorted();
        System.out.println(this.toString());
        ListNode cur = dummyHead;
        ListNode pre = dummyHead;
        while (cur != null) {
            if (cur.e.compareTo(e) > 0) {
                ListNode next = pre.next;
                ListNode newNode = new ListNode(e);
                pre.next = newNode;
                newNode.next = next;
                break;
            }
            pre = cur;
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        Integer arr[] = {4, 2, 3, 6, 7};
        ListNode listNode = new ListNode(arr);
        LinkedList linkedList = new LinkedList(listNode);
//        linkedList.sorted();
        linkedList.sortedInsert(3);
        System.out.println(linkedList.toString());
    }
}
