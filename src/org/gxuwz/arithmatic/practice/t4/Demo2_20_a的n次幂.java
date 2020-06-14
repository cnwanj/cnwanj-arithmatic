package org.gxuwz.arithmatic.practice.t4;

public class Demo2_20_a的n次幂 {
    public static int f(int a, int n) {
        int r = 1;
        for (int i = 0; i < n; i++) {
            r *= a;
        }
        return r;
    }

    //优化后的
    public static int f1(int a, int n) {
        if (n == 0) return 1;
        int res = a;
        int in = 1;
        while (in * 2 <= n) {
            res *= res;
            in *= 2;
        }
        return res * f1(a, n - in);
    }

    public static int f2(int a, int n) {
        if (n == 0) return 1;
        int res = a;
        int in = 1;
        //如果能够翻倍
        while ((in << 1) <= n) {
            res = res * res;
            in = in << 1;
        }
        //如果不能翻倍
        return res * f2(a, n - in);
    }

    public static void main(String[] args) {
        System.out.println(f2(2, 11));
    }
}
