package org.javacore.leetCode.slidewindow;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: java-core-learning-example
 * @description: SlideWindow
 * @author: znq
 * @create: 2020-05-18 21:54
 **/
public class SlideWindow {

    public static void main(String[] args) {
        int abcabcbb = lengthOfLongestSubstring("abcabcbb");
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        int n = s.length();
        Set<Character> set = new HashSet();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
