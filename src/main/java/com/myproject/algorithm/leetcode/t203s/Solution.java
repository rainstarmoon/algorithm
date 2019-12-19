package com.myproject.algorithm.leetcode.t203s;

import com.myproject.algorithm.leetcode.common.ListNode;

/**
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
@Deprecated
public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode listNode = new Solution().removeElements(null, 1);

    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode tmp = head;
        ListNode next = null;
        while (true) {
            next = tmp.next;
            if (next == null) {
                break;
            }
            if (next.val == val) {
                tmp.next = next.next;
            } else {
                tmp = next;
            }
        }
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }

}

