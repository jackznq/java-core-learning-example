package org.javacore.sort;

import java.util.Arrays;

/**
 * @Date 18/11/13 下午8:01
 * @Auther znq
 * @ClassName InsertSort
 **/
public class InsertSort {

    public static void main(String[] args) {
        int[] nums = {20, 5, 6, 4, 2, 8};
        System.out.println(Arrays.toString(nums));
        insertSort(nums);
        System.out.println(Arrays.toString(nums));

    }


    public static void insertSort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
                nums[j + 1] = key;
            }
        }
    }
}
