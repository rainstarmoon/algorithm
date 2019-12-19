package com.myproject.algorithm.leetcode.t7s;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * <p>
 * 示例 2:
 * 输入: 1534236469
 * 输出: 0
 */
public class Solution {

    public static void main(String[] args) {
        int reverse = new Solution().reverse(1534236469);
        System.out.println(reverse);
    }

    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int i = x % 10;
            x = x / 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && i > 7)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && i < -8)) {
                return 0;
            }
            result = result * 10 + i;
        }
        return result;
    }

}
