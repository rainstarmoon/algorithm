package com.myproject.algorithm.leetcode.t1252;

@Deprecated
public class Solution {

    public int oddCells(int n, int m, int[][] indices) {
        int[][] matrix = new int[n][m];
        for (int i = 0; i < indices.length; i++) {
            int index0 = indices[i][0];
            for (int j = 0; j < m; j++) {
                matrix[index0][j] += 1;
            }
            int index1 = indices[i][1];
            for (int j = 0; j < n; j++) {
                matrix[j][index1] += 1;
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((matrix[i][j] & 1) == 1) {
                    count++;
                }
            }
        }
        return count;
    }

}
