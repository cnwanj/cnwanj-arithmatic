package org.gxuwz.arithmatic.lanqiao.practise;

import java.util.Scanner;

/**
 * 10、基础练习 十进制转十六进制
 * 问题描述
 * 　　十六进制数是在程序设计时经常要使用到的一种整数的表示方式。
 * 它有0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F共16个符号，分别表示十进制数的0至15。
 * 十六进制的计数方法是满16进1，所以十进制数16在十六进制中是10，
 * 而十进制的17在十六进制中是11，以此类推，十进制的30在十六进制中是1E。
 * 　　给出一个非负整数，将它表示成十六进制的形式。
 * 输入格式
 * 　　输入包含一个非负整数a，表示要转换的数。0<=a<=2147483647
 * 输出格式
 * 　　输出这个整数的16进制表示
 * 样例输入
 * 30
 * 样例输出
 * 1E
 */
public class Demo10_十进制转十六进制 {
    public static void f1() {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        if (n < 0 || n > 2147483647) {
            System.out.println("输入范围在：0-2147483647");
            return;
        }
        if (n < 10) System.out.println(n);
        else {
            int a = n % 16;
            String b = "";
            int c = n / 16;
            switch (a) {
                case 10:
                    b = "A";
                    break;
                case 11:
                    b = "B";
                    break;
                case 12:
                    b = "C";
                    break;
                case 13:
                    b = "D";
                    break;
                case 14:
                    b = "E";
                    break;
                case 15:
                    b = "F";
                    break;
            }
            if ("".equals(b)) {
                System.out.println(c + "" + a);
            } else {
                if (c == 0) {
                    System.out.println(b);
                } else {
                    System.out.println(c + b);
                }
            }
        }
    }

    public static void f2() {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        if (n < 0 || n > 2147483647) {
            System.out.println("输入范围在：0-2147483647");
            return;
        }
        if (n == 0) {
            System.out.println(n);
        }
        char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuffer sb = new StringBuffer();
        while (n != 0) {
            sb = sb.append(a[n % 16]);
            n /= 16;
        }
        System.out.println(sb.reverse());
    }

    public static void main(String[] args) {
        f2();
//        System.out.println(12&0xF);
    }
}
