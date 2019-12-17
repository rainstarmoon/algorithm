package com.myproject.algorithm.leetcode.t3;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
@Deprecated
public class Solution {

    public static void main(String[] args) {
        int length = new Solution().lengthOfLongestSubstring(" ");
        System.out.println(length);
    }

    public int lengthOfLongestSubstring(String s) {
        int beginIndex = 0;
        int endIndex = 0;
        int longest = 0;
        StringBuilder builder = new StringBuilder(s);
        int length = s.length();
        while (endIndex < length) {
            char endChar = builder.charAt(endIndex);
            CharSequence charSequence = builder.subSequence(beginIndex, endIndex);
            for (int i = 0; i < charSequence.length(); i++) {
                char tmpChar = charSequence.charAt(i);
                if (endChar == tmpChar) {
                    beginIndex = i + beginIndex + 1;
                    break;
                }
            }
            longest = (endIndex - beginIndex + 1 > longest) ? endIndex - beginIndex + 1 : longest;
            endIndex++;
        }
        return longest;
    }

}
