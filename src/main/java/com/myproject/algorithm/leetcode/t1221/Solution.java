package com.myproject.algorithm.leetcode.t1221;

@Deprecated
public class Solution {

    public int balancedStringSplit(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int tmp = 0;
        int num = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'L') {
                tmp--;
            } else {
                tmp++;
            }
            if (tmp == 0) {
                num++;
            }
        }
        return num;
    }

}
