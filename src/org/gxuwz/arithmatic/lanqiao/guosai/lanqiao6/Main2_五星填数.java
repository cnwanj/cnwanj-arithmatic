package org.gxuwz.arithmatic.lanqiao.guosai.lanqiao6;

import java.util.Arrays;

/**
 * @Author: 韦永恒
 * @Date: 2020-10-26 20:32:49
 * @Description:
 *
 * 标题：五星填数
 *
 * 如【图1.png】的五星图案节点填上数字：1~12，除去7和11。
 * 要求每条直线上数字和相等。
 *
 * 如图就是恰当的填法。
 *
 * 请你利用计算机搜索所有可能的填法有多少种。
 * 注意：旋转或镜像后相同的算同一种填法。
 *
 * 请提交表示方案数目的整数，不要填写任何其它内容。
 *
 * 【答案】12
 */
public class Main2_五星填数 {

    static int[] a = {1, 2, 3, 4, 5, 6, 8, 9, 10, 12};
    static int count = 0;

    public static void main(String[] args) {
        f(0);
        System.out.println(count / 5 / 2);
    }

    static void f(int p) {
        if (p == a.length) {
            // 6 8 10 12 9 5 3 1 4 2
            if (check()) {
                count ++;
                System.out.println(Arrays.toString(a));
                return;
            }
        }
        for (int i = p; i < a.length; i++) {
            swap(i, p);
            f(1 + p);
            swap(i, p);
        }
    }

    static boolean check() {
        int b = a[0] + a[5] + a[6] + a[2];
        int c = a[2] + a[7] + a[8] + a[4];
        int d = a[4] + a[9] + a[5] + a[1];
        int e = a[1] + a[6] + a[7] + a[3];
        int f = a[3] + a[8] + a[9] + a[0];
        if (b == c && c == d && d == e && e == f) {
            return true;
        }
        return false;
    }

    static void swap(int i, int p) {
        int t = a[i];
        a[i] = a[p];
        a[p] = t;
    }
}
