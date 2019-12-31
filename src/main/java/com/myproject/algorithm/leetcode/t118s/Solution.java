package com.myproject.algorithm.leetcode.t118s;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Deprecated
public class Solution {

    public static void main(String[] args) {
        List<List<Integer>> generate = new Solution().generate(5);
        for (List<Integer> list : generate) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        generate(result, 1, numRows);
        return result;
    }

    private void generate(List<List<Integer>> result, int nowRows, int targetRows) {
        if (nowRows > targetRows) {
            return;
        }
        if (nowRows == 1) {
            result.add(Collections.singletonList(1));
        } else if (nowRows == 2) {
            result.add(Arrays.asList(1, 1));
        } else {
            List<Integer> tmp = new ArrayList<>(nowRows);
            tmp.add(1);
            List<Integer> lastTmp = result.get(nowRows - 2);
            for (int i = 1; i < nowRows - 1; i++) {
                tmp.add(lastTmp.get(i - 1) + lastTmp.get(i));
            }
            tmp.add(1);
            result.add(tmp);
        }
        generate(result, nowRows + 1, targetRows);
    }

}
