package com.myproject.algorithm.leetcode.t83s;

import com.myproject.algorithm.leetcode.common.ListNode;

@Deprecated
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode tmp = root;
        Integer lastVal = null;
        while (true) {
            if (tmp.next == null) {
                break;
            }
            if (lastVal != null && lastVal == tmp.next.val) {
                tmp.next = tmp.next.next;
            } else {
                lastVal = tmp.next.val;
                tmp = tmp.next;
            }
        }
        return root.next;
    }

}
