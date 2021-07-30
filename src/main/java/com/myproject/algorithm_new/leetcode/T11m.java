package com.myproject.algorithm_new.leetcode;

/**
 * @author 夏泽宇
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 */

// 这个双指针的思路，还是没有太懂

public class T11m {

    public static void main(String[] args) {
        int[] array = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int i = new T11m().maxArea(array);
        System.out.println(i);
    }

    public int maxArea(int[] height) {
        int begin = 0;
        int end = height.length - 1;
        int result = 0;
        while (begin != end) {
            int hb = height[begin];
            int he = height[end];
            result = Math.max(result, Math.min(hb, he) * (end - begin));
            if (hb < he) {
                begin++;
            } else {
                end--;
            }
        }
        return result;
    }

}
