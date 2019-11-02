package org.javacore.leetCode.recursion;

/**
 * @Date 18/12/22 下午9:49
 * @Auther znq
 * @ClassName Solution
 **/
public class Solution {

    public static void main(String[] args) {

        System.out.println(recursion(6));
        int[] arr ={1,20,9,8};
        System.out.println(arrSum(arr));
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

    private static void divideAndConquer() {

    }

    private static int arrSum(int arr []) {
        return sum(arr, 0);
    }

    private static int sum(int arr [], int l) {
        if (l == arr.length) {
            return 0;
        }
        return arr[l] + sum(arr, l + 1);
    }
}
