package com.myproject.algorithm.leetcode.t206s;

import com.myproject.algorithm.leetcode.common.ListNode;

@Deprecated
public class Solution {

    public static void main(String[] args) {
        ListNode head = ListNode.init();
        ListNode listNode = new Solution().way01(head);
        System.out.println(listNode);
    }

    public ListNode way01(ListNode head) {
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
