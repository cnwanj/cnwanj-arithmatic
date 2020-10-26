package org.gxuwz.arithmatic.lanqiao.shengsai.lanqiao11_校选;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 5.（程序题 30分）有一个长方形的房间，上面铺着方砖。
 * 每个瓷砖都是红色或黑色的。一个学生站在一块黑色的瓷砖上。
 * 从一个瓷砖，他可以移动到四个相邻瓷砖之一。但他不能在红瓦上移动，
 * 只能在黑瓦上移动。编写一个程序，通过重复上述动作来计算他可以达到的黑色瓷砖的数量。
 *
 * 输入：
 * 输入由多个数据集组成。数据集以包含两个正整数W和H的行开头；W和H分别是x和y方向上的平铺数。W和H不超过20。
 * 数据集中还有H行，每行包含W个字符每个字符代表一个瓷砖的颜色，如下所示。
 * “.”表示一块黑色的瓷砖
 * “#”表示红色瓷砖
 * “@”表示一个站在黑色瓷砖上的人（在数据集中只出现一次）
 * 输出：
 * 对于每个数据集，您的程序应该输出一行，其中包含他可以从初始平铺（包括其本身）到达的平铺数。
 * 数据样例：
 * 输入：
 * 6 9
 * ....#.
 * .....#
 * ......
 * ......
 * ......
 * ......
 * ......
 * #@...#
 * .#..#.
 * 11 9
 * .#.........
 * .#.#######.
 * .#.#.....#.
 * .#.#.###.#.
 * .#.#..@#.#.
 * .#.#####.#.
 * .#.......#.
 * .#########.
 * ...........
 * 11 6
 * ..#..#..#..
 * ..#..#..#..
 * ..#..#..###
 * ..#..#..#@.
 * ..#..#..#..
 * ..#..#..#..
 * 7 7
 * ..#.#..
 * ..#.#..
 * ###.###
 * ...@...
 * ###.###
 * ..#.#..
 * ..#.#..
 * 0 0
 * 输出：
 * 45
 * 59
 * 6
 * 13
 */
public class Demo5_铺砖块 {

    private static int n, m, count = 1;
    private static char[][] arr;
    private static int[][] xy = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static boolean[][] vis;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        sc.nextLine();
        arr = new char[n][m];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine().toCharArray();
        }

        f();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println(count);
    }

    static void f() {
        // 记录是否走过，默认false
        vis = new boolean[n][m];
        // 遍历寻找起点位置
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 若为'@'且没有走过
                if (arr[i][j] == '@' && !vis[i][j]) {
                    vis[i][j] = true;
                    // 进行深度遍历
                    dfs(i, j);
                    break;
                }
            }
        }
    }

    static void dfs(int a, int b) {
        int x, y;
        for (int j = 0; j < xy.length; j++) {
            x = a + xy[j][0];
            y = b + xy[j][1];
            if (x >= 0 && y >= 0 && x < arr.length && y < arr[0].length && arr[x][y] == '.' && !vis[x][y]) {
                vis[x][y] = true;
                arr[x][y] = '@';
                count ++;
                dfs(x, y);
            }
        }
    }
}
