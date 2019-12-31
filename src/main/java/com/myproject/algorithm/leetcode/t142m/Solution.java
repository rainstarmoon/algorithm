package com.myproject.algorithm.leetcode.t142m;

import com.myproject.algorithm.leetcode.common.ListNode;

public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;

        ListNode listNode = new Solution().detectCycle(head);
        System.out.println(listNode.val);
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode intersect = getIntersect(head);
        if (intersect == null) {
            return null;
        }
        ListNode ptr1 = head;
        ListNode ptr2 = intersect;
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
    }

    private ListNode getIntersect(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow.next != null && fast.next != null && fast.next.next != null) {
            if (slow.next == fast.next.next) {
                return slow.next;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;
    }

}
