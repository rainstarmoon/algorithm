package com.myproject.algorithm.util;

import java.util.Arrays;

/**
 * @author 夏泽宇
 */
public class QuickSork {

    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 5, 6, 7, 8, 1, 9};
        new QuickSork().sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public void sort(int[] array, int left, int right) {
        if (left > right) {
            return;
        }
        int base = array[left];
        int begin = left;
        int end = right;
        while (begin < end) {
            while (array[end] >= base && begin < end) {
                end--;
            }
            while (array[begin] <= base && begin < end) {
                begin++;
            }
            if (begin < end) {
                int tmp = array[begin];
                array[begin] = array[end];
                array[end] = tmp;
            }
        }
        array[left] = array[begin];
        array[begin] = base;
        sort(array, left, begin - 1);
        sort(array, begin + 1, right);
    }

}
