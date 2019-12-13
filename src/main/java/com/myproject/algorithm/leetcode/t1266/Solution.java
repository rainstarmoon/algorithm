package com.myproject.algorithm.leetcode.t1266;

@Deprecated
public class Solution {

    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int[] point = points[i];
            int x0 = point[0];
            int y0 = point[1];

            point = points[i + 1];
            int x1 = point[0];
            int y1 = point[1];

            int dx = Math.abs(x0 - x1);
            int dy = Math.abs(y0 - y1);

            int max = Math.max(dx, dy);
            ans += max;
        }
        return ans;
    }

}
