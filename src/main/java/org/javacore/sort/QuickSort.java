package org.javacore.sort;

import java.util.Arrays;

/**
 * @program: java-core-learning-example
 * @description: 快速排序
 * @author: znq
 * @create: 2020-05-13 11:22
 **/
public class QuickSort {

    public static void quickSort(int arr[]) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int p = partition(arr, lo, hi);
        sort(arr, lo, p - 1);
        sort(arr, p + 1, hi);
    }

    private static int partition(int[] arr, int lo, int hi) {
        int l = lo;
        int h = hi + 1;
        int key = arr[lo];
        while (true) {

            while (arr[++l] < key) {
                if (l == hi) {
                    break;
                }
            }
            while (arr[--h] > key) {
                if (h == lo) {
                    break;
                }
            }

            if (l >= h) {
                break;
            } else {
                int temp = arr[l];
                arr[l] = arr[h];
                arr[h] = temp;
            }
        }
        int temp = arr[lo];
        arr[lo] = arr[h];
        arr[h] = temp;
        return l;
    }

    public static void main(String[] args) {
        int arr[] = {7, 14, 57, 28, 38, -1, 3, -16, 28, -48, 15, -34, -42, -63, -53, 41, -35,
            5, -41, 28, -75, 2, -25, -41, -7, -31, -24, -15, 2, 1, 40, 1, -76, 9, -5, 4, -11,
            28, -83, -38, -51, 18, 53, 15, -5, 14, -59, -25, -83, -50, -9, 53, 13, -58, 46, -18,
            -76, 27, 68, -36, -73, 50, 44, -6, 34, 16, -18, 4, -57, -18, 22, 95, 10, -14, -59, -30,
            32, -66, -44, 42, 78, 18};
        System.out.println(Arrays.toString(arr));
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
