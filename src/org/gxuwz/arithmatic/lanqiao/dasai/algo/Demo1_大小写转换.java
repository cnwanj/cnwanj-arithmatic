package org.gxuwz.arithmatic.lanqiao.dasai.algo;

import java.util.Scanner;

/**
 * 试题 算法训练 大小写转换
 * <p>
 * 资源限制
 * 时间限制：1.0s   内存限制：256.0MB
 * 问题描述
 * 　　输入一个字符串，将大写字符变成小写、小写变成大写，然后输出
 * 输入格式
 * 　　acbAB
 * 输出格式
 * 　　ACBab
 * 样例输入
 * 一个满足题目要求的输入范例。
 * 例：
 * acbAB
 * 样例输出
 * 与上面的样例输入对应的输出。
 * 例：
 * ACBab
 * 数据规模和约定
 * 　　输入数据中每一个数的范围。
 * 　　例：0<n,m<100, 0<=矩阵中的每个数<=1000。
 */
public class Demo1_大小写转换 {
    public static String f(char ch) {
        String str = "";
        if (ch >= 65 && ch <= 90) {          // 若是大写
            str = "" + ((char) (ch + 32));
        } else if (ch >= 97 && ch <= 122) { // 若是小写
            str = "" + ((char) (ch - 32));
        }
        return str;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        String str1 = "";
        for (int i = 0; i < str.length(); i++) {
            str1 = str1 + f(str.charAt(i));
        }
        System.out.println(str1);
    }
}
