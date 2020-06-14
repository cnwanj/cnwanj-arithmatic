package org.gxuwz.arithmatic.lanqiao.practise;

import java.util.Scanner;

/**
 * 9、基础练习 特殊回文数
 * 问题描述
 * 　　123321是一个非常特殊的数，它从左边读和从右边读是一样的。
 * 　　输入一个正整数n， 编程求所有这样的五位和六位十进制数，满足各位数字之和等于n 。
 * 输入格式
 * 　　输入一行，包含一个正整数n。
 * 输出格式
 * 　　按从小到大的顺序输出满足条件的整数，每个整数占一行。
 * 样例输入
 * 52
 * 样例输出
 * 899998
 * 989989
 * 998899
 * 数据规模和约定
 * 　　1<=n<=54。
 */
public class Demo9_特殊回文数 {
    public static void f1() {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        if (n < 1 || n > 54) {
            return;
        }
        int a, b, c;
        for (int i = 10000; i < 1000000; i++) {
            if (i < 100000) {
                a = i / 1000;
                b = i % 100;
                c = b % 10 * 10 + b / 10;
            } else {
                a = i / 1000;
                b = i % 1000;
                c = b % 10 * 100 + (b % 100) / 10 * 10 + b / 100;
            }
            if (a == c) {
                int sum = 0;
                for (int j = i; j > 0; j /= 10) {
                    sum += j % 10;
                }
                if (sum == n) {
                    System.out.println(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        f1();
//        System.out.println(1/10);
    }
}
