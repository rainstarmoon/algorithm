package com.myproject.algorithm.leetcode.t35s;

public class Solution {

    public int searchInsert(int[] nums, int target) {
        int result = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>=target){
                result = i;
                break;
            }
        }
        if(result == -1){
            result = nums.length;
        }
        return result;
    }

}
