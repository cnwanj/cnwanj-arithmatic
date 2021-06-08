package org.gxuwz.arithmatic.leetcode.demo6_动态规划;

/**
 * 给定一个包含非负整数的 m * n 网格grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例 1：
 *
 * 输入：grid = [[1,3,1], [1,5,1], [4,2,1]]
 *
 * 输出：7
 *
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * 示例 2：
 *
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 *
 * 131
 * 151
 * 421
 *
 * 123
 * 456
 *
 * 思路：
 * 1.初始化第一列和第一行
 * 2.当前坐标元素最小路径等于左方或上方的路径和
 */
public class Main64_最小路径和 {

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        // 初始化第一列和第一行
        for (int i = 1; i < n; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < m; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        // 当前坐标元素最小路径等于左方或上方的路径和
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
            }
        }
        return grid[n - 1][m - 1];
    }
}
