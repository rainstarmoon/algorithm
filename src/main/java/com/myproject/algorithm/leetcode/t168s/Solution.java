package com.myproject.algorithm.leetcode.t168s;

@Deprecated
public class Solution {

    public static void main(String[] args) {
        String s = new Solution().convertToTitle(703);
        System.out.println(s);
    }

    public String convertToTitle(int n) {
        StringBuilder builder = new StringBuilder();
        recursive(n, builder);
        return builder.toString();
    }

    private void recursive(int n, StringBuilder builder) {
        if (n > 26) {
            int tmp = (n - 1) / 26;
            recursive(tmp, builder);
            n = n - tmp * 26;
        }
        builder.append((char) ('A' + n - 1));
    }

}
