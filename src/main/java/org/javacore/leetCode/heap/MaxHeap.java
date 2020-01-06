package org.javacore.leetCode.heap;

import java.util.ArrayList;

/**
 * @program: java-core-learning-example
 * @description: heap
 * @author: znq
 * @create: 2020-01-06 14:51
 **/
public class MaxHeap<E extends Comparable<E>> {

    private ArrayList arrayList;

    public MaxHeap(int capacity) {
        this.arrayList = new ArrayList<>(capacity);
    }

    public MaxHeap() {
        this.arrayList = new ArrayList();
    }

    public int getSize() {
        return arrayList.size();
    }

    public boolean isEmpty() {
        return arrayList.isEmpty();
    }


    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("没有父亲节点");
        }
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2;
    }

    private int rightChild(int index) {
        return index * 2 + 1;
    }
}
