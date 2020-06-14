package org.gxuwz.arithmatic.dataStructures.Demo04_栈;

/**
 * 使用链表模拟战
 * 创建链表
 * 入栈：平常的添加链表
 * 出栈：找到倒数第二个，将倒数第二个设置为null
 */
public class LinkedListStack {
    public static void main(String[] args) {
        StackNode stack1 = new StackNode(1);
        StackNode stack2 = new StackNode(2);
        StackNode stack3 = new StackNode(3);
        LinkedStack list = new LinkedStack();
        list.input(stack1);
        list.input(stack2);
        list.input(stack3);
        list.show();
        list.out();
        list.out();
        list.show();
    }
}

class LinkedStack {
    private int top = 0;
    private StackNode head = new StackNode(0);

    public StackNode getHead() {
        return head;
    }

    // 入栈
    public void input(StackNode node) {
        StackNode temp = head;
        while (true) {
            // 若为空，则向里面添加
            if (temp.getNext() == null) {
                break;
            }
            temp = temp.getNext();
        }
        top++;
        temp.setNext(node);
    }

    // 出栈
    public void out() {
        if (head.getNext() == null) {
            throw new RuntimeException("空");
        }
        StackNode temp = head;
        while (true) {
            if (temp.getNext().getNext() == null) {
                top--;
                System.out.println("出：" + temp.getNext().getNo());
                temp.setNext(null);
                break;
            }
            temp = temp.getNext();
        }
    }

    // 显示
    public void show() {
        if (head.getNext() == null) {
            System.out.println("空");
            return;
        }
        StackNode temp = head.getNext();
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.getNext();
        }
    }
}

// 创建链表
class StackNode {
    private int no;
    private StackNode next;

    public StackNode(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public StackNode getNext() {
        return next;
    }

    public void setNext(StackNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "StackNode{" +
                "no=" + no +
                '}';
    }
}

