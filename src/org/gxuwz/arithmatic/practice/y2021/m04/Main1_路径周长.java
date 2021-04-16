package org.gxuwz.arithmatic.practice.y2021.m04;

import java.util.Scanner;

/**
 * 一个5*5的方形网格矩阵
 * G=[
 *     [0,1,1,0,0],
 *     [0,1,0,0,0],
 *     [0,1,1,1,0],
 *     [0,1,0,1,1],
 *     [0,0,0,0,0]
 * ]
 * 如下图，其中：G[i][j]=1表示该网格为黑色，G[i][j]=0表示该网格为白色，网格边长为1，
 * 请通过代码实现函数calculateCircumference计算黑色部分的周长。
 * calculateCircumference函数的输入参数是网格矩阵G，返回值是黑色部分的周长。
 * 注：语言不限，但需要说明计算思路
 *
 * 输入：
 * 01100
 * 01000
 * 01110
 * 01011
 * 00000
 *
 * 01100
 * 01110
 * 00000
 * 00100
 * 00000
 */
public class Main1_路径周长 {
    static int n = 5, m = 5, sum = 0;
    static int[][] arr;
    static boolean[][] vir;
    static int[][] xy = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[n][m];
        vir = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String[] str = sc.nextLine().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        f();
        System.out.println(sum);
    }

    static void f() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 && !vir[i][j]) {
                    vir[i][j] = true;
                    dfs(i, j);
                }
            }
        }
    }

    static void dfs(int x, int y) {
        sum += getCount(x, y);
        for (int i = 0; i < xy.length; i++) {
            int o = x + xy[i][0];
            int p = y + xy[i][1];
            if (o >= 0 && o < n && p >= 0 && p < m && !vir[o][p] && arr[o][p] == 1) {
                vir[o][p] = true;
                dfs(o, p);
            }
        }
    }

    static int getCount(int x, int y) {
        int count = 0;
        for (int i = 0; i < xy.length; i++) {
            int o = x + xy[i][0];
            int p = y + xy[i][1];
            // 越界
            if (o < 0 || o >= n || p < 0 || p >= m) {
                count += 1;
            } else if (arr[o][p] == 0) {
                // 等于0
                count += 1;
            }
        }
        System.out.println("(" + x + ", " + y + ") -- " + count);
        return count;
    }
}
