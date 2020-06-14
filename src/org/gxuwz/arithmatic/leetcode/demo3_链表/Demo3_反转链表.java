package org.gxuwz.arithmatic.leetcode.demo3_链表;

/*
反转链表
反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class Demo3_反转链表 {

    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

//    // 保存当前后置
//    ListNode temp = curr.next;
//    // 当前后置 = 前一个
//    curr.next = pre;
//    // 前一个指向当前
//    pre = curr;
//    // 后移
//    curr = temp;
}
