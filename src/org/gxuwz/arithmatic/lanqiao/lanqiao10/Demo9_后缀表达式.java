package org.gxuwz.arithmatic.lanqiao.lanqiao10;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 【问题描述】
 * 给定 N 个加号、M 个减号以及 N + M + 1 个整数 A1, A2, · · · , AN+M+1，小
 * 明想知道在所有由这 N 个加号、M 个减号以及 N + M + 1 个整数凑出的合法的
 * 后缀表达式中，结果最大的是哪一个？
 * 请你输出这个最大的结果。
 * 例如使用1 2 3 + -，则 “2 3 + 1 -” 这个后缀表达式结果是 4，是最大的。
 *
 * 【输入格式】
 * 第一行包含两个整数 N 和 M。
 * 第二行包含 N + M + 1 个整数 A1, A2, · · · , AN+M+1。
 *
 * 【输出格式】
 * 输出一个整数，代表答案。
 *
 * 【样例输入】
 * 1 1
 * 1 2 3
 *
 * 【样例输出】
 * 4
 *
 * 【评测用例规模与约定】
 * 对于所有评测用例，0 ≤ N, M ≤ 100000，ˈ 109 ≤ Ai ≤ 109。
 */
public class Demo9_后缀表达式 {
    static int[] a2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 数字数组
        a2 = new int[N + M + 1];
        for (int i = 0; i < a2.length; i++) {
            a2[i] = sc.nextInt();
        }

        // 排序
        Arrays.sort(a2);
        int sum = 0;

        // 将最大的数进行相加
        for (int i = M; i < a2.length; i++) {
            sum += a2[i];
        }

        // 减去最小的数
        for (int i = 0; i < M; i++) {
            sum -= a2[i];
        }
        System.out.println(sum);

    }
}
