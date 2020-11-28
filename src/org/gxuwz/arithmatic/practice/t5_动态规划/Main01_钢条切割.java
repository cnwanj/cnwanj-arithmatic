package org.gxuwz.arithmatic.practice.t5_动态规划;

import java.util.Arrays;

/**
 * @Author: vovhh
 * @Date: 2020-11-28 10:12:14
 * @Description:
 *
 * 参考博客网址：https://blog.csdn.net/u013309870/article/details/75193592
 *
 * 本节给出一个寻找钢条最优切割方案的问题。公司购买长钢条，将其切割为短钢条出售。
 *
 * 为简化分析，假设切割过程本身没有成本，并且切割下来的短钢条长度都为一英寸的整数倍。
 *
 * 下表给出了不同长度的钢条的价格。
 *
 * 长度i（英寸）：1  2  3  4  5  6  7  8  9  10
 * 价格p（美元）：1  5  8  9  10 17 17 20 24 30
 */
public class Main01_钢条切割 {

    /**
     * 我们将钢条从左切割下长度为i的一段，
     * 只对右边剩下长度n-i的一段继续进行切割（多个求解），
     * 对这边一段则不再进行切割。
     */
    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        // int num = f(arr, 4);
        int num = mom(arr);
        System.out.println(num);
    }

    /**
     * 1.递归版本
     * @param arr   数组
     * @param n     切割最大数
     * @return      返回最优解
     */
    static int f(int[] arr, int n) {
        if (n == 0)
            return 0;
        int q = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            q = Math.max(q, arr[i - 1] + f(arr, n - i));
        }
        return q;
    }

    /**
     * 2.备忘录方法
     * 备忘录方法无非是在递归的时候记录下已经调用过的子函数的值。
     * @param arr   数组
     * @return      最优解
     */
    static int mom(int[] arr) {
        int[] r = new int[arr.length + 1];
        Arrays.fill(r, -1);
        return cut(arr, arr.length, r);
    }

    static int cut(int[] arr, int n, int[] r) {
        int q = -1;
        if (r[n] >= 0)
            return r[n];
        if (n == 0)
            q = 0;
        else {
            for (int i = 1; i <= n; i++) {
                q = Math.max(q, cut(arr, n - i, r) + arr[i - 1]);
            }
        }

        return r[n] = q;
    }

    /**
     * 3.自底向上的动态规划
     */
}
