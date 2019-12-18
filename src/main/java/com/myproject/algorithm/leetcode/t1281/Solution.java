package com.myproject.algorithm.leetcode.t1281;

/**
 * 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
 * <p>
 * 示例 1：
 * 输入：n = 234
 * 输出：15
 * 解释：
 * 各位数之积 = 2 * 3 * 4 = 24
 * 各位数之和 = 2 + 3 + 4 = 9
 * 结果 = 24 - 9 = 15
 */
@Deprecated
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subtractProductAndSum(234));
    }

    public int subtractProductAndSum(int n) {
        return getMulti(n) - getAdd(n);
    }

    public int getMulti(int n) {
        int multi = 1;
        while (true) {
            if (n < 10) {
                multi *= n;
                break;
            }
            int i = n / 10;
            multi *= n - i * 10;
            n = i;
        }
        return multi;
    }

    public int getAdd(int n) {
        int add = 0;
        while (true) {
            int i = n / 10;
            add += n - i * 10;
            if (i < 10) {
                add += i;
                break;
            }
            n = i;
        }
        return add;
    }
}