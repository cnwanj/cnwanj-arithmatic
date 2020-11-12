package org.gxuwz.arithmatic.lanqiao.guosai.lanqiao5;

import java.util.Arrays;

/**
 * @Author: vovhh
 * @Date: 2020-11-12 10:50:21
 * @Description: 标题：六角幻方
 * 把 1 2 3 ... 19 共19个整数排列成六角形状，如下：
 * <p>
 * * * *
 * * * * *
 * * * * * *
 * * * * *
 * * * *
 * <p>
 * 要求每个直线上的数字之和必须相等。共有15条直线哦！
 * 再给点线索吧！我们预先填好了2个数字，第一行的头两个数字是：15 13，参见图【p1.png】，黄色一行为所求。
 * 请你填写出中间一行的5个数字。数字间用空格分开。
 * 这是一行用空格分开的整数，请通过浏览器提交答案，不要填写任何多余的内容（比如说明性的文字等）
 */
public class Main2_六角幻方 {

    // , 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 16, 17, 18, 19
    static int[] a = {1, 2, 3}, b;
    static boolean[] vis;
    static int count = 0;

    public static void main(String[] args) {
        b = new int[a.length];
        vis = new boolean[a.length];
        f(0);
        System.out.println(count);
//        dfs(0);
    }

    static void f(int p) {
//        System.out.println(p);
        System.out.println(Arrays.toString(b));
        if (p == b.length - 1) {
            count++;
//            dfs(0);
            return;
        }
        for (int i = 0; i < a.length; i++) {
            if (!vis[i]) {

                b[p] = a[i];
                vis[i] = true;
                f(p + 1);
                vis[i] = false;
            }
        }
    }

    static void dfs(int p) {
        if (p == a.length) {
            System.out.println(Arrays.toString(a));
//            check();
            return;
        }
        for (int i = p; i < a.length; i++) {
            swap(i, p);
            dfs(1 + p);
            swap(i, p);
        }
    }

    static void swap(int i, int p) {
        int t = a[i];
        a[i] = a[p];
        a[p] = t;
    }

    static void check() {
//        System.out.println(Arrays.toString(b));
        int c = 15 + 13 + b[0];
        int d = b[1] + b[2] + b[3] + b[4];
        int e = b[5] + b[6] + b[7] + b[8] + b[9];
        int f = 15 + b[1] + b[5];
        int g= b[0] + b[4] + b[9];
//        System.out.println(c + " " + d + " " + e);
        if (c == d && d == e && e == f && f == g)
            System.out.println(Arrays.toString(b));
    }
}
