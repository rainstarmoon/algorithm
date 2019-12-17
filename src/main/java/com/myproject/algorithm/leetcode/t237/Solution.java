package com.myproject.algorithm.leetcode.t237;

import com.myproject.algorithm.leetcode.common.ListNode;

@Deprecated
public class Solution {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}

