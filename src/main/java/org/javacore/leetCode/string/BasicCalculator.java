package org.javacore.leetCode.string;

import java.util.Arrays;

/**
 * @Date 18/11/28 上午10:58
 * @Auther znq
 * @ClassName BasicCulator
 * 224
 **/
public class BasicCalculator {

    /**
     * @param s
     * @return
     * @see <a href="https://leetcode.com/problems/basic-calculator/"></a>
     */
    public int calculate(String s) {
        if (s == null)
            return 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (Character.isSpace(c)) {
                continue;
            }

        }
        return 0;

    }

    public static void main(String[] args) {
        String s = "23 t";
        s.trim();
        char[] chars = s.toCharArray();

        System.out.println(Arrays.toString(chars));
    }
}
