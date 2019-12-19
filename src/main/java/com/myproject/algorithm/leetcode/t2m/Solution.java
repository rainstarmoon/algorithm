package com.myproject.algorithm.leetcode.t2m;

import com.myproject.algorithm.leetcode.common.ListNode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
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
