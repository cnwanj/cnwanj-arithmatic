package org.gxuwz.arithmatic.lanqiao.lanqiao9;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 标题：全球变暖
 *
 *  你有一张某海域NxN像素的照片，"."表示海洋、"#"表示陆地，如下所示：
 *
.......
.##....
.##....
....##.
..####.
...###.
.......
 *
 *  其中"上下左右"四个方向上连在一起的一片陆地组成一座岛屿。例如上图就有2座岛屿。
 *
 *  由于全球变暖导致了海面上升，科学家预测未来几十年，岛屿边缘一个像素的范围会被海水淹没。
 *  具体来说如果一块陆地像素与海洋相邻(上下左右四个相邻像素中有海洋)，它就会被淹没。
 *
 *  例如上图中的海域未来会变成如下样子：
 *
 *  .......
 *  .......
 *  .......
 *  .......
 *  ....#..
 *  .......
 *  .......
 *
 *  请你计算：依照科学家的预测，照片中有多少岛屿会被完全淹没。
 *
 *  【输入格式】
 *  第一行包含一个整数N。  (1 <= N <= 1000)
 *  以下N行N列代表一张海域照片。
 *
 *  照片保证第1行、第1列、第N行、第N列的像素都是海洋。
 *
 *  【输出格式】
 *  一个整数表示答案。
 *
 *  【输入样例】
 *  7
 *  .......
 *  .##....
 *  .##....
 *  ....##.
 *  ..####.
 *  ...###.
 *  .......
 *
 *  【输出样例】
 *  1
 *
 *  资源约定：
 *  峰值内存消耗（含虚拟机） < 256M
 *  CPU消耗  < 1000ms
 *
 *
 *  请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。
 *
 *  所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
 *  不要使用package语句。不要使用jdk1.7及以上版本的特性。
 *  主类的名字必须是：Main，否则按无效代码处理。
 */
public class Demo9_全球变暖 {

    static int N;
    static boolean[][] vis;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static void bfs(char[][] a, int x, int y) {

        int o, p;
        for (int i = 0; i < 4; i++) {
            // 上下左右遍历
            o = x + dir[i][0];
            p = y + dir[i][1];
            // 判断是都已经越界
            if (o >= 0 && o < N && p >= 0 && p < N && !vis[o][p] && a[o][p] == '#') {
                vis[o][p] = true;
                bfs(a, o, p);
            }
        }
    }

    static int islandCount(char[][] a) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 若是岛屿，且没有遍历过
                if (a[i][j] == '#' && !vis[i][j]) {
                    vis[i][j] = true;
                    // 深度优先遍历，i和j为该点的坐标
                    bfs(a, i, j);
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();
        // 存放初始值
        char[][] a = new char[N][N];
        // 存放结果
        char[][] result = new char[N][N];
        // 是否遍历过
        vis = new boolean[N][N];
        String s;
        for (int i = 0; i < N; i++) {
            s = sc.nextLine();
            a[i] = s.toCharArray();
            result[i] = s.toCharArray();
        }

        // 深度遍历找出岛屿的数量
        int count = islandCount(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (a[i][j] == '#') {
                    int o, p;
                    for (int k = 0; k < 4; k++) {
                        o = i + dir[k][0];
                        p = j + dir[k][1];
                        if (o < 0 || o >= N || p < 0 || p >= N) {
                            result[i][j] = '.';
                            break;
                        } else if (a[o][p] == '.') {
                            result[i][j] = '.';
                            break;
                        }

                    }
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
        vis = new boolean[N][N];
        System.out.println(count - islandCount(result));
    }
}
