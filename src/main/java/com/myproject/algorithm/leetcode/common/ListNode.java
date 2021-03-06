package com.myproject.algorithm.leetcode.common;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        if (next != null) {
            return val + " -> " + next.toString();
        } else {
            return val + "";
        }
    }
}
