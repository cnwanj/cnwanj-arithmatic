package org.gxuwz.arithmatic.lanqiao.practise;

import java.util.Scanner;

/**
 * 12、基础练习 十六进制转八进制
 * 问题描述
 * 　　给定n个十六进制正整数，输出它们对应的八进制数。
 * 输入格式
 * 　　输入的第一行为一个正整数n （1<=n<=10）。
 * 　　接下来n行，每行一个由0~9、大写字母A~F组成的字符串，表示要转换的十六进制正整数，每个十六进制数长度不超过100000。
 * 输出格式
 * 　　输出n行，每行为输入对应的八进制正整数。
 * 注意
 * 　　输入的十六进制数不会有前导0，比如012A。
 * 　　输出的八进制数也不能有前导0。
 * 样例输入
 * 2
 * 39
 * 123ABC
 * 样例输出
 * 71
 * 4435274
 * 提示
 * 先将十六进制数转换成某进制数，再由某进制数转换成八进制。
 * <p>
 * 思路：分两步
 * 1、将十六进制转二进制
 * 十六进制的每一位数转换为 4位二进制数，如：
 * 12 -> 0001 0010
 * 2、将二进制转八进制
 * 每3位二进制转换为八进制的一位数
 * 0001 0010 -> 010 010 -> 22
 */
public class Demo12_十六进制转八进制 {
    public static void f1() {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String[] a = new String[n];
        if (n > 10) {
            System.out.println("输入数字不能大于10!");
            return;
        }
        for (int i = 0; i < n; i++) {
            a[i] = input.next();
        }
        // 十六进制转二进制
        f2(a);
    }

    // 十六进制转二进制
    public static void f2(String[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            String str = "";
            for (int j = 0; j < arr[i].length(); j++) {
                char a = arr[i].charAt(j);
                str = str + f3(a);
            }
            // 二进制转八进制
            f4(str);
        }
    }

    public static String f3(char a) {
        String s = "";
        switch (a) {
            case '0':
                s = "0000";
                break;
            case '1':
                s = "0001";
                break;
            case '2':
                s = "0010";
                break;
            case '3':
                s = "0011";
                break;
            case '4':
                s = "0100";
                break;
            case '5':
                s = "0101";
                break;
            case '6':
                s = "0110";
                break;
            case '7':
                s = "0111";
                break;
            case '8':
                s = "1000";
                break;
            case '9':
                s = "1001";
                break;
            case 'a':
                s = "1010";
                break;
            case 'b':
                s = "1011";
                break;
            case 'c':
                s = "1100";
                break;
            case 'd':
                s = "1101";
                break;
            case 'e':
                s = "1110";
                break;
            case 'f':
                s = "1111";
                break;
            default:
                break;
        }
        return s;
    }

    // 二进制转换八进制
    public static void f4(String str) {
        int len = str.length();
        String s;
        String a = "";
        while (len > 0) {
            if (len == 2) {
                str = "0" + str;
                len = 3;
            } else if (len == 1) {
                str = "00" + str;
                len = 3;
            }
            s = str.substring(len - 3, len);
            a = f5(s) + a;
            len = len - 3;
        }
        if (a.charAt(0) == '0') {
            a = a.substring(1);
        }
        System.out.println(a);
    }

    public static String f5(String s) {
        String a = "";
        switch (s) {
            case "000":
                a = "0";
                break;
            case "001":
                a = "1";
                break;
            case "010":
                a = "2";
                break;
            case "011":
                a = "3";
                break;
            case "100":
                a = "4";
                break;
            case "101":
                a = "5";
                break;
            case "110":
                a = "6";
                break;
            case "111":
                a = "7";
                break;
            default:
                break;
        }
        return a;
    }

    public static void main(String[] args) {
//       f1();
        String s = "123".replaceAll("1", "0");
        System.out.println(s);
    }
}
