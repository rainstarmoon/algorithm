package com.myproject.algorithm.leetcode.t121s;

@Deprecated
public class Solution {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int result = 0;
        int minValue = prices[0];
        int maxValue = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i];
            if (tmp < minValue) {
                int tmpResult = maxValue - minValue;
                if (tmpResult > result) {
                    result = tmpResult;
                }
                minValue = tmp;
                maxValue = tmp;
            } else if (tmp > maxValue) {
                maxValue = tmp;
            }
        }
        if (maxValue - minValue > result) {
            result = maxValue - minValue;
        }
        return result;
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int maxprofit = 0;
        int minValue = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minValue) {
                minValue = prices[i];
            } else if (prices[i] - minValue > maxprofit) {
                maxprofit = prices[i] - minValue;
            }
        }
        return maxprofit;
    }

}
