package org.javacore.sort;

import java.util.Arrays;

/**
 * @program: java-core-learning-example
 * @description: 希尔排序
 * @author: znq
 * @create: 2020-05-12 21:42
 **/
public class HillSort {

    public static void sort(int[] a) {
        int h = 1;
        while (h < a.length / 2) {
            h = 2 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < a.length ; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (a[j] < a[j - h]) {
                        int temp = a[j];
                        a[j] = a[j - h];
                        a[j - h] = temp;
                    } else {
                        break;
                    }
                }
            }
            h = h / 2;
        }
    }

    public static void main(String[] args) {
        int arr[] = {7, 14, 57, 28, 38, -1, 3, -16, 28, -48, 15, -34, -42, -63, -53, 41, -35,
            5, -41, 28, -75, 2, -25, -41, -7, -31, -24, -15, 2, 1, 40, 1, -76, 9, -5, 4, -11,
            28, -83, -38, -51, 18, 53, 15, -5, 14, -59, -25, -83, -50, -9, 53, 13, -58, 46, -18,
            -76, 27, 68, -36, -73, 50, 44, -6, 34, 16, -18, 4, -57, -18, 22, 95, 10, -14, -59, -30,
            32, -66, -44, 42, 78, 18};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
