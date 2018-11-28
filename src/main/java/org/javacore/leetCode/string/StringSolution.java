package org.javacore.leetCode.string;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.util.Assert;

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
        boolean valid = isValid(inout);
        System.out.println(valid);
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
}
