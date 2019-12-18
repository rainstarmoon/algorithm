package com.myproject.algorithm.leetcode.t1221;

/**
 * 在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
 * 给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
 * 返回可以通过分割得到的平衡字符串的最大数量。
 * <p>
 * 示例 1：
 * 输入：s = "RLRRLLRLRL"
 * 输出：4
 * 解释：s 可以分割为 "RL", "RRLL", "RL", "RL", 每个子字符串中都包含相同数量的 'L' 和 'R'。
 */
@Deprecated
public class Solution {

    public int balancedStringSplit(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int tmp = 0;
        int num = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'L') {
                tmp--;
            } else {
                tmp++;
            }
            if (tmp == 0) {
                num++;
            }
        }
        return num;
    }

}
