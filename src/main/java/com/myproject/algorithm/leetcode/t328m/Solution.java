package com.myproject.algorithm.leetcode.t328m;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {

        int[] nums = null;

        int n = nums.length;
        // 转换成包装类型，以便传入 Comparator 对象（此处为 lambda 表达式）
        Integer[] numsArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            numsArr[i] = nums[i];
        }


        Arrays.sort(numsArr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String string1 = o1.toString();
                String string2 = o2.toString();

                return 0;
            }
        });




        //int i = new Solution().waysToChange(100);

    }

    static final int MOD = 1000000007;
    int[] coins = {25, 10, 5, 1};

    public int waysToChange(int n) {
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int c = 0; c < 4; ++c) {
            int coin = coins[c];
            for (int i = coin; i <= n; ++i) {
                f[i] = (f[i] + f[i - coin]) % MOD;
            }
            System.out.println();
        }
        return f[n];
    }


}
