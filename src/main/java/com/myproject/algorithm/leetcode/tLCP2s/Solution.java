package com.myproject.algorithm.leetcode.tLCP2s;

@Deprecated
public class Solution {

    public static void main(String[] args) {
        int[] cont = new int[]{3, 2, 0, 2};
        int[] fraction = new Solution().fraction(cont);
        System.out.println(fraction[0] + " / " + fraction[1]);
    }

    public int[] fraction(int[] cont) {
        int length = cont.length;
        int[] result = new int[]{1, 1};
        if (length == 1) {
            result[0] = cont[0];
        }
        int i = length - 1;
        result[0] = cont[i];
        while (--i >= 0) {
            reverse(result);
            result[0] = cont[i] * result[1] + result[0];
        }
        return result;
    }

    private void reverse(int[] arr) {
        int tmp = arr[0];
        arr[0] = arr[1];
        arr[1] = tmp;
    }

}
