package org.gxuwz.arithmatic.lanqiao;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 4.（填空题15分）现假设有一根足够长的面筋，
 * 假设我们第1次先将面筋对折1次后切半，那么我们将得到3根面筋，
 * 第2次我们将3根面筋分别连续对折2次后切半，那么我们将得到15根面筋，
 * 以此类推，第7次操作后我们将得到多少根面筋。
 * 注意：需要提交的是一个整数，不要填写任何多余内容。
 *
 * 【答案】
 * 635037975
 *
 * 【思路】
 * 先计算一条面筋被对折后相切后得到的面筋数sum，再乘与上一次切得的面筋数
 */
public class Main1 {
    public static void main(String[] args) {
//        long sum = 1, num = 2;
//        for (int i = 1; i <= 7; i++) {
//            num = num * 2 - 1;
//            sum = sum * num;
//        }
        System.out.println(123 % 10 / 10);
    }

    // 先计算一条面筋被对折后相切后得到的面筋数Num
    static int cutNum(int n) {
        if (n == 1)
            return 3;
        return n * n + 1;
    }
}


