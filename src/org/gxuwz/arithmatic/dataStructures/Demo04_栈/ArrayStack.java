package org.gxuwz.arithmatic.dataStructures.Demo04_栈;

import java.util.Scanner;

public class ArrayStack {
    public static void main(String[] args) {
        Stack stack = new Stack(3);
        Scanner input = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("a：添加数据到栈");
            System.out.println("b：从栈中取出数据");
            System.out.println("c：显示栈数据");
            System.out.println("o：退出");
            String key = input.next();
            switch (key) {
                case "a":
                    System.out.println("请输入一个数：");
                    int a = input.nextInt();
                    stack.pushStack(a);
                    break;
                case "b":
                    try {
                        int b = stack.popStack();
                        System.out.println("取出的数据是：" + b);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "c":
                    try {
                        stack.printStack();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "o":
                    input.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }
}

// 创建一个栈
class Stack {
    private int maxSize;
    private int stack[];
    private int top = -1;

    // 定义构造器
    public Stack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    // 栈满
    public boolean isFull() {
        return top == maxSize;
    }

    // 栈空
    public boolean isEmpty() {
        return top == -1;
    }

    // 入栈 push
    public void pushStack(int value) {
        if (isFull()) {
            System.out.println("栈满！！");
            return;
        }
        top++;
        stack[top] = value;
    }

    // 出栈 pop
    public int popStack() {
        if (isEmpty()) {
            throw new RuntimeException("栈空！！");
        }
        int value = stack[top];
        top--;
        return value;
    }

    // 打印
    public void printStack() {
        if (isEmpty()) {
            throw new RuntimeException("栈空！！");
        }
        for (int i = top; i > -1; i--) {
            System.out.print(stack[i] + " " + "\n");
        }
    }
}
