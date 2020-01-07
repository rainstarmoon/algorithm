package com.myproject.algorithm.leetcode.t172s;

@Deprecated
public class Solution {

    public static void main(String[] args) {
        int i = new Solution().trailingZeroes(10);
        System.out.println(i);
    }

    public int trailingZeroes(int n) {
        int num = 0;
        while (n > 0) {
            num += n / 5;
            n /= 5;
        }
        return num;
    }

}
