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
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        if (n == 0 || n == 1) {
            System.out.println(1);
            return;
        }
        long[] arr = new long[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i ++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }
        System.out.println(arr[n]);
    }
}


