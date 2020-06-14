package org.gxuwz.arithmatic.leetcode.demo3_链表;

import java.util.HashSet;

/*
合并两个有序链表

将两个升序链表合并为一个新的升序链表并返回。

新链表是通过拼接给定的两个链表的所有节点组成的。

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
 */
public class Demo4_合并链表 {

    public static void main(String[] args) {
        HashSet<Integer> l = new HashSet<>();
        l.add(2);
        l.add(1);
        System.out.println(l);
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1 == null)
            curr.next = l2;
        else if (l2 == null)
            curr.next = l1;
        return head.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return null;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
