package com.myproject.algorithm.leetcode.t67s;

@Deprecated
public class Solution {

    public static void main(String[] args) {
        String s = new Solution().addBinary(
                "1",
                "111"
        );
        System.out.println(s);
    }

    public String addBinary(String a, String b) {
        char[] charA = a.toCharArray();
        int lengthA = charA.length;
        char[] charB = b.toCharArray();
        int lengthB = charB.length;
        int maxL = Math.max(lengthA, lengthB);
        char[] result = new char[maxL + 1];
        int n = 0;
        int i = lengthA - 1;
        int j = lengthB - 1;
        int k = maxL;
        while (true) {
            if (i >= 0 && j >= 0) {
                if (n == 1) {
                    if (charA[i] == '1' && charB[j] == '1') {
                        result[k] = '1';
                        n = 1;
                    } else if (charA[i] == '0' && charB[j] == '0') {
                        result[k] = '1';
                        n = 0;
                    } else {
                        result[k] = '0';
                        n = 1;
                    }
                } else {
                    if (charA[i] == '1' && charB[j] == '1') {
                        result[k] = '0';
                        n = 1;
                    } else if (charA[i] == '0' && charB[j] == '0') {
                        result[k] = '0';
                        n = 0;
                    } else {
                        result[k] = '1';
                        n = 0;
                    }
                }
            } else if (i >= 0) {
                if (n == 1) {
                    if (charA[i] == '1') {
                        result[k] = '0';
                        n = 1;
                    } else {
                        result[k] = '1';
                        n = 0;
                    }
                } else {
                    if (charA[i] == '1') {
                        result[k] = '1';
                        n = 0;
                    } else {
                        result[k] = '0';
                        n = 0;
                    }
                }
            } else if (j >= 0) {
                if (n == 1) {
                    if (charB[j] == '1') {
                        result[k] = '0';
                        n = 1;
                    } else {
                        result[k] = '1';
                        n = 0;
                    }
                } else {
                    if (charB[j] == '1') {
                        result[k] = '1';
                        n = 0;
                    } else {
                        result[k] = '0';
                        n = 0;
                    }
                }
            } else {
                break;
            }
            i--;
            j--;
            k--;
        }
        if (n > 0) {
            result[0] = '1';
            return new String(result);
        } else {
            return new String(result).substring(1);
        }
    }

}
