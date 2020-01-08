package com.myproject.algorithm.leetcode.t1299s;

@Deprecated
public class Solution {

    public int[] replaceElements(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        int lastMax = arr[arr.length - 1];
        arr[arr.length - 1] = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            int tmp = arr[i];
            arr[i] = lastMax;
            lastMax = Math.max(tmp, lastMax);
        }
        return arr;
    }

}
