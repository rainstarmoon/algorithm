package com.myproject.algorithm.leetcode.t807m;

/**
 * 在二维数组grid中，grid[i][j]代表位于某处的建筑物的高度。 我们被允许增加任何数量（不同建筑物的数量可能不同）的建筑物的高度。 高度 0 也被认为是建筑物。
 * 最后，从新数组的所有四个方向（即顶部，底部，左侧和右侧）观看的“天际线”必须与原始数组的天际线相同。 城市的天际线是从远处观看时，由所有建筑物形成的矩形的外部轮廓。 请看下面的例子。
 * 建筑物高度可以增加的最大总和是多少？
 * <p>
 * 例子：
 * 输入： grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
 * 输出： 35
 * 解释：
 * The grid is:
 * [ [3, 0, 8, 4],
 * [2, 4, 5, 7],
 * [9, 2, 6, 3],
 * [0, 3, 1, 0] ]
 * <p>
 * 从数组竖直方向（即顶部，底部）看“天际线”是：[9, 4, 8, 7]
 * 从水平水平方向（即左侧，右侧）看“天际线”是：[8, 7, 9, 3]
 * <p>
 * 在不影响天际线的情况下对建筑物进行增高后，新数组如下：
 * <p>
 * gridNew = [ [8, 4, 8, 7],
 * [7, 4, 7, 7],
 * [9, 4, 8, 7],
 * [3, 3, 3, 3] ]
 */
@Deprecated
public class Solution {

    public static void main(String[] args) {
        int[][] grid = new int[4][4];
        grid[0] = new int[]{3, 0, 8, 4};
        grid[1] = new int[]{2, 4, 5, 7};
        grid[2] = new int[]{9, 2, 6, 3};
        grid[3] = new int[]{0, 3, 1, 0};
        int i = new Solution().maxIncreaseKeepingSkyline(grid);
        System.out.println(i);
    }

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