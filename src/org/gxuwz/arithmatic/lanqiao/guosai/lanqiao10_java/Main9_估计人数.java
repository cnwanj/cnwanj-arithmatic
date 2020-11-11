package org.gxuwz.arithmatic.lanqiao.guosai.lanqiao10_java;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: vovhh
 * @Date: 2020-11-10 22:35:26
 * @Description:
 *
 * 试题 I: 估计人数
 * 时间限制: 1.0s 内存限制: 512.0MB 本题总分：25 分
 * 【问题描述】
 * 给定一个 N × M 的方格矩阵，矩阵中每个方格标记 0 或者 1 代表这个方格
 * 是不是有人踩过。
 * 已知一个人可能从任意方格开始，之后每一步只能向右或者向下走一格。
 * 走了若干步之后，这个人可以离开矩阵。这个人经过的方格都会被标记为 1，
 * 包括开始和结束的方格。注意开始和结束的方格不需要一定在矩阵边缘。
 * 请你计算至少有多少人在矩阵上走过。
 * 【输入格式】
 * 输入第一行包含两个整数 N、M。
 * 以下 N 行每行包含 M 个整数 (0/1)，代表方格矩阵。
 * 【输出格式】
 * 输出一个整数代表答案。
 * 【样例输入】
 *
 * 5 5
 * 00100
 * 11111
 * 00101
 * 11111
 * 00100
 *
 * 【样例输出】
 * 3
 * 【数据规模与约定】
 * 对于所有评测用例，1 ≤ N, M ≤ 20，标记为 1 的方格不超过 200 个。
 */
public class Main9_估计人数 {

    static int[][] a, xy = {{0, 1}, {1, 0}};
    static int N = 0, M = 0, count = 0;
    static boolean[][] vis;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        a = new int[N][M];
        vis = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String[] s = sc.nextLine().split("");
            for (int j = 0; j < M; j++) {
                a[i][j] = Integer.parseInt(s[j]);
            }
        }
//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(a[i]));
//        }
        f();
    }

    static void f() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (a[i][j] == 1 && !vis[i][j]) {
                    vis[i][j] = true;
                    dfs(i, j);
                    count ++;
                    for (int k = 0; k < N; k++) {
                        System.out.println(Arrays.toString(vis[k]));
                    }
                    System.out.println();
                }
            }
        }
        System.out.println(count);
    }

    static void dfs(int x, int y) {
        for (int i = 0; i < xy.length; i++) {
            int o = x + xy[i][0];
            int p = y + xy[i][1];
            if (o < N && p < M && !vis[o][p] && a[o][p] == 1) {
                vis[o][p] = true;
                dfs(o, p);
                return;
            }
        }
    }
}
