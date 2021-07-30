package com.myproject.algorithm_new.leetcode;

import java.util.Arrays;

/**
 * @author 夏泽宇
 * 求一个无序数字n第K大的元素
 */
public class Test {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 6, 7, 7, 9, 9, 9, 9, 1, 2, 3, 4};
//        int k = 5;
//        PriorityQueue<Integer> queue = new PriorityQueue<>();
//        for (int i : arr) {
//            queue.add(i);
//            if (queue.size() > k) {
//                queue.poll();
//            }
//        }
//        System.out.println(queue.peek());
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
//        quickSort(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] array, int begin, int end) {
        if (begin > end) {
            return;
        }
        int low = begin;
        int high = end;
        int tmp = array[begin];
        while (low < high) {
            while (tmp <= array[high] && low < high) {
                high--;
            }
            while (tmp >= array[low] && low < high) {
                low++;
            }
            if (low < high) {
                swap(array, low, high);
            }
        }
        swap(array, begin, low);
        sort(array, begin, high - 1);
        sort(array, high + 1, end);
    }

    private static void swap(int[] array, int begin, int end) {
        int tmp = array[end];
        array[end] = array[begin];
        array[begin] = tmp;
    }

    public static void quickSort(int[] array, int begin, int end) {
        if (begin > end) {
            return;
        }
        int low = begin;
        int high = end;
        int tmp = array[begin];
        while (low < high) {
            while (tmp <= array[high] && low < high) {
                high--;
            }
            while (tmp >= array[low] && low < high) {
                low++;
            }
            if (low < high) {
                swap(array, low, high);
            }
        }
        swap(array, begin, low);
        quickSort(array, begin, high - 1);
        quickSort(array, high + 1, end);
    }


}
