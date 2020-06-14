package org.gxuwz.arithmatic.lanqiao.practise;

import java.util.Scanner;

/**
 * 11、基础练习 十六进制转十进制
 * 问题描述
 * 　　从键盘输入一个不超过8位的正的十六进制数字符串，将它转换为正的十进制数后输出。
 * 　　注：十六进制数中的10~15分别用大写的英文字母A、B、C、D、E、F表示。
 * 样例输入
 * FFFF
 * 样例输出
 * 65535
 */
public class Demo11_十六进制转十进制 {
    public static void f1() {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        int len = s.length();
        int lena = a.length;
        int sum = 0;
        // 遍历该数的每一位数
        for (int i = 1; i <= len; i++) {
            char b = s.charAt(len - i);
            // 遍历数组中的字符
            for (int j = 0; j < lena; j++) {
                // 数组中与每一位数对比
                if (a[j] == b) {
                    if (j < 10) {
                        int c = Integer.parseInt(b + "");
                        sum += c * f(16, i - 1);
                    } else {
                        sum += j * f(16, i - 1);
                    }
                }
            }
        }
        if (sum == 0) {
            System.out.println("请输入十六进制数！");
        } else {
            System.out.println(sum);
        }
    }

    // 求次幂
    public static int f(int a, int b) {
        int sum = 1;
        for (int i = 0; i < b; i++) {
            sum = sum * a;
        }
        return sum;
    }

    public static void main(String[] args) {
        f1();
    }
}
