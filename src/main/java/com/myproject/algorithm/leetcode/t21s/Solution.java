package com.myproject.algorithm.leetcode.t21s;

import com.myproject.algorithm.leetcode.common.ListNode;

@Deprecated
public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode current = result;
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        while (true) {
            if (tmp1 == null && tmp2 == null) {
                break;
            }
            if (tmp1 == null) {
                current.next = tmp2;
                break;
            }
            if (tmp2 == null) {
                current.next = tmp1;
                break;
            }
            int val1 = tmp1.val;
            int val2 = tmp2.val;
            if (val1 > val2) {
                current.next = tmp2;
                tmp2 = tmp2.next;
                current = current.next;
            } else if (val1 < val2) {
                current.next = tmp1;
                tmp1 = tmp1.next;
                current = current.next;
            } else {
                current.next = tmp1;
                tmp1 = tmp1.next;
                current = current.next;

                current.next = tmp2;
                tmp2 = tmp2.next;
                current = current.next;

            }
        }
        return result.next;
    }

}
