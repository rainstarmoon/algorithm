package com.myproject.algorithm.leetcode.leetcode1281;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subtractProductAndSum(234));
    }

    static class Solution {
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
}

