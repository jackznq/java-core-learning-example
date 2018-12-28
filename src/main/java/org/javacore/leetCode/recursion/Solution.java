package org.javacore.leetCode.recursion;

/**
 * @Date 18/12/22 下午9:49
 * @Auther znq
 * @ClassName Solution
 **/
public class Solution {

    public static void main(String[] args) {

        System.out.println(recursion(6));
    }

    /**
     * @param n
     */
    private static int recursion(int n) {

        if (n <= 1) return 1;
        return n * recursion(n - 1);
    }

    /**
     * 斐波数列
     *
     * @param n
     * @return
     */
    private static int fabonacii(int n) {
        if (n == 0 || n == 1) return n;
        return fabonacii(n - 1) + fabonacii(n - 2);
    }

    private static void divideAndConquer(){

    }
}
