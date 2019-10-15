package org.javacore.arithmetic;

import java.util.ArrayList;

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

    public static class ArrayQueue {
        private Integer[] arr;
        private Integer size;
        private Integer first;
        private Integer last;

        public ArrayQueue(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            size = 0;
            first = 0;
            last = 0;
        }

        public Integer peek() {
            if (size == 0) {
                return null;
            }
            return arr[first];
        }

        public void push(int obj) {
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            }
            size++;
            arr[last] = obj;
            last = last == arr.length - 1 ? 0 : last + 1;
        }

        public Integer poll() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            }
            size--;
            int tmp = first;
            first = first == arr.length - 1 ? 0 : first + 1;
            return arr[tmp];
        }
    }

    public static void main(String[] args) {

        String isValid = "([)]";
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
