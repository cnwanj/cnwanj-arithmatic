package org.gxuwz.arithmatic.dataStructures.Demo04_栈;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰表达式(后缀表达式)：完成计算机
 * 以及中缀表达式转后缀表达式
 */
public class PolandNotation {
    public static void main(String[] args) {
        /**
         * (3+4)*5-6 -> 《 3 4 + 5 × 6 -》
         * 1+((2+3)×4)-5 -> 《 1 2 3 + 4 × + 5 –》
         */
//        int i = calculate(getString("3 4 + 5 * 6 -"));
//        System.out.println("(3+4)*5-6="+i);
        List<String> num = getString1("10.1+((2+3)*4)-5");
        System.out.println(num);
        System.out.println(middleString(num));
        System.out.println(calculate(middleString(num)));
    }

    // 接收一个中缀表达式，并存放在list集合中，注意多位数
    public static List<String> getString1(String s) {
        //定义一个List,存放中缀表达式 对应的内容
        List<String> ls = new ArrayList<String>();
        int i = 0; //这时是一个指针，用于遍历 中缀表达式字符串
        String str; // 对多位数的拼接
        char c; // 每遍历到一个字符，就放入到c
        do {
            //如果c是一个非数字，我需要加入到ls
            if (((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) && (c = s.charAt(i)) != 46) {
                ls.add("" + c);
                i++; //i需要后移
            } else { //如果是一个数，需要考虑多位数
                str = ""; //先将str 置成"" '0'[48]->'9'[57]
                while (i < s.length() && (((c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) || (c = s.charAt(i)) == 46)) {
                    str += c;//拼接
                    i++;
                }
                ls.add(str);
            }
        } while (i < s.length());
        return ls;
    }

    // 将中缀表达式转换为后缀表达式
    public static List<String> middleString(List<String> list) {
        // 创建两个栈，一个存放运算符，一个存放完整的后缀表达式
        Stack<String> operStack = new Stack<>();
        List<String> numList = new ArrayList<>();
        for (String n : list) {
            // 若是数字
            if ((n.charAt(0) + "").matches("\\d")) {
                numList.add(n);
            } else {
                if ("(".equals(n)) {
                    operStack.push(n);
                } else if (")".equals(n)) {
                    // 遍历该栈，直到遇到左括号(
                    while (!operStack.peek().equals("(")) {
                        numList.add(operStack.pop());
                    }
                    // 将括号弹出，进行消除
                    operStack.pop();
                } else if (isOper(n)) {// 若为运算符，则比较优先级
                    while (operStack.size() != 0 && priority(n) < priority(operStack.peek())) {   // 若优先级大，入栈
                        numList.add(operStack.pop());
                    }
                    operStack.push(n);
                } else {
                    System.out.println("运算符号有误！");
                }
            }
        }
        while (operStack.size() != 0) {
            numList.add(operStack.pop());
        }
        return numList;
    }

    // 接收逆波兰表达式，将字符存入一个新的集合
    public static List<String> getString(String str) {
        String[] strings = str.split(" ");
        List<String> list = new ArrayList<>();
        for (String s : strings) {
            System.out.println(s);
            list.add(s);
        }
        return list;
    }

    // 返回运算符优先级
    public static int priority(String oper) {
        if (oper.equals("*") || oper.equals("/"))
            return 1;
        else if (oper.equals("+") || oper.equals("-"))
            return 0;
        else
            return -1;
    }

    // 判断是否为运算符
    public static boolean isOper(String val) {
        return val.equals("+") || val.equals("-") || val.equals("*") || val.equals("/");
    }

    /**
     * 完成逆波兰计算
     * 1)从左至右扫描，将3和4压入堆栈；
     * 2)遇到+运算符，因此弹出4和3（4为栈顶元素，3为次顶元素），计算出3+4的值，得7，再将7入栈；
     * 3)将5入栈；
     * 4)接下来是×运算符，因此弹出5和7，计算出7×5=35，将35入栈；
     * 5)将6入栈；
     * 6)最后是-运算符，计算出35-6的值，即29，由此得出最终结果
     */
    public static Double calculate(List<String> list) {
        Stack<String> stack = new Stack<>();
        for (String l : list) {
            // 判断是否为数字，通过正则表达式
            if ((l.charAt(0) + "").matches("\\d")) {
                // 将数字入栈
                stack.push(l);
            } else {
                // 若为运算符
                double num2 = Double.parseDouble(stack.pop());
                double num1 = Double.parseDouble(stack.pop());
                double res = 0;
                if ("+".equals(l)) {
                    res = num1 + num2;
                } else if ("-".equals(l)) {
                    res = num1 - num2;
                } else if ("*".equals(l)) {
                    res = num1 * num2;
                } else if ("/".equals(l)) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误!");
                }
                stack.push(res + "");
            }
        }
        return Double.parseDouble(stack.pop());
    }
}
