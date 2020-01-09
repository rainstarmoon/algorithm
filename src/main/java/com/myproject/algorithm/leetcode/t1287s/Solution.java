package com.myproject.algorithm.leetcode.t1287s;

@Deprecated
public class Solution {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 6, 6, 6, 6, 7, 10};
        int specialInteger = new Solution().findSpecialInteger(arr);
        System.out.println(specialInteger);
    }

    public int findSpecialInteger(int[] arr) {
        int length = arr.length;
        int nums = length / 4;
        if (length == 0) {
            return 0;
        }
        int count = 1;
        int lastVal = arr[0];
        for (int i = 1; i < length; i++) {
            if (arr[i] == lastVal) {
                count++;
                if (count > nums) {
                    break;
                }
            } else {
                lastVal = arr[i];
                count = 1;
            }
        }
        return lastVal;
    }

}
