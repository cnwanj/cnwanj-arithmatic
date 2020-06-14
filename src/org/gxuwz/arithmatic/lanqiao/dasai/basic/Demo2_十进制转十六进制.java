package org.gxuwz.arithmatic.lanqiao.dasai.basic;

import java.util.Scanner;

/**
 * 试题 基础练习 十进制转十六进制
 * <p>
 * 资源限制
 * 时间限制：1.0s   内存限制：512.0MB
 * 问题描述
 * 　　十六进制数是在程序设计时经常要使用到的一种整数的表示方式。
 * 它有0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F共16个符号，分别表示十进制数的0至15。
 * 十六进制的计数方法是满16进1，所以十进制数16在十六进制中是10，
 * 而十进制的17在十六进制中是11，以此类推，十进制的30在十六进制中是1E。
 * <p>
 * 　　给出一个非负整数，将它表示成十六进制的形式。
 * 输入格式
 * 　　输入包含一个非负整数a，表示要转换的数。0<=a<=2147483647
 * 输出格式
 * 　　输出这个整数的16进制表示
 * 样例输入
 * 30
 * 样例输出
 * 1E
 * <p>
 * 思路：2000 -> 7D0
 * 2000/16 = 125...0
 * 125 /16 = 7  ...13
 * 7   /16 = 0 ...7
 */
public class Demo2_十进制转十六进制 {

    public static String f(int n) {
        String str = "";
        if (n >= 0 && n <= 9) {
            str = Integer.toString(n);
        } else if (n > 9) {
            switch (n) {
                case 10:
                    str = "A";
                    break;
                case 11:
                    str = "B";
                    break;
                case 12:
                    str = "C";
                    break;
                case 13:
                    str = "D";
                    break;
                case 14:
                    str = "E";
                    break;
                case 15:
                    str = "F";
                    break;
                default:
                    break;
            }
        }
        return str;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if (n > -1) {
            String str = "";
            if (n / 16 == 0) {
                str = f(n % 16);
            } else {
                do {
                    str = f(n % 16) + str;
                    n = n / 16;
                } while (n > 0);
            }
            System.out.println(str);
        }
    }
}




