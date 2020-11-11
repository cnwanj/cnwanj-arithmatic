package org.gxuwz.arithmatic.lanqiao.guosai.lanqiao10_java;

import java.util.Arrays;

/**
 * @Author: vovhh
 * @Date: 2020-11-10 22:35:26
 * @Description:
 *
 * 试题 B: 平方拆分
 * 本题总分：5 分
 * 【问题描述】
 * 将 2019 拆分为若干个两两不同的完全平方数之和，一共有多少种不同的方
 * 法？
 * 注意交换顺序视为同一种方法，例如 13^2 + 25^2 + 35^2 = 2019 与 13^2 + 35^2 +
 * 25^2 = 2019 视为同一种方法。
 * 【答案提交】
 * 这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一
 * 个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。
 *
 */
public class Main2_平方拆分 {

    static int N = 0;
    static int[] a, b;

    public static void main(String[] args) {
        N = (int)Math.sqrt(2019);
        // 44
        a = new int[N];
        b = new int[3];
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            a[i - 1] = i * i;
//            sum += a[i - 1];
//            if (sum >= 2019)
//                System.out.println(i - 1);
        }
        f(0, 0);
    }

    static void f(int c, int p) {
        if (p == b.length) {
            if (check()) {
                System.out.println(Arrays.toString(b));
            }
            return;
        }
        for (int i = c; i < N; i++) {
            b[p] = a[i];
            f(i + 1, p + 1);
        }
    }

    static boolean check() {
        int s = 0;
        for (int i = 0; i < b.length; i++) {
            s += b[i];
            if (s > 2019) {
                return false;
            }
        }
        if (s == 2019)
            return true;
        return false;
    }
}

class Main2_平方拆分1 {
    static int cnt;

    public static void main(String[] args) {
        dfs(2019, -1);
        System.out.println(cnt);
    }

    // 52574
    static void dfs(int num, int start) {
        if (num < 0)
            return;
        if (num == 0)
            cnt++;
        else {
            int high = (int)Math.sqrt(num);
            for (int i = start + 1; i <= high; i++) {
                dfs(num - i * i, i);
            }
        }
    }
}

class Main2_平方拆分2 {

    static int count = 0;

    public static void main(String[] args) {
        int n = (int)Math.sqrt(2019);
        f(2019, -1, n);
        System.out.println(count);
    }

    static void f(int num, int p, int n) {
        if (num < 0)
            return;
        if (num == 0)
            count ++;
        else {
            for (int i = p + 1; i <= n; i++) {
                f(num - i * i, i, n);
            }
        }
    }
}
