package com.myproject.algorithm.leetcode.t136s;

public class Solution {

    public static void main(String[] args) {
        int i = new Solution().singleNumber(new int[]{4, 1, 2, 1, 2});
        System.out.println(i);
    }

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

}
