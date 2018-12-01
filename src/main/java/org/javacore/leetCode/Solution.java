package org.javacore.leetCode;

import com.google.common.base.Joiner;
import lombok.Data;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Auther: znq
 * @Date: 18/7/30 22:44
 * @Description:leetCode练习
 */
public class Solution {
    /**
     * String to Integer (atoi)
     *
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        if (Character.isLetter(str.charAt(0)) || str.startsWith(" ") || str.startsWith("''")) {
            return 0;
        }
        str = str.trim();
        if (str.startsWith("-")) {
            String strTemp = str.substring(1, str.length());
            if (isdigit(strTemp)) {
                BigInteger integer = new BigInteger(strTemp);
                if (integer.compareTo(new BigInteger("2147483648")) > 0) {
                    return -2147483648;
                } else {
                    return Integer.parseInt("-" + strTemp);
                }
            }
            myAtoi(strTemp);
        } else if (str.startsWith("+")) {
            String strTemp = str.substring(1, str.length());
            if (isdigit(strTemp)) {
                return Integer.parseInt(strTemp);
            }
            myAtoi(strTemp);
        } else {
            String subString;
            for (int i = 1; i < str.length(); i++) {
                if (Character.isLetter(str.charAt(i)) || Character.isWhitespace(str.charAt(i))) {
                    if (i >= 0) {
                        subString = str.substring(0, i);
                        return Integer.parseInt(subString);
                    }
                }
            }

            return Integer.parseInt(str);
        }
        return 0;
    }

    private static boolean isdigit(String str) {
        return str.matches("[0-9]+");
    }


    public static void main(String[] args) {
//        String s = "-91283472332";
////        System.out.println(myAtoi(s));
//        int[] nums = {1, 1, 2, 2, 3, 5, 5, 5, 5, 6};
//        List ints = Arrays.asList(nums);
//        Set set = new HashSet(ints);
//        System.out.println(set.toArray());
//        System.out.println(removeDuplicates(nums));
//        int[] nums = {4, 4, 1, 2, 1, 2, 5};
//        int i = singleNumber(nums);
//        System.out.println(i);
        int nums1[] = {1, 2, 2, 1};
        int nums2[] = {2, 2};
//        System.out.println(Arrays.toString(intersect(nums1,nums2)));
//        String con = "盗抢";
//        String con1 = "43434盗抢1";
//        System.out.println(con1.contains(con));
        String mobiles [] = {"er","er","gf"};
        String join = Joiner.on(",").join(mobiles);
        System.out.println(join);


    }

    public static int removeDuplicates(int[] nums) {
        int count = 1;
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                break;
            }
            if (i != 0) {
                if (nums[i] != nums[i + 1]) {
                    count++;
                } else {
                    nums[i] = nums[i + 1];
                }
            }
        }
        for (int i = 0; i < count; i++) {
            System.out.println(nums[i]);
        }
        return count;
    }

    public static int[] delete(int index, int array[]) {
        //根据删除索引，把数组后面的向前移一位
        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        return array;
    }

    public boolean containsDuplicate(int[] nums) {
        Set set = new HashSet();
        for (int i : nums) {
            if (set.contains(i)) {
                return Boolean.TRUE;
            }
            set.add(i);
        }
        return Boolean.FALSE;
    }

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，
     * 其余每个元素均出现两次。找出那个只出现了一次的元素。
     * 说明：
     * 你的算法应该具有线性时间复杂度，你可以不使用额外空间来实现吗？
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {

        int count = 0;
        int result = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                    index = j;
                    break;
                }
            }
            if (i == 0 && index == 0) {
                return nums[0];
            }
            if (i == index) {
                continue;
            }
            if (i != 0) {

                if (count == 0) {
                    return nums[i];
                }
            }
            count = 0;

        }
        return result;
    }
    //[2,2,1]

    /**
     * 说明：
     * <p>
     * 输出结果中每个元素出现的次数，
     * 应与元素在两个数组中出现的次数一致。
     * 我们可以不考虑输出结果的顺序。
     * 进阶:
     * <p>
     * 如果给定的数组已经排好序呢？你将如何优化你的算法？
     * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
     * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        int size = nums1.length < nums2.length ? nums2.length : nums1.length;
        int result[] = {};
        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int aNums2 : nums2) {
                if (nums1[i] == aNums2) {
                    count++;
                    result[i] = nums1[i];
                }
            }
        }
        return result;
    }


}
