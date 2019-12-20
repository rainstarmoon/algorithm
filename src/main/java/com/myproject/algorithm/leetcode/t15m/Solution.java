package com.myproject.algorithm.leetcode.t15m;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = new Solution().threeSum(nums);
        System.out.println(lists);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        int lastNum = 1;
        for (int i = 0, length = nums.length; i < length; i++) {
            int num = nums[i];
            if (num > 0) {
                break;
            }
            if (lastNum == num) {
                continue;
            }
            lastNum = num;
            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                int sum = num + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    result.add(Arrays.asList(num, nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return result;
    }

}
