package com.myproject.algorithm.leetcode.t167s;

@Deprecated
public class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int begIndex = 0;
        int endIndex = numbers.length - 1;
        while (begIndex < endIndex) {
            int tmp = numbers[begIndex] + numbers[endIndex];
            if (tmp > target) {
                endIndex--;
            } else if (tmp < target) {
                begIndex++;
            } else {
                int[] result = new int[]{begIndex + 1, endIndex + 1};
                return result;
            }
        }
        return null;
    }

}
