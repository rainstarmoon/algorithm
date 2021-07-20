package com.myproject.algorithm.leetcode.tm0105m;

import java.util.TreeSet;

/**
 * @author 夏泽宇
 */
public class Solution {

    // 1,2,2,2,2,3,4,5
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 2, 2, 2, 2, 3, 4, 5};
        TreeSet<Integer> tree = new TreeSet<>();
        way(0, arr.length - 1, arr, tree);
        System.out.println(tree);
    }

    private static void way(int begin, int end, int[] arr, TreeSet<Integer> tree) {
//        System.out.println("begin=" + begin + " beginValue=" + arr[begin]);
//        System.out.println("  end=" + end + "   endValue=" + arr[end]);
//        System.out.println("----------------------------------");
        if (arr[begin] == arr[end]) {
            tree.add(arr[begin]);
        } else {
            int tmp = (begin + end) / 2;
            way(begin, tmp, arr, tree);
            way(tmp + 1, end, arr, tree);
        }
    }

}
