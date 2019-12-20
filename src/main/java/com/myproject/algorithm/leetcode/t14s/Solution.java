package com.myproject.algorithm.leetcode.t14s;

@Deprecated
public class Solution {

    public static void main(String[] args) {
        System.out.println("afasdf".indexOf(""));

    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        if (prefix.length() == 0) {
            return "";
        }
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.length() == 0) {
                    return "";
                }
            }
        }
        return prefix;
    }

}
