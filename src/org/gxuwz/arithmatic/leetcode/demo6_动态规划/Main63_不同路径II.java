package org.gxuwz.arithmatic.leetcode.demo6_动态规划;

/**
 * 63.不同路径II
 *
 * # 题目
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * ## 示例 1
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 *
 * ### 解释
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 *
 * ## 示例 2
 * 输入：obstacleGrid = [[0,1],[0,0]]
 * 输出：1
 *
 * # 思路
 * 1.若入口和出口都有障碍物，则返回0
 * 2.初始化第一行和第一列，将第一个障碍物之前的初始化为1，障碍物初始化为-1
 * 3.循环遍历，障碍物标记为-1
 * 4.若为非障碍物，当前路径数 + 左边路径数 或 当前路径数 + 上边路径数
 *
 * https://leetcode-cn.com/problems/unique-paths-ii/
 */
public class Main63_不同路径II {

    public static void main(String[] args) {
//        int[][] arr = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
//        int[][] arr = {{0, 1}, {0, 0}};
//        int[][] arr = {{0, 0}, {0, 1}};
//        int[][] arr = {{0, 0}, {1, 1}, {0, 0}};
        int[][] arr =
                {{0,0},
                {1,0},
                {0,1},
                {1,0},
                {0,0}};
        System.out.println(uniquePathsWithObstacles(arr));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        // 若入口和出口都有障碍物，则返回0
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        boolean tag = true;
        // 初始化第一列，-1表示障碍物，1表示路径数
        for (int i = 0; i < m; i++) {
            // 遇到障碍物之前的都设置为1
            if (obstacleGrid[i][0] == 1) {
                obstacleGrid[i][0] = -1;
                tag = false;
            } else if (tag) {
                obstacleGrid[i][0] = 1;
            }
        }
        tag = true;
        // 初始化第一行
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                obstacleGrid[0][i] = -1;
                tag = false;
            } else if (tag) {
                obstacleGrid[0][i] = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    // 将障碍物标记为-1
                    obstacleGrid[i][j] = -1;
                } else if (obstacleGrid[i][j] == 0) {
                    if (obstacleGrid[i][j - 1] != -1) {
                        // 当前路径数 + 左边路径数
                        obstacleGrid[i][j] += obstacleGrid[i][j - 1];
                    }
                    if (obstacleGrid[i - 1][j] != -1) {
                        // 当前路径数 + 上边路径数
                        obstacleGrid[i][j] += obstacleGrid[i - 1][j];
                    }
                }
            }
        }
        return obstacleGrid[m - 1][n - 1];
    }
}
