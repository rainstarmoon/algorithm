package com.myproject.algorithm.leetcode.t66s;

import java.util.Arrays;

@Deprecated
public class Solution {

    public static void main(String[] args) {
        int[] ints = new Solution().plusOne(new int[]{9, 9, 9});
        System.out.println(Arrays.toString(ints));
    }

    public int[] plusOne(int[] digits) {
        int n = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (n == 0) {
                break;
            }
            int tmp = digits[i] + n;
            if (tmp >= 10) {
                digits[i] = 0;
            } else {
                digits[i] = tmp;
                n = 0;
            }
        }
        if (n > 0) {
            int[] copy = new int[digits.length + 1];
            copy[0] = 1;
            System.arraycopy(digits, 0, copy, 1, digits.length);
            return copy;
        } else {
            return digits;
        }
    }

}
