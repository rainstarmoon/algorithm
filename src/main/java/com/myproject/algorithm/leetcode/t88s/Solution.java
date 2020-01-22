package com.myproject.algorithm.leetcode.t88s;

@Deprecated
public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int writeIndex = m + n - 1;
        while ((index1 >= 0) && (index2 >= 0)) {
            nums1[writeIndex--] = nums1[index1] < nums2[index2] ? nums2[index2--] : nums1[index1--];
        }
        if (index2 >= 0) {
            System.arraycopy(nums2, 0, nums1, 0, index2 + 1);
        }
    }


}
