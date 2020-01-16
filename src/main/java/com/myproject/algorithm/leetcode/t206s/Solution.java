package com.myproject.algorithm.leetcode.t206s;

import com.myproject.algorithm.leetcode.common.ListNode;

public class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
