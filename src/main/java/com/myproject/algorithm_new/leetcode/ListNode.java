package com.myproject.algorithm_new.leetcode;

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

    public static ListNode init(Integer... integerArr) {
        ListNode head = null;
        ListNode current = null;
        for (Integer integer : integerArr) {
            if (current == null) {
                current = new ListNode(integer);
                head = current;
            } else {
                current.next = new ListNode(integer);
                current = current.next;
            }
        }
        System.out.println(head);
        return head;
    }

}
