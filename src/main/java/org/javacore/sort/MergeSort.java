package org.javacore.sort;

/**
 * 归并排序
 * Created by ddfhznq on 2017/11/13.
 */
public class MergeSort {

    private static int[] temp;

    private static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        temp = new int[arr.length];
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    private static void merge(int[] a, int lo, int mid, int hi) {
        int[] help = new int[hi - lo + 1];
        //三个指针
        int i = lo;
        int p1 = lo;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= hi) {
            temp[i++] = a[p1] <= a[p2] ? a[p1++] : a[p2++];
        }

        while (p1 <= mid) {
            temp[i++] = a[p1++];
        }

        while (p2 <= hi) {
            temp[i++] = a[p2++];
        }

        for (int j = lo; j <= hi; j++) {
            a[j] = temp[j];
        }
    }

    // 打印完整序列
    private static void printAll(int[] list) {
        for (int value : list) {
            System.out.print(value + "\t");

        }
        System.out.println();

    }

    public static void main(String[] args) {
        int arr[] = {7, 14, 57, 28, 38, -1, 3, -16, 28, -48, 15, -34, -42, -63, -53, 41, -35,
            5, -41, 28, -75, 2, -25, -41, -7, -31, -24, -15, 2, 1, 40, 1, -76, 9, -5, 4, -11,
            28, -83, -38, -51, 18, 53, 15, -5, 14, -59, -25, -83, -50, -9, 53, 13, -58, 46, -18,
            -76, 27, 68, -36, -73, 50, 44, -6, 34, 16, -18, 4, -57, -18, 22, 95, 10, -14, -59, -30,
            32, -66, -44, 42, 78, 18};
        printAll(arr);
        mergeSort(arr);
        printAll(arr);

    }

}
