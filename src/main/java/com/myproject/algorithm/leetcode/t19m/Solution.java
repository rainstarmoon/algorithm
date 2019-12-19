package com.myproject.algorithm.leetcode.t19m;

import com.myproject.algorithm.leetcode.common.ListNode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        ListNode listNode = new Solution().removeNthFromEnd(head, 1);
        System.out.println(listNode);

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        int i = 1;
        while (first != null) {
            first = first.next;
            i++;
            if (i >= n + 3) {
                second = second.next;
            }
        }
        second.next = second.next.next;
        return dummy.next;
    }

}
