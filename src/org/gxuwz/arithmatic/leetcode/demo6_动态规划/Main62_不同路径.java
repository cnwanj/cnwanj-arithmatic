package org.gxuwz.arithmatic.leetcode.demo6_动态规划;

import java.util.Scanner;

/**
 * 62. 不同路径
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *
 * 示例 1：
 *
 * 输入：m = 3, n = 7
 * 输出：28
 * 示例 2：
 *
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 * 示例 3：
 *
 * 输入：m = 7, n = 3
 * 输出：28
 * 示例 4：
 *
 * 输入：m = 3, n = 3
 * 输出：6
 *
 * 解析：
 * 到达右下角arr[i][j]的路径总和，等于上坐标arr[i - 1][j]和左坐标arr[i][j - 1]的路径总和。
 * 简单说，当前格子等于上方格子加左方格子。
 * 得出结论：arr[i][j] = arr[i - 1][j] + arr[i][j -];
 */
public class Main62_不同路径 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(f(m, n));
    }

    static int f(int m, int n) {
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 初始化第一行和第一列值为1
                if (i == 0 || j == 0) {
                    arr[i][j] = 1;
                }
                // 若下标没有越界，则计算当前下标路径总和
                if (i - 1 >= 0 && j - 1 >= 0) {
                    arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
                }
            }
        }
        return arr[m - 1][n - 1];
    }
}
