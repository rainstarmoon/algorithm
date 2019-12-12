package com.myproject.algorithm.leetcode.leetcode807;

public class Main {
    public static void main(String[] args) {
        int[][] grid = new int[4][4];
        grid[0] = new int[]{3, 0, 8, 4};
        grid[1] = new int[]{2, 4, 5, 7};
        grid[2] = new int[]{9, 2, 6, 3};
        grid[3] = new int[]{0, 3, 1, 0};
        int i = new Solution().maxIncreaseKeepingSkyline(grid);
        System.out.println(i);
    }

    static class Solution {
        public int maxIncreaseKeepingSkyline(int[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int length = grid.length;
            int width = grid[0].length;
            int[] lengthMaxArr = new int[length];
            int[] widthMaxArr = new int[width];
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    int temp = grid[i][j];
                    if (temp > lengthMaxArr[i]) {
                        lengthMaxArr[i] = temp;
                    }
                    if (temp > widthMaxArr[j]) {
                        widthMaxArr[j] = temp;
                    }
                }
            }

            int[][] newGrid = new int[length][width];

            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    int temp = lengthMaxArr[i];
                    if (widthMaxArr[j] < temp) {
                        temp = widthMaxArr[j];
                    }
                    newGrid[i][j] = temp;
                }
            }

            int result = 0;
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    result += newGrid[i][j] - grid[i][j];
                }
            }
            return result;
        }
    }
}
