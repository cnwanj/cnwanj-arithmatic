package org.gxuwz.arithmatic.dataStructures.Demo04_栈;

/**
 * 栈的扩展：算术表达式的运算
 */
public class CalculatorStack {
    public static void main(String[] args) {
//        Stack1 stack = new Stack1(3);
//        stack.push(2);
//        stack.pop();
//        stack.show();
        // 表达式
        String expresion = "30+2*6-4";
        // 创建两个栈，一个数字栈，一个运算符栈
        Stack1 numStack = new Stack1(10);
        Stack1 operStack = new Stack1(10);
        // 定义变量
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int res = 0;
        int oper = 0;
        char ch = ' ';
        String keepNum = "";
        while (true) {
            // 截取表达式里面的每个字符
            ch = expresion.substring(index, index + 1).charAt(0);
            // 判断是否为运算符
            if (operStack.isOper(ch)) {
                // 判断栈是否空
                if (operStack.isEmpty()) {
                    operStack.push(ch);
                    // 若不为空
                } else {
                    // 判断优先级，若栈中运算符优先级大于该运算符，则弹出运算符进行运算
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        // 进行计算
                        res = numStack.cal(num1, num2, oper);
                        // 将结果入数字栈
                        numStack.push(res);
                        operStack.push(ch);
                    } else {
                        // 若该运算符优先级大于栈中的直接入栈
                        operStack.push(ch);
                    }
                }
            } else {
                // 若为数字，不能马上入栈，需要判断是否为多位数
                keepNum += ch;
                // 判断是否为最否一个数字
                if (index == expresion.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    // 若为运算符
                    if (operStack.isOper(expresion.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum));
                        // 将keep清空
                        keepNum = "";
                    }
                }
//                numStack.push(ch - 48);
            }
            index++;
            // 判断是否到最后
            if (index >= expresion.length()) {
                break;
            }
        }
        // 遍历剩下的数和运算符
        while (true) {
            if (operStack.isEmpty()) break;
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }
        res = numStack.pop();
        System.out.println(expresion + " = " + res);
    }
}

class Stack1 {
    private int maxSize;    // 栈的长度
    private int top = -1;   // 栈顶变量
    private int[] arr;      // 栈数组

    public Stack1(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    // 栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    // 栈空
    public boolean isEmpty() {
        return top == -1;
    }

    // 入栈
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满！");
            return;
        }
        top++;
        arr[top] = value;
    }

    // 出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空！");
        }
        int value = arr[top];
        top--;
        return value;
    }

    // 打印
    public void show() {
        if (isEmpty()) {
            System.out.println("栈空！");
            return;
        }
        for (int i = top; i > -1; i--) {
            System.out.println("栈元素：" + arr[i]);
        }
    }

    // 返回运算符优先级
    public int priority(int oper) {
        if (oper == '*' || oper == '/')
            return 1;
        else if (oper == '+' || oper == '-')
            return 0;
        else
            return -1;
    }

    // 判断是否为运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    // 计算
    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }

    // 返回栈顶元素
    public int peek() {
        return arr[top];
    }
}
