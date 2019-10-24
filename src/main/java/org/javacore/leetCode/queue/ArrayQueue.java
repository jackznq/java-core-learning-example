package org.javacore.leetCode.queue;

import org.javacore.thread.oneByOne.A;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: java-core-learning-example
 * @description: 数组队列
 * @author: znq
 * @create: 2019-10-24 07:05
 **/
public class ArrayQueue<E> implements Queue<E> {

    private List<E> list;

    private int front;

    private int tail;

    public ArrayQueue(int capacity) {
        list = new ArrayList(capacity);
        this.front = this.tail = 0;
    }

    public ArrayQueue() {
        list = new ArrayList(10);
        this.front = this.tail = 0;
    }


    @Override
    public boolean add(E e) {
        list.add(e);
        tail++;
        return true;
    }

    @Override
    public E poll() {
        if (front == tail) {
            throw new IllegalStateException("queue is empty");
        }
        E e = list.remove(front);
        front++;
        return e;
    }

    @Override
    public E peek() {
        return list.get(front);
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(10);
        System.out.println(arrayQueue.isEmpty());
        arrayQueue.add(10);
        System.out.println(arrayQueue.poll());
        System.out.println(arrayQueue.size());
        System.out.println(arrayQueue.isEmpty());
        arrayQueue.add(22);
        arrayQueue.add(21);
        arrayQueue.add(5);
        arrayQueue.add(6);
        arrayQueue.add(7);
        arrayQueue.add(7);
        System.out.println(arrayQueue.peek());
        System.out.println(arrayQueue.size());
        System.out.println(arrayQueue.poll());
        System.out.println(arrayQueue.size());
        System.out.println(arrayQueue.isEmpty());

    }
}
