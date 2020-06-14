package org.gxuwz.arithmatic.lanqiao.lanqiao11_模拟;

import java.util.Scanner;

/**
 * 第九题 序列计数
 * 题题目
 * 【问题描述】
 * 小明想知道，满足以下条件的正整数序列的数量：
 * 1. 第一项为 n；
 * 2. 第二项不超过 n；
 * 3. 从第三项开始，每一项小于前两项的差的绝对值。
 * 请计算，对于给定的 n，有多少种满足条件的序列。
 * 【输入格式】
 * 输入一行包含一个整数 n。
 * 【输出格式】
 * 输出一个整数，表示答案。答案可能很大，请输出答案除以10000的余数。
 * 【样例输入】
 * 4
 * 【样例输出】
 * 7
 * 【样例说明】
 * 以下是满足条件的序列：
 * 4 1
 * 4 1 1
 * 4 1 2
 * 4 2
 * 4 2 1
 * 4 3
 * 4 4
 * 【评测用例规模与约定】
 * 对于 20% 的评测用例，1 <= n <= 5；
 * 对于 50% 的评测用例，1 <= n <= 10；
 * 对于 80% 的评测用例，1 <= n <= 100；
 * 对于所有评测用例，1 <= n <= 1000。
 */
class Demo9_序列计数 {
    static Scanner sc;
    static long sum;
    static final int MOD = 10000;
    static long[][] mem = new long[1001][1001];

    static long dfs(int pre, int cur) {
        if (mem[pre][cur] != 0)
            return mem[pre][cur];
        sum = 1;
        /**
         * 4 1
         * 4 1 1
         * 4 1 2
         * 4 2
         * 4 2 1
         * 4 3
         * 4 4
         */
        for (int i = 1; i < Math.abs(pre - cur); i++) {
            sum = (sum + dfs(cur, i)) % MOD;
        }
        mem[pre][cur] = sum;
        return sum;
    }

    static void f() {
        sum = 0;
        int N = sc.nextInt();
        long t1 = System.currentTimeMillis();
        /**
         * 4 1
         * 4 1 1
         * 4 1 2
         * 4 2
         * 4 2 1
         * 4 3
         * 4 4
         */
        // 遍历N以内的每一个数，将前两个数作为参数
        for (int i = 1; i <= N; i++) {
            sum = (sum + dfs(N, i)) % MOD;
        }
        System.out.println(sum);
        System.out.println(System.currentTimeMillis() - t1);
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        f();
    }
}
