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
        swap(arr, lo + (int) (Math.random() * (hi- lo + 1)), lo);
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
                swap(arr,l,h);
            }
        }

        swap(arr,lo,h);
        return l;
    }

    public static void main(String[] args) {
        int arr[] = {15,7,9,4,10,6,12};
        System.out.println(Arrays.toString(arr));
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
