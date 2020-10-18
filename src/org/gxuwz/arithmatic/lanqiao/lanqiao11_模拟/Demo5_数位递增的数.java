package org.gxuwz.arithmatic.lanqiao.lanqiao11_模拟;

import java.util.Scanner;

/**
 * 【问题描述】
 * 一个正整数如果任何一个数位不大于右边相邻的数位，则称为一个数位递增的数，例如1135是一个数位递增的数，而1024不是一个数位递增的数。
 *
 * 给定正整数 n，请问在整数 1 至 n 中有多少个数位递增的数？
 *
 * 【输入格式】
 * 输入的第一行包含一个整数 n。
 *
 * 【输出格式】
 * 输出一行包含一个整数，表示答案。
 *
 * 【样例输入】
 * 30
 *
 * 【样例输出】
 * 26
 *
 * 【评测用例规模与约定】对于 40% 的评测用例，1 &lt;= n &lt;= 1000。
 * 对于 80% 的评测用例，1 &lt;= n &lt;= 100000。
 * 对于所有评测用例，1 &lt;= n &lt;= 1000000。
 */
public class Demo5_数位递增的数 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            String s = i + "";
            boolean tag = true;
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j - 1) > s.charAt(j)) {
                    tag = false;
                    break;
                }
            }
            if (tag) {
                count++;
            }
        }
        System.out.println(count);
    }
}
