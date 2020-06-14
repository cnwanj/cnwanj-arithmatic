package org.gxuwz.arithmatic.practice.t3;

import java.util.Scanner;

/*
5.（程序题 30分）有一个长方形的房间，上面铺着方砖。每个瓷砖都是红色或黑色的。

一个学生站在一块黑色的瓷砖上。从一个瓷砖，他可以移动到四个相邻瓷砖之一。

但他不能在红瓦上移动，只能在黑瓦上移动。编写一个程序，通过重复上述动作来计算他可以达到的黑色瓷砖的数量。

输入：
输入由多个数据集组成。数据集以包含两个正整数W和H的行开头；W和H分别是x和y方向上的平铺数。W和H不超过20。
数据集中还有H行，每行包含W个字符每个字符代表一个瓷砖的颜色，如下所示。
“.”表示一块黑色的瓷砖
“#”表示红色瓷砖
“@”表示一个站在黑色瓷砖上的人（在数据集中只出现一次）
输出：
对于每个数据集，您的程序应该输出一行，其中包含他可以从初始平铺（包括其本身）到达的平铺数。
数据样例：
输入：
6 9
....#.
.....#
......
......
......
......
......
#@...#
.#..#.
11 9
.#.........
.#.#######.
.#.#.....#.
.#.#.###.#.
.#.#..@#.#.
.#.#####.#.
.#.......#.
.#########.
...........
11 6
..#..#..#..
..#..#..#..
..#..#..###
..#..#..#@.
..#..#..#..
..#..#..#..
7 7
..#.#..
..#.#..
###.###
...@...
###.###
..#.#..
..#.#..
0 0
输出：
45
59
6
13
 */
public class Demo5_铺砖块 {

    static boolean[][] tag;
    // 上下左右方向的处理
    static int[][] xy = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        sc.nextLine();

        while (w != 0 && h != 0) {
            char[][] a = new char[h][w];
            for (int i = 0; i < a.length; i++) {
                a[i] = sc.nextLine().toCharArray();
            }
            // 记录经过的位置
            tag = new boolean[h][w];
            // 遍历查找@坐标
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[i].length; j++) {
                    // 查找起点
                    if (a[i][j] == '@') {
                        tag[i][j] = true;
                        count++;
                        // 深度遍历
                        dfs(a, i, j);
                    }
                }
            }
            System.out.println(count);
            count = 0;
            w = sc.nextInt();
            h = sc.nextInt();
            sc.nextLine();
        }
        /*for (int i = 0; i < tag.length; i++) {
            for (int j = 0; j < tag[i].length; j++) {
                if (tag[i][j]) {
                    a[i][j] = 'a';
                }
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }*/

    }

    static void dfs(char[][] a, int x, int y) {
        int o, p;
        // 进行上下左右查找
        for (int i = 0; i < 4; i++) {
            o = x + xy[i][0];
            p = y + xy[i][1];
            // 是否越界 && 是否标记过 && 是否为'.'
            if (o >= 0 && o < a.length && p >= 0 && p < a[0].length && !tag[o][p] && a[o][p] == '.') {
                tag[o][p] = true;
                count++;
                dfs(a, o, p);
            }
        }
    }
}
