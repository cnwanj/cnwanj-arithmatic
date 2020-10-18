package org.gxuwz.arithmatic.lanqiao.lanqiao11;

import java.util.Arrays;
import java.util.Scanner;

/*
5
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5

 */

/**
 * 试题 H: 数字三角形
 */
public class Main8 {

    private static int N, sum = 0, l = 0, r = 0;
    private static int[][] a, xy = {{1, 0}, {1, 1}};
    private static int[] b;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();
        a = new int[N][N];
        b = new int[N];
        for (int i = 0; i < N; i++) {
            String[] s = sc.nextLine().split(" ");
            for (int j = 0; j < i + 1; j++) {
                a[i][j] = Integer.parseInt(s[j]);
            }
        }

        f(0, 0, 0);
        System.out.println(sum);
    }

    static void f(int x, int y, int index) {
        if (index == N - 1) {
            if (Math.abs(l - r) <= 1) {
                sum = sumF(b);
            }
            return;
        }
        for (int i = 0; i < xy.length; i++) {
            int o = x + xy[i][0];
            int p = y + xy[i][1];
            if (o < N && p < N) {
                if (i == 0)
                    l ++;
                else
                    r ++;
                b[index] = a[o][p];
                f(o, p, 1 + index);
                if (i == 0)
                    l --;
                else
                    r --;
            }
        }
    }

    static int sumF(int[] arrb) {
        int sum1 = a[0][0];
        for (int i = 0; i < N - 1; i++) {
            sum1 += arrb[i];
        }
        if (sum1 > sum)
            sum = sum1;
        return sum;
    }
}
