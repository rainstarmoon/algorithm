package com.myproject.algorithm.leetcode.t215m;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    // [7, 5, 6, 4, 2, 1, 3]
    public static void main(String[] args) {
        // 大堆
//        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });

        // 小堆
//        PriorityQueue<Integer> heap = new PriorityQueue<>();

    }

    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }

    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
        }
        while (k > 1) {
            heap.poll();
            k--;
        }
        return heap.poll();
    }

}
