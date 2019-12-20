package com.myproject.algorithm.leetcode.t12m;

@Deprecated
public class Solution {

    public static void main(String[] args) {
        String s = new Solution().intToRoman(3);
        System.out.println(s);
    }

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
            while (num >= tmp) {
                sb.append(strs[i]);
                num -= tmp;
            }
        }
        return sb.toString();
    }

}
