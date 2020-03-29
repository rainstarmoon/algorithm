package com.myproject.algorithm.leetcode.t231s;

public class Solution {

    public static void main(String[] args) {
        boolean powerOfTwo = new Solution().isPowerOfTwo2(8);
        System.out.println(powerOfTwo);
    }

    public boolean isPowerOfTwo(int n) {
        // 垃圾算法
        if (n <= 0) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

    public boolean isPowerOfTwo2(int x) {
        if (x <= 0) {
            return false;
        }
        //long x = (long) n;
        return (x & (-x)) == x;
    }

    public boolean isPowerOfTwo3(int x) {
        if (x <= 0) {
            return false;
        }
        //long x = (long) n;
        return (x & (x - 1)) == 0;
    }

}
