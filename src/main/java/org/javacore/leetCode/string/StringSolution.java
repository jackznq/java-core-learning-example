package org.javacore.leetCode.string;

import java.util.*;

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
//        System.out.println(isAnagram(s, t));
        String[] data = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        groupAnagrams(data);
//        isAnagram(s, t);
        List<String> dict = new ArrayList<>();
        dict.add("cat");
        dict.add("bat");
        dict.add("rat");
//        String s1 = replaceWords(dict, "the cattle was rattled by the battery");
//        System.out.println(s1);
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(topKFrequent(nums, 2).toString());
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

    public int singleNumber(int[] nums) {

        return 0;
    }

    /**
     * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * Output:
     * [
     * ["ate","eat","tea"],
     * ["nat","tan"],
     * ["bat"]
     * ]
     *
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String a : strs) {
            char[] chars = a.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(a);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 648. Replace Words
     *
     * @param dict
     * @param sentence
     * @return
     */
    public static String replaceWords(List<String> dict, String sentence) {

        if (dict.size() == 0) {
            return sentence;
        }
        String[] split = sentence.split(" ");
        for (String s : dict) {
            for (int i = 0; i < split.length; i++) {
                if (split[i].startsWith(s)) {
                    split[i] = split[i].replaceAll(split[i], s);
                }
            }
        }
        return Arrays.toString(split).replace(",", "").replace("[", "").replace("]", "");
    }


    /**
     * 347. Top K Frequent Elements
     * Example 1:
     * <p> Input: nums = [1,1,1,2,2,3], k = 2
     * Output: [1,2]
     * Example 2:
     * <p>
     * Input: nums = [1], k = 1
     * Output: [1]
     *
     * @param nums
     * @param k
     * @return
     */
    public static List<Integer> topKFrequent(int[] nums, int k) {
        if (nums.length == 0) {
            return Collections.EMPTY_LIST;
        }
        List<Integer> res = new ArrayList<>();
        if (nums.length == 1) {
            res.add(nums[0]);
            return res;
        }
        Map<Integer, Integer> map = new TreeMap();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (int count : map.keySet()) {
            heap.add(count);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        List<Integer> top_k = new LinkedList();
        while (!heap.isEmpty())
            top_k.add(heap.poll());
        Collections.reverse(top_k);
        return top_k;
    }


    /**
     * 217. Contains Duplicate
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Set containsDuplicate = new HashSet();
        for (int i : nums) {
            if (containsDuplicate.contains(i)) {
                return true;
            }
            containsDuplicate.add(i);

        }
        return false;
    }
}
