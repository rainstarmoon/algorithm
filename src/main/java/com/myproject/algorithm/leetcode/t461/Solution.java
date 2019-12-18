package com.myproject.algorithm.leetcode.t461;

/**
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * <p>
 * 输入: x = 1, y = 4
 * <p>
 * 输出: 2
 * <p>
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *       ↑   ↑
 * <p>
 * 上面的箭头指出了对应二进制位不同的位置。
 */
@Deprecated
public class Solution {

    public int hammingDistance(int x, int y) {
        int dis = x ^ y;
        int count = 0;
        while (dis > 0) {
            if ((dis & 1) == 1) {
                count++;
            }
            dis >>= 1;
        }
        return count;
    }

}
