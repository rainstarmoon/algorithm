package com.myproject.algorithm.leetcode.t2;

import com.myproject.algorithm.leetcode.common.ListNode;

@Deprecated
public class Solution {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        //l1.next = new ListNode(4);
        //l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        //l2.next = new ListNode(6);
        //l2.next.next = new ListNode(4);

        ListNode listNode = new Solution().addTwoNumbers(l1, l2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        int tmp = 0;
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        ListNode tmpNode = dummyHead;
        while (true) {
            if (tmp1 == null && tmp2 == null) {
                break;
            }
            int x = (tmp1 != null) ? tmp1.val : 0;
            int y = (tmp2 != null) ? tmp2.val : 0;
            int i = x + y + tmp;
            tmp = i / 10;
            i = i - tmp * 10;
            tmpNode.next = new ListNode(i);
            tmpNode = tmpNode.next;
            tmp1 = (tmp1 != null) ? tmp1.next : null;
            tmp2 = (tmp2 != null) ? tmp2.next : null;
        }
        if (tmp > 0) {
            tmpNode.next = new ListNode(tmp);
        }
        return dummyHead.next;
    }

}
