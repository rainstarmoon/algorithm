package com.myproject.algorithm.leetcode.t461;

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
