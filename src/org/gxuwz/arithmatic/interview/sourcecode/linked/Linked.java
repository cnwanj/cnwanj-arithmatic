package org.gxuwz.arithmatic.interview.sourcecode.linked;

/**
 * @Author: vovhh
 * @Date: 2020-12-04 20:57:24
 * @Description:
 *
 * 链表：参考LinkedList源码实现链表的添加、删除、修改、查询、获取节点等操作。
 */
public class Linked {

    Node first;
    Node last;
    int size;

    public static void main(String[] args) {
        Linked lin = new Linked();
//        lin.addLast(1);
//        lin.addLast(2);
//        lin.addLast(3);
        lin.addFirst(1);
        lin.addFirst(2);
        lin.addLast(3);
        lin.toPrint();
        System.out.println();
        System.out.println("移除的元素：" + lin.removeLast(lin.last));
        lin.toPrint();
    }

    // 添加头结点
    void addFirst(int n) {
        // 保存头结点
        Node f = first;
        Node node = new Node(n, null, f);
        first = node;
        if (f == null)
            last = node;
        else
            f.prev = node;
        size ++;
    }

    // 添加尾节点
    void addLast(int n) {
        // 保存最后一个节点
        Node l = last;
        // 将该节点的左节点指向last节点
        Node node = new Node(n, l, null);
        // 将该节点设置为最后一个节点
        last = node;
        // 若last节点为空
        if (l == null)
            // 将该节点赋值给first
            first = node;
        else
            // 否则将last的右节点指向该节点
            l.next = node;
        size ++;
    }

    // 移除尾节点
    int removeLast(Node n) {
        // 保存该节点值
        Integer elem = n.n;
        // 保存该节点的左节点
        Node p = n.prev;
        // 释放该节点
        n.n = null;
        n.prev = null;
        // 左节点赋值给尾节点
        last = p;
        // 若左节点为空
        if (p == null)
            // 将头节点设置空
            first = null;
        else
            // 否则将尾节点的右节点设置为空
            last.next = null;
        size --;
        return elem;
    }

    void toPrint() {
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        Node n = first;
        while(true) {
            if (n == null) {
                break;
            }
            System.out.print(n + " ");
            n = n.next;
        }
    }

    private class Node {
        Integer n;
        Node prev;
        Node next;

        public  Node(int n, Node prev, Node next) {
            this.n = n;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return "" + n;
        }
    }
}
