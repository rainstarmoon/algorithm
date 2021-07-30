package com.myproject.algorithm_new.leetcode;

/**
 * @author 夏泽宇
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 */
@Deprecated
public class T2m {

    public static void main(String[] args) {
        ListNode l1 = ListNode.init(2, 4, 3);
        ListNode l2 = ListNode.init(5, 6, 4);
        ListNode listNode = new T2m().addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode current = null;
        int tmp = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int val = (val1 + val2 + tmp) % 10;
            tmp = (val1 + val2 + tmp) / 10;
            if (current == null) {
                current = new ListNode(val);
                head = current;
            } else {
                current.next = new ListNode(val);
                current = current.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (tmp > 0) {
            current.next = new ListNode(1);
        }
        return head;
    }

}
