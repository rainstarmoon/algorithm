package com.myproject.algorithm.leetcode.t1290s;

import com.myproject.algorithm.leetcode.common.ListNode;

public class Solution {

    public int getDecimalValue(ListNode head) {
        ListNode tmp = head;
        int ans = 0;
        while (tmp != null) {
            ans = ans * 2 + tmp.val;
            tmp = tmp.next;
        }
        return ans;
    }

}
