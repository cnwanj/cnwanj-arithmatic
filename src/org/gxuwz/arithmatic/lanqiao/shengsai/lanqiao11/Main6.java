package org.gxuwz.arithmatic.lanqiao.shengsai.lanqiao11;

import java.util.Scanner;

/**
 * 试题 F: 成绩分析
 */
public class Main6 {

    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        f(a);
    }

    static void f(int[] a) {
        int max = a[0], min = a[0];
        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            if (max < a[i])
                max = a[i];

            if (min > a[i])
                min = a[i];

            sum += a[i];
        }
        System.out.println(max);
        System.out.println(min);
        System.out.printf("%.2f", sum / n);
    }
}
