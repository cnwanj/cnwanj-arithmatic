package org.gxuwz.arithmatic.dataStructures.Demo03_链表;

/**
 * 约瑟夫单项环形链表
 */
public class JosepfuLinkedList {
    public static void main(String[] args) {
        CircleSingleLinked list = new CircleSingleLinked();
        // 添加小孩
        list.add(5);
        // 打印显示小孩
        list.show();
        // 测试小孩出圈循序
        list.countBoy(1, 3, 5);
    }
}

class CircleSingleLinked {

    private Boy first = null;

    // 添加小孩环形链表
    public void add(int nums) {
        if (nums < 1) {
            System.out.println("输入值不正确！");
            return;
        }
        // 辅助节点
        Boy cur = null;
        for (int i = 1; i <= nums; i++) {
            // 根据编号创建节点
            Boy boy = new Boy(i);
            // 若为第一个节点
            if (i == 1) {
                // 将该节点赋值给头结点
                first = boy;
                // 将头结点指向自己，形成链表
                first.setNext(first);
                // 将第一个节点赋给辅助节点
                cur = first;
            } else {
                // 将该节点赋给辅助节点
                cur.setNext(boy);
                // 将该节点指向头节点
                boy.setNext(first);
                // 将辅助节点赋给该节点
                cur = boy;
            }
        }
    }

    /**
     * 根据用户输入，计算出小孩的出圈顺序
     *
     * @param startNo：开始报数的小孩
     * @param countNum：每次数多少个小孩
     * @param nums：一共有多少个小孩
     */
    public void countBoy(int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("输入参数有误! 请重新输入！");
            return;
        }
        // 创建辅助指针
        Boy helper = first;
        // 循环遍历将辅助指针指向first的前一个节点
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        // 报数前，将helper和first移动到startNo
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        // 开始报数，从报数第一个小孩开始，报数到countNum-1的小孩出圈
        while (true) {
            // 只有最后一个小孩
            if (helper == first) break;
            // 将helper和first移动到第cuntNum个小孩
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            // 将小孩出圈
            System.out.printf("第小孩 %d 出圈\n", first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩 %d", first.getNo());
    }

    // 显示链表
    public void show() {
        // 排空
        if (first == null) {
            System.out.println("没有小孩！");
            return;
        }
        Boy cur = first;
        // 遍历链表
        while (true) {
            System.out.println("小孩的编号：" + cur.getNo());
            // 若该节点指向头节点，则为最后
            if (cur.getNext() == first) {
                break;
            }
            // 后移一位
            cur = cur.getNext();
        }
    }
}

class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
