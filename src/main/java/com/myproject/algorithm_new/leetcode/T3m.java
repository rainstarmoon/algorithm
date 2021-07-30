package com.myproject.algorithm_new.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 夏泽宇
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
@Deprecated
public class T3m {

    public static void main(String[] args) {
        int abcabcbb = new T3m().lengthOfLongestSubstring("dvdf");
        System.out.println(abcabcbb);
    }

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int tmp = 0;
        int begin = 0;
        for (int end = 0; end < chars.length; end++) {
            char endChar = chars[end];
            if (map.get(endChar) != null && map.get(endChar) >= begin) {
                begin = map.get(endChar) + 1;
            }
            map.put(endChar, end);
            tmp = Math.max(tmp, end - begin + 1);
        }
        return tmp;
    }

}
