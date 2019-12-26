package com.myproject.algorithm.leetcode.t20s;

import java.util.Stack;

@Deprecated
public class Solution {

    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            Character ch = chars[i];
            if ('(' == ch || '[' == ch || '{' == ch) {
                st.push(ch);
            } else if (')' == ch) {
                if (st.isEmpty() || '(' != st.pop()) {
                    return false;
                }
            } else if (']' == ch) {
                if (st.isEmpty() || '[' != st.pop()) {
                    return false;
                }
            } else if ('}' == ch) {
                if (st.isEmpty() || '{' != st.pop()) {
                    return false;
                }
            }
        }
        if (!st.isEmpty()) {
            return false;
        }
        return true;
    }

}
