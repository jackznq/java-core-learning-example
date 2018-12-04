package org.javacore.leetCode.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Date 18/11/27 下午9:07
 * @Auther znq
 * @ClassName StringSolution
 **/
public class StringSolution {

    public static void main(String[] args) {

        String inout = "(])";
//        boolean valid = isValid(inout);
//        System.out.println(valid);
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    /**
     * Input: "()[]{}"
     * Output: true
     * <p>
     * "(])"
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        if (null == s) return false;
        Map<Character, Character> validCharacter = new HashMap<>();
        validCharacter.put(')', '(');
        validCharacter.put('}', '{');
        validCharacter.put(']', '[');
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack();
        for (int i = 0; i < chars.length; i++) {
            if (validCharacter.containsValue(chars[i])) {
                stack.push(chars[i]);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            if (stack.peek().equals(validCharacter.get(chars[i]))) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 242. Valid Anagram
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;

        }
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);

//        return Arrays.equals(sChar, tChar);
//        org.apache.commons.collections.CollectionUtils.isEqualCollection(getMap(s),getMap(t));
        return getMap(s).equals(getMap(t));
    }

    private static Map<Character, Integer> getMap(String s) {
        Map<Character, Integer> smap = new HashMap();
        char[] chars = s.toCharArray();
        for (Character c : chars) {
            if (smap.containsKey(c)) {
                Integer val = smap.get(c);
                smap.remove(c);
                val++;
                smap.put(c, val);
                continue;
            }
            smap.put(c, 1);
        }
        return smap;
    }
}
