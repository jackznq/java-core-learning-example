package org.javacore.prictice;

import java.util.Arrays;

/**
 * 给定一个整数数组，返回两个数字的索引，使它们加起来成为一个特定的目标。
 * <p>
 * 您可能会认为每个输入都只有一个解决方案，而且您可能不会使用相同的元素两次。
 * <p>
 * 例：
 * 给定nums = [2,7,11,15]，目标= 9，
 * <p>
 * 由于nums [ 0 ] + nums [ 1 ] = 2 + 7 = 9，
 * 返回[ 0，1 ]。
 * Created by ddfhznq on 2017/11/20.
 */
public class TwoSum {
    public static void main(String[] args) {
        int nums[] = {2, 7, 11, 15, 14, 17, 16};
        long l = System.nanoTime();
        System.out.println(Arrays.toString(twoSum(nums, 32)));
        long end  = System.nanoTime();
        System.out.println(end-l);

    }

    public static int[] twoSum(int[] nums, int target) {

        int a[] = new int[2];
        //取第二个数字
        int secondNum = 0;
        for (int i = 0; i < nums.length; i++) {
            secondNum = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (secondNum == nums[j]) {
                    a[0] = i;
                    a[1] = j;
                    return a;
                }
            }
        }
        return null;
    }
}
