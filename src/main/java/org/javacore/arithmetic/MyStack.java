package org.javacore.arithmetic;

import java.util.Stack;

/**
 * 设计一个有getMin功能的栈
 * Created by znq on 2018/2/9.
 */
public class MyStack {

    private Stack<Integer> stackData;

    private Stack<Integer> stackMin;

    private MyStack() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public int pop() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        int value = stackData.pop();
        if (value == getMin()) {
            stackMin.pop();
        }
        return value;
    }

    public void push(Integer value) {
        if (stackMin.isEmpty()) {
            stackMin.push(value);
        } else if (value <= getMin()) {
            stackMin.push(value);
        }
        stackData.push(value);
    }

    public int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is empty");
        }
        return this.stackMin.peek();
    }

    public Stack<Integer> getStackData() {
        return stackData;
    }

    public Stack<Integer> getStackMin() {
        return stackMin;
    }

    public int size() {
        return stackMin.size();
    }

    public static void main(String[] args) {
        MyStack stack1 = new MyStack();
        stack1.push(3);
        System.out.println(stack1.getMin());
        stack1.push(4);
        System.out.println(stack1.getMin());
        stack1.push(1);
        stack1.push(1);
        System.out.println("pop 前栈大小"+stack1.size());
        System.out.println(stack1.getMin());
        System.out.println(stack1.getStackMin().peek());

        System.out.println(stack1.pop());
        System.out.println("pop 后栈大小"+stack1.size());
        for (int s :
            stack1.getStackMin()) {
            System.out.println(s);
        }
        System.out.println("=============");
    }
}
