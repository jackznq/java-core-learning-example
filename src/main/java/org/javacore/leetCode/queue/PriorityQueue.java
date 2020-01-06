package org.javacore.leetCode.queue;

/**
 * @program: java-core-learning-example
 * @description: 优先队列
 * @author: znq
 * @create: 2019-10-24 07:05
 **/
public class PriorityQueue<E extends Comparable<? super E>> implements Queue<E> {



    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int getCapacity() {
        return 0;
    }
}
