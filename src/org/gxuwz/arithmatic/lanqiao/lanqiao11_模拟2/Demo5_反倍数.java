package org.gxuwz.arithmatic.lanqiao.lanqiao11_模拟2;

import java.util.Scanner;

/**
 * @description:
 *
 * 【问题描述】给定三个整数 a, b, c，如果一个整数既不是 a 的整数倍也不是 b 的整数倍还不是 c 的整数倍，则这个数称为反倍数。
 *  请问在 1 至 n 中有多少个反倍数。
 * 【输入格式】输入的第一行包含一个整数 n。第二行包含三个整数 a, b, c，相邻两个数之间用一个空格分隔。
 * 【输出格式】输出一行包含一个整数，表示答案。
 * 【样例输入】
 *  30
 *  2 3 6
 * 【样例输出】10
 * 【样例说明】以下这些数满足要求：1, 5, 7, 11, 13, 17, 19, 23, 25, 29。
 * 【评测用例规模与约定】对于 40% 的评测用例，1 &lt;= n &lt;= 10000。对于 80% 的评测用例，1 &lt;= n &lt;= 100000。
 *  对于所有评测用例，1 &lt;= n &lt;= 1000000，1 &lt;= a &lt;= n，1 &lt;= b &lt;= n，1 &lt;= c &lt;= n。
 *
 * @author: 韦永恒
 * @date: 2020-09-02 21:42:18
 */
public class Demo5_反倍数 {

    private static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        f(n, a, b, c);
    }

    static void f(int n, int a, int b, int c) {
        for (int i = 1; i < n + 1; i ++) {
            if (i % a == 0) {
                continue;
            }
            if (i % b == 0) {
                continue;
            }
            if (i % c == 0) {
                continue;
            }
            count ++;
        }
        System.out.println(count);
    }
}
