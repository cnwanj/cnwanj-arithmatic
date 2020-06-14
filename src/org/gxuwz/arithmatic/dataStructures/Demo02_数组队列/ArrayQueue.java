package org.gxuwz.arithmatic.dataStructures.Demo02_数组队列;

import java.util.Scanner;

/**
 * 原始数组队列
 */
public class ArrayQueue {
    public static void main(String[] args) {
        // 创建一个队列
        Queue queue = new Queue(3);
        // 接收输入
        char key = ' ';
        Scanner input = new Scanner(System.in);
        boolean loop = true;
        // 输出菜单
        while (loop) {
            System.out.println("a: 添加数据到队列");
            System.out.println("g: 从队列取出数据");
            System.out.println("s: 显示队列");
            System.out.println("h: 查看队列头数据");
            System.out.println("o: 退出程序");
            key = input.next().charAt(0);
            switch (key) {
                case 'a':
                    System.out.println("请输入一个数：");
                    int n = input.nextInt();
                    queue.addQueue(n);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.println("取出的数据是：" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 's':
                    try {
                        queue.showQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int h = queue.headQueue();
                        System.out.println("队列头数据是：" + h);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'o':
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }
}

// 1.使用数组模拟队列，编写一个ArrayQueue类
class Queue {
    private int maxSize;    // 队列的最大存储
    private int front;      // 队头
    private int rear;       // 队尾
    private int[] arr;      // 数组队列，存储数据

    // 2.创建队列的构造器
    public Queue(int ArrMaxSize) {
        maxSize = ArrMaxSize;
        arr = new int[ArrMaxSize];
        front = -1;
        rear = -1;
    }

    // 3.判断队列是否满
    public boolean isFull() {
        // 判断队尾是否为最大值减一
        return rear == maxSize - 1;
    }

    // 4.判断队列是否空
    public boolean isEmpty() {
        return rear == front;
    }

    // 5.添加数据到队列，进队
    public void addQueue(int n) {
        // 判断队列是否已满
        if (isFull()) {
            System.out.println("队列已满，不能添加数据！");
            return;
        }
        // 将队尾后移添加数据
        rear++;
        arr[rear] = n;
    }

    // 6.获取队列中的数据，出队
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取数据！");
        }
        // 将队头后移，取出数据
        front++;
        return arr[front];
    }

    // 7.显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取数据！");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    // 8.显示队列的头数据，不取出数据
    public int headQueue() {
        if (isEmpty())
            throw new RuntimeException("队列为空，不能取数据！");
        return arr[front + 1];
    }
}
