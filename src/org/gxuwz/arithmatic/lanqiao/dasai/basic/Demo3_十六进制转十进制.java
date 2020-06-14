package org.gxuwz.arithmatic.lanqiao.dasai.basic;

import java.util.Scanner;

/**
 * 试题 基础练习 十六进制转十进制
 * <p>
 * 资源限制
 * 时间限制：1.0s   内存限制：512.0MB
 * 问题描述
 * 　　从键盘输入一个不超过8位的正的十六进制数字符串，将它转换为正的十进制数后输出。
 * 　　注：十六进制数中的10~15分别用大写的英文字母A、B、C、D、E、F表示。
 * 样例输入
 * FFFF
 * 样例输出
 * 65535
 * <p>
 * FFFF = 15*16^3 + 15*16^2 + 15*16^1 + 15*16^0 = 65535
 * 7D0  = 7*16^2 + 13*16^1 + 0*16^0 = 2000
 */
public class Demo3_十六进制转十进制 {
    // 处理字符
    public static long f(char ch) {
        long n = -1;
        if (ch >= 48 && ch <= 57) {
            n = Integer.parseInt("" + ch);
        } else {
            switch (ch) {
                case 'A':
                    n = 10;
                    break;
                case 'B':
                    n = 11;
                    break;
                case 'C':
                    n = 12;
                    break;
                case 'D':
                    n = 13;
                    break;
                case 'E':
                    n = 14;
                    break;
                case 'F':
                    n = 15;
                    break;
                default:
                    break;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        long n;
        long sum = 0;
        if (str.length() <= 8) {
            for (int i = str.length() - 1, j = 1; i >= 0; i--, j *= 16) {
                n = f(str.charAt(i));
                if (n == -1)
                    break;
                sum += n * j;
            }
            System.out.println(sum);
        }
    }
}
