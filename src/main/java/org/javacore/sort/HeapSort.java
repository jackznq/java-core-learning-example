package org.javacore.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * 堆排序
 * Created by ddfhznq on 2017/11/8.
 */
public class HeapSort {

    /**
     * 构建大顶堆
     */
    public static void adjustMaxHeap(int[] a, int i, int len) {
        int temp, j;
        temp = a[i];
        for (j = 2 * i; j < len; j *= 2) {// 沿关键字较大的孩子结点向下筛选
            if (j < len && a[j] < a[j + 1])
                ++j; // j为关键字中较大记录的下标
            if (temp >= a[j])
                break;
            a[i] = a[j];
            i = j;
        }
        a[i] = temp;
    }

    /**
     *  堆排序，适合大数据排序，效率高
     * @param a
     */
    public static void heapSort(int[] a) {
        int i;
        for (i = a.length / 2 - 1; i >= 0; i--) {// 构建一个大顶堆
            adjustMaxHeap(a, i, a.length - 1);
        }
        for (i = a.length - 1; i >= 0; i--) {// 将堆顶记录和当前未经排序子序列的最后一个记录交换
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            adjustMaxHeap(a, 0, i - 1);// 将a中前i-1个记录重新调整为大顶堆
        }
    }
    //冒泡排序:适合少量数据排序
    public static int[] bubbleSort(int[] a) {
        int len = a.length;
        for (int i = 0; i <= len - 1; i++) {
            int temp = 0;
            for (int j = 0; j < len - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        return a;
    }

    //快速排序不实现，效率太低，最坏情况为o(n2)
    @SuppressWarnings("unchecked")
    public static void quickSort(){

    }

    /**
     *  选择排序:每趟从待排序的记录序列中选择关键字最小的记录
     *  放置到已排序表的最前位置，直到全部排完。
     */
    @Test
    public  void  selectSort(){
        int a[] = new int[1000000];
        Random random = new Random();
        for (int i = 0; i < 1000000; i++) {
            a[i] = random.nextInt(10000000);
        }
        long start =System.currentTimeMillis();
        for (int i = 0; i < a.length; i++) {
            int min =a[i];//最小数据
            int minIndex=i;//最小数据的索引
            for(int j =i+1;j<a.length;j++){
                if(a[j]<min){
                    min =a[j];
                    minIndex=j;
                }
            }
            a[minIndex]=a[i];
            a[i]=min;
        }

        long end =System.currentTimeMillis();
        System.out.println("耗时 " +(end-start));
        System.out.println(Arrays.toString(a));
        System.out.println(a.length);
    }
    public static void main(String[] args) {
        int a[] = new int[1000000];
        Random random = new Random();
//        for (int i = 0; i < 1000000; i++) {
//            a[i] = random.nextInt(1000000);
//        }
//        System.out.println("排序前: " + Arrays.toString(a));
//        long start = System.currentTimeMillis();
//        bubbleSort(a);
//        long end = System.currentTimeMillis();
//        System.out.println("排序后: " + Arrays.toString(a));
//        System.out.println("时间消耗: " + (end - start));

        for (int i = 0; i < 1000000; i++) {
            a[i] = random.nextInt(1000000);
        }
        System.out.println("排序前: " + Arrays.toString(a));
        long startHeap = System.currentTimeMillis();
        heapSort(a);
        long endHeap = System.currentTimeMillis();
        System.out.println("排序后: " + Arrays.toString(a));
        System.out.println("时间消耗: " + (endHeap - startHeap));
    }
}
