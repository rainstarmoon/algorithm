package com.myproject.algorithm.leetcode.t3;

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
