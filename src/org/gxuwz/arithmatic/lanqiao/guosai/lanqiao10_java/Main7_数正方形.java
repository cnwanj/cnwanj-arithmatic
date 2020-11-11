package org.gxuwz.arithmatic.lanqiao.guosai.lanqiao10_java;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * @Author: vovhh
 * @Date: 2020-11-10 22:35:26
 * @Description:
 *
 * 试题 G: 数正方形
 * 时间限制: 1.0s 内存限制: 512.0MB 本题总分：20 分
 * 【问题描述】
 * 在一个 N × N 的点阵上，取其中 4 个点恰好组成一个正方形的 4 个顶点，
 * 一共有多少种不同的取法？
 * 由于结果可能非常大，你只需要输出模 10^9 + 7 的余数。
 * 如上图所示的正方形都是合法的。
 * 【输入格式】
 * 输入包含一个整数 N。
 * 【输出格式】
 * 输出一个整数代表答案。
 * 【样例输入】
 * 4
 * 【样例输出】
 * 20
 * 【数据规模与约定】
 * 对于所有评测用例，2 ≤ N ≤ 1000000。
 */
public class Main7_数正方形 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 2) {
            System.out.println(n - 1);
            return;
        }

        int sum = 0;
        for (int i = 1, j = n - 1; i < n; i++, j--) {
            sum = (sum + i * j * j) % 1000000007;
        }
        System.out.println(sum);
    }
}

class Main7 {
    static final int mod = 1000000007;

    public static void main(String[] args) throws IOException {
        long n = nextInt(System.in);
        long res = ((n - 1)* (n - 1)) % mod;
        for (int i = 2; i < n; i++)
            res = (res + (((n - i) * (n - i)) % mod) * i) % mod;
        System.out.println(res);
    }

    static int nextInt(InputStream in) throws IOException {
        int n = 0, c = in.read();
        while (c < '0' || c > '9') c = in.read();
        while (c >='0' && c <='9') {
            n = n * 10 + (c & 0xf);
            c = in.read();
        }
        return n;
    }
}
