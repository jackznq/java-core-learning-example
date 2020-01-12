package org.javacore.leetCode.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @program: java-core-learning-example
 * @description: heap
 * @author: znq
 * @create: 2020-01-06 14:51
 **/
public class MaxHeap<E extends Comparable<E>> {

    private ArrayList<E> arrayList;

    public MaxHeap(int capacity) {
        this.arrayList = new ArrayList<>(capacity);
    }

    public MaxHeap() {
        this.arrayList = new ArrayList();
    }

    public MaxHeap(E[] arr) {
        List<E> es = Arrays.asList(arr);
        arrayList.addAll(es);
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
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
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }


    public void add(E e) {

        arrayList.add(e);
        siftUp(arrayList.size() - 1);
    }

    private void siftUp(int i) {
        while (i > 0 &&
            arrayList.get(parent(i)).compareTo(arrayList.get(i)) < 0) {
            swap(parent(i), i);
            i = parent(i);
        }
    }

    public E pop() {
        E peak = peak();
        swap(0, getSize() - 1);
        arrayList.remove(getSize() - 1);
        siftDown(0);
        return peak;
    }

    private void siftDown(int index) {
        while (leftChild(index) < getSize()) {
            int left = leftChild(index);
            if (left + 1 < getSize()) {
                E e1 = arrayList.get(left);
                E e2 = arrayList.get(left + 1);
                left = e1.compareTo(e2) > 0 ? left : left + 1;
            }

            if (arrayList.get(index).compareTo(arrayList.get(left)) > 0) {
                break;
            }
            swap(index, left);
            index = left;
        }

    }

    private void swap(int i, int j) {
        E eI = arrayList.get(i);
        E eJ = arrayList.get(j);
        arrayList.set(j, eI);
        arrayList.set(i, eJ);
    }

    public E peak() {
        if (getSize() == 0) {
            throw new IllegalArgumentException();
        }
        return arrayList.get(0);
    }

    /**
     * 替换元素
     *
     * @param e
     * @return
     */
    public E replace(E e) {
        E peak = peak();
        arrayList.set(0, e);
        siftDown(0);
        return peak;
    }


    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            maxHeap.add(random.nextInt(10000));
        }
        int data[] = new int[100];
        for (int j = 0; j < 100; j++) {
            data[j] = maxHeap.pop();
        }

        for (int z = 1; z < data.length; z++) {
            if (data[z - 1] < data[z]) {
                throw new IllegalArgumentException("exception");
            }

        }
        System.out.println("completed");
    }


}
