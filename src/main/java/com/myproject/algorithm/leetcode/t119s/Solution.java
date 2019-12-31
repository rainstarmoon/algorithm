package com.myproject.algorithm.leetcode.t119s;

import java.util.ArrayList;
import java.util.List;

@Deprecated
public class Solution {

    public static void main(String[] args) {
        List<Integer> row = new Solution().getRow(0);
        System.out.println(row);
    }

    public List<Integer> getRow(int rowIndex) {
        int length = rowIndex + 1;
        List<Integer> result = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            result.add(1);
            if (i >= 2) {
                for (int j = i - 1; j > 0; j--) {
                    result.set(j, result.get(j) + result.get(j - 1));
                }
            }
        }
        return result;
    }

}
