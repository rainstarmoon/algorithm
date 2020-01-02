package com.myproject.algorithm.leetcode.t27s;

public class Solution {

    public int removeElement(int[] nums, int val) {
//        int write = 0;
//        int read = 0;
//        while (read < nums.length) {
//            if (nums[read] != val) {
//                nums[write] = nums[read];
//                write++;
//            }
//            read++;
//        }
//        return write + 1;


        int write = 0;
        int length = nums.length;
        while (write < length) {
            if (nums[write] == val) {
                nums[write] = nums[length - 1];
                length--;
            } else {
                write++;
            }
        }
        return length;
    }

}
