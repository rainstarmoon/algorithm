package com.myproject.algorithm.leetcode.t141s;

import com.myproject.algorithm.leetcode.common.ListNode;

@Deprecated
public class Solution {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            if (slow.next == null || fast.next == null || fast.next.next == null) {
                break;
            }
            if (slow.next == fast.next.next) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

}
