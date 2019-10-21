package org.javacore.arithmetic;

import java.util.ArrayList;
import java.util.List;

public class Code_01_Array_To_Stack_Queue {

    public static class ArrayStack<E> {
        private ArrayList<E> arr;

        public ArrayStack(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new ArrayList(initSize);
        }

        public ArrayStack() {
            arr = new ArrayList();
        }

        public E peek() {
            return arr.get(arr.size() - 1);
        }

        public void push(E obj) {

            arr.add(obj);
        }

        public E pop() {

            return arr.remove(arr.size() - 1);
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    /**
     * 数组队列
     */
    public static class ArrayQueue<E> {

        private List<E> list;


        public ArrayQueue(int initSize) {
            list = new ArrayList<>(initSize);
        }

        public ArrayQueue() {
            list = new ArrayList<>();
        }

        public Integer peek() {
            return 1;
        }

        public void enqueue(E e) {
            list.add(e);
        }

        public void getFront() {

        }

        public E dequeue() {
            return null;
        }

        public int getSize() {
            return list.size();
        }

        public int getCapacity() {
            return 0;
        }
    }

    public static void main(String[] args) {

        String isValid = "(]";
        System.out.println(isValid(isValid));
    }

    /**
     * example 20. Valid Parentheses
     */
    public static boolean isValid(String s) {

        if (s == null || s.length() == 0) return false;
        ArrayStack<Character> stack = new ArrayStack();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (c == ')' && pop != '(') {
                    return false;
                }
                if (c == '}' && pop != '{') {
                    return false;
                }
                if (c == ']' && pop != '[') {
                    return false;
                }
            }

        }

        return stack.isEmpty();
    }
}
