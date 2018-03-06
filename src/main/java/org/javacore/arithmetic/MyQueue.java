package org.javacore.arithmetic;

import java.util.Stack;

/**
 * 由两个栈组成的队列
 * Created by znq on 2018/2/9.
 */
public class MyQueue {

    private Stack<Integer> one;

    private Stack<Integer> two;

    MyQueue() {
        one = new Stack<>();
        two = new Stack<>();
    }

    public int add(int val) {
        one.push(val);
        return val;
    }

    public int poll() {

        //先逆序pop到two 里面
        if (two.isEmpty()) {
            oneToTwo();
            return two.pop();
        } else {
            throw new RuntimeException("--stack tow 不能有数据--");
        }

    }

    public int peek() {

        return two.peek();
    }
    public int size() {

        return one.size();
    }
    private void oneToTwo() {
        int size = one.size();
        for (int i = 0; i < size; i++) {
            two.push(one.pop());
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.add(3);
        queue.add(4);
        queue.add(1);
        queue.add(2);
        for (int i=0;i<queue.size();i++){
            System.out.println(queue.poll());
        }

        System.out.println(queue.size());
    }
}
