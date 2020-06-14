package org.gxuwz.arithmatic.lanqiao.dasai.begin;

import java.util.Scanner;

/**
 * 问题描述
 * Fibonacci数列的递推公式为：Fn=Fn-1+Fn-2，其中F1=F2=1。
 * <p>
 * 当n比较大时，Fn也非常大，现在我们想知道，Fn除以10007的余数是多少。
 * <p>
 * 输入格式
 * 输入包含一个整数n。
 * 输出格式
 * 输出一行，包含一个整数，表示Fn除以10007的余数。
 * 说明：在本题中，答案是要求Fn除以10007的余数，因此我们只要能算出这个余数即可，
 * 而不需要先计算出Fn的准确值，再将计算的结果除以10007取余数，直接计算余数往往比先算出原数再取余简单。
 * <p>
 * 样例输入
 * 10
 * 样例输出
 * 55
 * 样例输入
 * 22
 * 样例输出
 * 7704
 * 数据规模与约定
 * 1 <= n <= 1,000,000。
 */
public class Demo02_斐波那契求余 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if (n >= 1 && n <= 1000000) {
            int a = 1, b = 1, c = 0;
            if (n < 3) {
                System.out.print(1);
                return;
            }
            for (int i = 3; i <= n; i++) {
                if (a > 10007)
                    a = a % 10007;
                if (b > 10007)
                    b = b % 10007;
                c = a + b;
                a = b;
                b = c;
            }
            System.out.print(c % 10007);
        }
    }
}
