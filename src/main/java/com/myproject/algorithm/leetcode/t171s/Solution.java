package com.myproject.algorithm.leetcode.t171s;

public class Solution {

    public int titleToNumber(String s) {
        int result = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            result = result * 26 + chars[i] - 'A' + 1;
        }
        return result;
    }

}
