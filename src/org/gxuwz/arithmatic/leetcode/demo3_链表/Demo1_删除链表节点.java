package org.gxuwz.arithmatic.leetcode.demo3_链表;

public class Demo1_删除链表节点 {

    public static void main(String[] args) {

    }

    public void deleteNode(ListNode node) {
        if (node == null)
            return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        val = x;
    }
}
