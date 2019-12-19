package com.myproject.algorithm.leetcode.t1021s;

/**
 * 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 * 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
 * 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
 * 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
 * <p>
 * 示例 1：
 * 输入："(()())(())"
 * 输出："()()()"
 * 解释：
 * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 */
@Deprecated
public class Solution {

    public static void main(String[] args) {
        String s = new Solution().removeOuterParentheses("()()");
        System.out.println(s);
    }

    public String removeOuterParentheses(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        int count = 0;
        boolean isRoot = true;
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (isRoot) {
                isRoot = false;
                continue;
            }
            char c = chars[i];
            if (')' == c && count == 0) {
                isRoot = true;
                continue;
            }
            if (c == '(') {
                count++;
            } else {
                count--;
            }
            builder.append(c);
        }
        return builder.toString();
    }

}
