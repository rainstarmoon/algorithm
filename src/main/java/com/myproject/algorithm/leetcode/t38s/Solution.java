package com.myproject.algorithm.leetcode.t38s;

@Deprecated
public class Solution {

    public static void main(String[] args) {
        String s = new Solution().countAndSay(5);
        System.out.println(s);
    }

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        return calc(countAndSay(n - 1));
    }

    private String calc(String description) {
        StringBuilder builder = new StringBuilder();
        char[] chars = description.toCharArray();
        char lastC = chars[0];
        int num = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == lastC) {
                num++;
            } else {
                builder.append(num).append(lastC);
                lastC = chars[i];
                num = 1;
            }
        }
        if (num > 0) {
            builder.append(num).append(lastC);
        }
        return builder.toString();
    }

}
