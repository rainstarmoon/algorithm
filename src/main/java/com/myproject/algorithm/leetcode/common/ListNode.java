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


    public static ListNode init() {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        one.next = two;
        two.next = three;
        three.next = four;

        System.out.println(one);
        return one;
    }

}
