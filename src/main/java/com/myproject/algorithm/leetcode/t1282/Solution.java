package com.myproject.algorithm.leetcode.t1282;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        int[] groupSizes = new int[]{3, 3, 3, 3, 3, 1, 3};
        List<List<Integer>> lists = new Solution().groupThePeople(groupSizes);
        System.out.println(lists);
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> sizeUsers = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> list = sizeUsers.getOrDefault(groupSizes[i], new ArrayList<>());
            list.add(i);
            sizeUsers.put(groupSizes[i], list);
        }
        for (Map.Entry<Integer, List<Integer>> entry : sizeUsers.entrySet()) {
            Integer key = entry.getKey();
            List<Integer> value = entry.getValue();
            if (value.size() > key) {
                for (int i = 0; i < value.size(); i = i + key) {
                    List<Integer> tmp = value.subList(i, i + key);
                    result.add(tmp);
                }
            } else {
                result.add(value);
            }
        }
        return result;
    }

}
