package org.gxuwz.arithmatic.lanqiao.dasai.algo;

import java.util.Arrays;
import java.util.Scanner;

public class Demo5_数字三角形 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split(" ");
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println();

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    arr[i][j] = arr[i][j] + arr[i - 1][j];
                } else if (i == j) {
                    arr[i][j] = arr[i][j] + arr[i - 1][j - 1];
                } else {
                    arr[i][j] = arr[i][j] + Math.max(arr[i - 1][j - 1], arr[i - 1][j]);
                }
            }
        }
        int max = arr[n - 1][0];
        for (int i = 1; i < n; i++) {
            if (max < arr[n - 1][i]) {
                int temp = max;
                max = arr[n - 1][i];
                arr[n - 1][i] = temp;
            }
        }
        System.out.print(max);
    }
}
