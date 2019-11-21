package org.javacore.leetCode.linkedlist;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ListNode {
    public int val;
    @Setter
    @Getter
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int arr[]) {
        if (arr.length == 0 || arr == null) {
            throw new IllegalArgumentException("empty param");
        }
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            sb.append(cur.val);
            if (cur.next != null) {
                sb.append("->");
            }
            cur = cur.next;

        }
        return sb.toString();
    }
}
