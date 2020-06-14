package org.gxuwz.arithmatic.dataStructures.Demo03_链表;

import java.util.Stack;

/**
 * 单项链表
 */
public class SingleLinkedList {
    // 统计节点个数
    public static int count(Node head) {
        if (head.next == null) {
            return 0;
        }
        int count = 0;
        Node temp = head.next;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // 新浪：查找倒数第index个节点：size-index
    public static Node findLastNode(Node head, int index) {
        // 判断链表是否为空
        if (head.next == null) return null;
        // 获取总个数
        int size = count(head);
        if (index < 0 || index > size) return null;
        // 遍历该节点
        Node temp = head.next;
        for (int i = 0; i < size - index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // 腾讯：将链表反转
    public static void reverse(Node head) {
        // 若为空或只有一个节点无需反转
        if (head.next == null || head.next.next == null) {
            return;
        }
        // 定义当前节点
        Node cur = head.next;
        // 定义一个新的头节点
        Node reverseHead = new Node(0, "", "");
        Node next = null;
        // 若当前节点不为空，则遍历
        while (cur != null) {
            next = cur.next;
            // 将当前节点的下一个指向新链表头结点的下一个
            cur.next = reverseHead.next;
            // 将新链表的头结点指向当前节点
            reverseHead.next = cur;
            // 当前节点后移
            cur = next;
        }
        // 将原链表头结点下一个指向新链表头结点下一个
        head.next = reverseHead.next;
    }

    // 百度：将链表从尾到头打印输出
    public static void reversePrint(Node head) {
        if (head.next == null) {
            return;
        }
        // 创建一个栈
        Stack<Node> stack = new Stack<>();
        Node cur = head.next;
        // 遍历链表
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        // 遍历打印栈
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1, "张三", "zs");
        Node node2 = new Node(2, "李四", "ls");
        Node node3 = new Node(3, "王五", "ww");
        Node node4 = new Node(4, "赵六", "zl");
        linkedList list = new linkedList();

        // 非顺序添加节点
        list.add(node1);
        list.add(node2);
        list.add(node4);
        list.add(node3);

        // 顺序添加节点
//        list.addByOrder(node1);
//        list.addByOrder(node2);
//        list.addByOrder(node4);
//        list.addByOrder(node3);

        // 修改节点
//        list.addByOrder(node1);
//        list.update(node2);

//        list.addByOrder(node1);
//        list.addByOrder(node2);
//        list.addByOrder(node3);
//        list.addByOrder(node4);
        // 删除节点
//        list.delete(1);
//        System.out.println(count(list.getHead()));

        // 遍历倒数节点
//        Node res = findLastNode(list.getHead(), 3);
//        System.out.println(res);

        // 测试反转链表
//        reverse(list.getHead());

        // 测试从尾到头打印
//        reversePrint(list.getHead());

        System.out.println("显示链表：");
        list.list();
    }
}

// 定义链表
class linkedList {
    // 1.初始化头结点，不存放数据
    Node head = new Node(0, "", "");

    // 2.返回头结点
    public Node getHead() {
        return head;
    }

    // 3.添加节点到链表
    // i.找到链表的最后节点
    // ii.将最后节点指向新节点
    public void add(Node node) {
        Node temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        // 当退出循环时，将该节点赋给下一个
        temp.next = node;
    }

    // 顺序添加节点到链表
    public void addByOrder(Node node) {
        Node temp = head;
        boolean flag = false;
        while (true) {
            // 排空
            if (temp.next == null) {
                flag = true;
                break;
            }
            if (node.no < temp.next.no) {   // 寻找位置节点
                flag = true;
                break;
            } else if (node.no == temp.next.no) {  // 若插入节点序号与该节点序号相等
                break;
            }
            // 后移
            temp = temp.next;
        }
        // 符合条件进行插入
        if (flag) {
            // 将插入节点指向当前节点的下一个节点
            node.next = temp.next;
            // 将当前节点指向插入节点
            temp.next = node;
        } else {
            System.out.println("插入失败，序号冲突！");
        }
    }

    // 修改节点到链表
    public void update(Node node) {
        // 判断是否为空
        if (head.next == null) {
            return;
        }
        Node temp = head;
        boolean flag = false;
        while (true) {
            // 判断是否为最后一个节点
            if (temp.next == null) {
                break;
            } else if (node.no == temp.next.no) {// 传入节点序号与当前节点序号相等
                flag = true;
                break;
            }
            // 将节点后移
            temp = temp.next;
        }
        if (flag) {
            temp.name = node.name;
            temp.nickname = node.nickname;
        } else {
            System.out.println("修改失败！");
        }
    }

    // 删除节点
    // 找到需要删除节点的前一个节点
    public void delete(int n) {
        Node temp = head;
        while (true) {
            // 排空
            if (temp.next == null) {
                break;
            }
            // 若该节点序号等于要删除节点序号
            if (n == temp.next.no) {
                // 当前节点指向下下个节点
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }

    // 4.显示链表数据
    public void list() {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }
        Node temp = head.next;
        // 通过头结点遍历
        while (true) {
            // 判断链表是否最后
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            // 后移
            temp = temp.next;
        }
    }
}

// 定义一个节点类
class Node {
    public int no;
    public String name;
    public String nickname;
    public Node next;      // 指向下一个节点

    public Node(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
