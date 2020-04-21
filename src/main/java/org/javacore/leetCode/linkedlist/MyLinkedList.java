package org.javacore.leetCode.linkedlist;

public class MyLinkedList {

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int e, Node next) {
            this.val = e;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                "val=" + val +
                ", next=" + next +
                '}';
        }
    }

    private Node dummyHead;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        dummyHead = new Node(0);
        size = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index>size-1||index<0) return -1;
        if (dummyHead.next == null) return -1;
        Node cur = dummyHead;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {

        Node pre = dummyHead;
        if (pre.next == null) {
            dummyHead.next = new Node(val, pre.next);
            size++;
            return;
        }

        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = new Node(val, pre.next);
        size++;

    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node delNode = pre.next;
        pre.next = delNode.next;
        delNode.next = null;
        size--;
    }

    public Node getDummyHead() {
        return dummyHead;
    }

}

