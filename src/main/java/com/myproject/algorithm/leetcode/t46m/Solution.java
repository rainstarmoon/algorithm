package com.myproject.algorithm.leetcode.t46m;

import java.util.*;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */

/**
 * 全排列
 * 也比较复杂
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> permute = new Solution().permute2(nums);
        System.out.println(permute);
    }


    public List<List<Integer>> permute2(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        return (List) arr(numSet);
    }

    public List<List<Integer>> permute(int[] nums) {
        return (List) arr(nums, 0, nums.length - 1);
    }

    public List<LinkedList<Integer>> arr(int[] nums, int start, int end) {
        List<LinkedList<Integer>> result = new ArrayList<>();
        if (start == end) {
            LinkedList<Integer> tmpList = new LinkedList<>();
            tmpList.add(nums[start]);
            result.add(tmpList);
        }
        for (int i = start; i <= end; i++) {
            swap(nums, i, start);
            List<LinkedList<Integer>> arrs = arr(nums, start + 1, end);
            for (LinkedList<Integer> arr : arrs) {
                arr.addFirst(nums[start]);
                result.add(arr);
            }
            swap(nums, i, start);
        }
        return result;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public List<LinkedList<Integer>> arr(Set<Integer> nums) {
        List<LinkedList<Integer>> result = new ArrayList<>();
        for (Integer num : nums) {
            HashSet<Integer> tmpSet = new HashSet<>(nums);
            tmpSet.remove(num);
            List<LinkedList<Integer>> arrs = arr(tmpSet);
            if (arrs.isEmpty()) {
                LinkedList<Integer> tmpList = new LinkedList<>();
                tmpList.add(num);
                result.add(tmpList);
            } else {
                for (LinkedList<Integer> arr : arrs) {
                    arr.addFirst(num);
                    result.add(arr);
                }
            }
        }
        return result;
    }

}
