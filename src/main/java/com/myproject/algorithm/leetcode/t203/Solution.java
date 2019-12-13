package com.myproject.algorithm.leetcode.t203;

@Deprecated
public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode listNode = new Solution().removeElements(null, 1);

    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode tmp = head;
        ListNode next = null;
        while (true) {
            next = tmp.next;
            if (next == null) {
                break;
            }
            if (next.val == val) {
                tmp.next = next.next;
            } else {
                tmp = next;
            }
        }
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}

