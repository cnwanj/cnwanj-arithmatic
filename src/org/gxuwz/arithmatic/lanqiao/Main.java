package org.gxuwz.arithmatic.lanqiao;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.close();

        // a[i][j] i表示第多少位，j表示一个分界线
        // 奇数行就是大于j的方案数，偶数行就是小于j的方案数
        // 奇数要比前面的大，所以要大于的，偶数要比前面的小，所以要小于的
        int[][] a = new int[m + 2][n + 2];
        // 初始化边界
        for (int i = 1; i <= n; i++) {
            a[1][i] = n - i + 1;
        }

        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
        System.out.println();
        for (int i = 2; i <= m; i++) {
            // 将i转换为2进制的各位数，若等于1为奇数，否则为偶数
            if ((i & 1) == 1) {
                // 若是奇数，倒序
                for (int j = n; j >= 1; j--) {
                    a[i][j] = (a[i - 1][j - 1] + a[i][j + 1] % 10000);
                }
            } else {
                // 若为偶数
                for (int j = 1; j <= n; j++) {
                    a[i][j] = (a[i - 1][j + 1] + a[i][j - 1] % 10000);
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }

        // 判断奇偶从此我要改成这个了，一位位运算确实快
        // m&1，就是把m换成二进制看看最后一位是不是1，如果是1证明就是奇数，如果是0证明是偶数
        int r = (m & 1) == 1 ? a[m][1] : a[m - 1][n];
        System.out.println(r);
    }
}

