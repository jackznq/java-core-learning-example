package org.javacore.arithmetic;

import java.util.Arrays;

/**
 * @Date 19/2/13 下午9:21
 * @Auther znq
 * @ClassName HeapSort
 **/
public class HeapSort {

    public static void main(String[] args) {
        int[] array = generateRandomArray(100, 100);
        System.out.println(Arrays.toString(array));
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void heapSort(int arr[]) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }

        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, heapSize, 0);
            swap(arr, 0, --heapSize);
        }
    }

    //构造二叉堆
    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }


    private static void heapify(int[] arr, int heapSize, int index) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            int larger = left + 1 < heapSize
                && arr[left + 1] > arr[left] ? left + 1 : left;
            larger = arr[larger] > arr[heapSize] ? larger : heapSize;
            if (larger == heapSize) {
                break;
            }
            swap(arr, larger, heapSize);
            index = larger;
            left = 2 * index + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }
}
