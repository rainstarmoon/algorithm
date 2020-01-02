package com.myproject.algorithm.leetcode.t169s;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        int i = new Solution().majorityElement(new int[]{3, 2, 3});
        System.out.println(i);
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> numCounts = new HashMap<>();
        for (int num : nums) {
            numCounts.put(num, numCounts.getOrDefault(num, 0) + 1);
        }
        Map.Entry<Integer, Integer> maxEntry = null;
        for (Map.Entry<Integer, Integer> entry : numCounts.entrySet()) {
            if (maxEntry == null) {
                maxEntry = entry;
            }
            if (entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }
        return maxEntry.getKey();
    }

}
