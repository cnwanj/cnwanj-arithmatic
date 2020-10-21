package org.gxuwz.arithmatic.lanqiao.lanqiao11;

import java.util.Scanner;

/**
 * 试题 B: 寻找 2020
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), sum = 0;
        int[][] a = new int[n][n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] str = s.split("");
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(str[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 3; j++) {
                // 行
                int a1 = a[i][j] * 1000 + a[i][j+1] * 100 + a[i][j+2] * 10 + a[i][j+3];
                if (a1 == 2020) {
                    sum ++;
                }
                // 列
                int a2 = a[j][i] * 1000 + a[j+1][i] * 100 + a[j+2][i] * 10 + a[j+3][i];
                if (a2 == 2020) {
                    sum ++;
                }
                // 斜线
                if (i < n - 3) {
                    int a3 = a[i][j] * 1000 + a[i+1][j+1] * 100 + a[i+2][j+2] * 10 + a[i+3][j+3];
                    if (a3 == 2020) {
                        sum ++;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
