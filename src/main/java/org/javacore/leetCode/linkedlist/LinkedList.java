package org.javacore.leetCode.linkedlist;

import lombok.ToString;
import org.javacore.leetCode.Solution;

/**
 * 关于链表的18个问题 @see http://cslibrary.stanford.edu/105/LinkedListProblems.pdf
 *
 * @program: java-core-learning-example
 * @description: 自定义链表实现
 * @author: znq
 * @create: 2019-10-27 13:41
 **/
public class LinkedList<E> {

    @ToString
    private class Node<E> {

        public E e;

        public Node<E> next;

        Node() {
            this(null, null);
        }

        Node(E e) {
            this(e, null);
        }

        Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
    }

    private Node<E> dummyHead;

    private int size;

    public LinkedList(Node head) {
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
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = new Node(e, pre.next);
        size++;

    }

    public void addLast(E e) {
        this.add(size, e);
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("get faild");
        }
        Node cur = dummyHead.next;
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
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node delNode = pre.next;
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
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public void clear() {
        Node cur = dummyHead.next;
        while (cur != null) {
            Node next = cur.next;
            cur.next = null;
            cur = next;
        }
    }
}
