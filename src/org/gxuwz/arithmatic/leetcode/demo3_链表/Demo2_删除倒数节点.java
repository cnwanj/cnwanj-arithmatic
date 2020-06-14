package org.gxuwz.arithmatic.leetcode.demo3_链表;
/*
删除链表的倒数第N个节点
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？
 */
public class Demo2_删除倒数节点 {

    public static void main(String[] args) {
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode listNode = new ListNode(0);
        listNode.next = head;
        int len = 0;
        ListNode node = head;
        while (node != null) {
            len ++;
            node = node.next;
        }
        node = listNode;
        for (int i = 0; i < len - n; i++) {
            node = node.next;
        }
        node.next = node.next.next;
        return listNode.next;
    }
}
