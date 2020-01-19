package org.javacore.leetCode.tree;

/**
 * @program: java-core-learning-example
 * @description: 线段树
 * @author: znq
 * @create: 2020-01-16 14:17
 **/
public class SegmentTree<E> {


    private E[] data;
    private E[] tree;
    private Merger<E> merger;

    public SegmentTree(E[] data, Merger<E> merger) {
        this.data = data;
        this.tree = (E[]) new Object[4 * data.length];
        this.merger = merger;
        buildSegmentTree(0, 0, data.length - 1);
    }

    public E get(int index) {
        return data[index];
    }

    public int getLength() {
        return data.length;
    }


    private void buildSegmentTree(int index, int left, int right) {
        if (left == right) {
            data[index] = data[left];
            return;
        }
        int leftChild = leftChild(index);
        int rightChild = rightChild(index);
        int mid = (left + right) / 2;
        buildSegmentTree(leftChild, left, mid);
        buildSegmentTree(rightChild, mid + 1, right);
        tree[index] = merger.merge(tree[leftChild], tree[rightChild]);
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    interface Merger<E> {
        E merge(E a, E b);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                sb.append(tree[i]);
            } else {
                sb.append("null");
            }
            if (i != tree.length - 1) {

            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Integer arr[] = {-2, 3, 4, 0, 8, 6};
        SegmentTree segmentTree = new SegmentTree(arr, (Merger<Integer>) (a, b) -> a + b);
        System.out.println(segmentTree.toString());

    }
}

