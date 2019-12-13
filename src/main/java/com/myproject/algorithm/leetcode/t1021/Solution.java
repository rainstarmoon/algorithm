package com.myproject.algorithm.leetcode.t1021;

@Deprecated
public class Solution {

    public static void main(String[] args) {
        String s = new Solution().removeOuterParentheses("()()");
        System.out.println(s);
    }

    public String removeOuterParentheses(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        int count = 0;
        boolean isRoot = true;
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (isRoot) {
                isRoot = false;
                continue;
            }
            char c = chars[i];
            if (')' == c && count == 0) {
                isRoot = true;
                continue;
            }
            if (c == '(') {
                count++;
            } else {
                count--;
            }
            builder.append(c);
        }
        return builder.toString();
    }

}
