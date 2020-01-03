package com.myproject.algorithm.leetcode.t70s;

@Deprecated
public class Solution {

    public static void main(String[] args) {
        int i = new Solution().climbStairs(3);
        System.out.println(i);
    }

    // 暴力法
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    // 动态规划
//    public int climbStairs(int n) {
//        if (n == 1) {
//            return 1;
//        }
//        if (n == 2) {
//            return 2;
//        }
//        int[] dp = new int[n];
//        dp[0] = 1;
//        dp[1] = 2;
//        for (int i = 3; i <= n; i++) {
//            dp[i - 1] = dp[i - 2] + dp[i - 3];
//        }
//        return dp[n - 1];
//    }

}
