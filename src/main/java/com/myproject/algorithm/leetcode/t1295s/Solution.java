package com.myproject.algorithm.leetcode.t1295s;

@Deprecated
public class Solution {

    public int findNumbers(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int length = Integer.toString(nums[i]).length();
            if (length % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }

}
