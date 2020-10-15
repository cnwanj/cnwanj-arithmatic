package org.gxuwz.arithmatic.lanqiao.lanqiao10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 试题 E: 迷宫
 * 本题总分：15 分
 * 【问题描述】
 * 下图给出了一个迷宫的平面图，其中标记为 1 的为障碍，标记为 0 的为可 以通行的地方。
 * 4 6
 * 010000
 * 000100
 * 001001
 * 110000
 *
 * 迷宫的入口为左上角，出口为右下角，在迷宫中，只能从一个位置走到这 个它的上、下、左、右四个方向之一。
 *
 * 对于上面的迷宫，从入口开始，可以按 DRRURRDDDR 的顺序通过迷宫， 一共 10 步。其中 D、U、L、R 分别表示向下、向上、向左、向右走。
 *
 * 对于下面这个更复杂的迷宫（30 行 50 列），请找出一种通过迷宫的方式， 其使用的步数最少，在步数最少的前提下，请找出字典序最小的一个作为答案。
 *
 * 请注意在字典序中D<L<R<U。（如果你把以下文字复制到文本文件中，请务 必检查复制的内容是否与文档中的一致。
 *
 * 在试题目录下有一个文件 maze.txt， 内容与下面的文本相同）
 * 30 50
 * 01010101001011001001010110010110100100001000101010
 * 00001000100000101010010000100000001001100110100101
 * 01111011010010001000001101001011100011000000010000
 * 01000000001010100011010000101000001010101011001011
 * 00011111000000101000010010100010100000101100000000
 * 11001000110101000010101100011010011010101011110111
 * 00011011010101001001001010000001000101001110000000
 * 10100000101000100110101010111110011000010000111010
 * 00111000001010100001100010000001000101001100001001
 * 11000110100001110010001001010101010101010001101000
 * 00010000100100000101001010101110100010101010000101
 * 11100100101001001000010000010101010100100100010100
 * 00000010000000101011001111010001100000101010100011
 * 10101010011100001000011000010110011110110100001000
 * 10101010100001101010100101000010100000111011101001
 * 10000000101100010000101100101101001011100000000100
 * 10101001000000010100100001000100000100011110101001
 * 00101001010101101001010100011010101101110000110101
 * 11001010000100001100000010100101000001000111000010
 * 00001000110000110101101000000100101001001000011101
 * 10100101000101000000001110110010110101101010100001
 * 00101000010000110101010000100010001001000100010101
 * 10100001000110010001000010101001010101011111010010
 * 00000100101000000110010100101001000001000000000010
 * 11010000001001110111001001000011101001011011101000
 * 00000110100010001000100000001000011101000000110011
 * 10101000101000100010001111100010101001010000001000
 * 10000010100101001010110000000100101010001011101000
 * 00111100001000010000000110111000000001000000001011
 * 10000001100111010111010001000110111010101101111000
 *
 * 【答案提交】
 * 这是一道结果填空的题，你只需要算出结果后提交即可。
 *
 * 本题的结果为一 个字符串，包含四种字母 D、U、L、R，在提交答案时只填写这个字符串，填 写多余的内容将无法得分。
 *
 * 【思路】
 * 分两步出发：
 * 1、从终点倒数第一个位置往起点方向计数（0为第一个数)
 * 010000
 * 000100
 * 001001
 * 110000
 * 计数后：
 * 10 0 6 5 4 5
 * 9  8 7 0 3 4
 * 10 9 0 3 2 0
 * 0  0 3 2 1 2
 * 2、从起点第一个位置寻找一条倒序的路线
 * 10 0 7 6 5 5
 * 10 9 8 0 4 4
 * 10 9 0 3 3 0
 * 0  0 3 2 2 1
 */
public class Demo5_迷宫 {

    // 下上左右
    static int[][] xy = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    static char[] dir = {'D', 'U', 'L', 'R'};
    static int[][] vis;
    static int n, m;

    public static void main(String[] args) throws IOException {
        reader("F:\\学习课件\\中心文件\\赛事\\2020-蓝桥\\2019-12月\\蓝桥杯（真题）\\第十届蓝桥杯大赛省赛（软件类）真题\\JB\\JB\\maze.txt");
    }

    static void reader(String fileName) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader(fileName));
        String line = bf.readLine();
        char[][] a = new char[4][6];
        int n = 0;
        while (line != null) {
            a[n] = line.toCharArray();
            line = bf.readLine();
            n++;
        }
        endToStart(a);
//        for (int i = 0; i < 30; i++) {
//            System.out.println(Arrays.toString(vis[i]));
//        }
        startToEnd(a);
    }

    // 从终点到起点的遍历
    static void endToStart(char[][] a) {
        n = a.length;
        m = a[0].length;
        vis = new int[n][m];
        // 存放每次广度优先搜索到的坐标
        Queue<Integer> queue = new LinkedList<Integer>();
        // 添加倒数第一个坐标（从0开始）
        queue.add(n * m - 1);
        // 若队列不为空
        while (!queue.isEmpty()) {
            int p = queue.poll();
            // 四周探测
            for (int i = 0; i < 4; i++) {
                int x = p / m + xy[i][0];
                int y = p % m + xy[i][1];
                if (x >= 0 && x < n && y >= 0 && y < m && a[x][y] == '0' && vis[x][y] == 0) {
                    // 将前一个位置 +1 赋值给下一个位置
                    vis[x][y] = vis[p / m][p % m] + 1;
                    // 将下一个位置添加到队列中
                    queue.add(x * m + y);
                    if (x == 0 && y == 0) {
                        break;
                    }
                }
            }
        }
    }

    // 起点到终点深度优先遍历
    static void startToEnd(char[][] a) {
        // 将倒数第一个数设置为0
        vis[n - 1][m - 1] = 0;
        // 重新设置横纵坐标
        int x = 0;
        int y = 0;
        String res = "";
        // 若不是终点
        while (x != n - 1 || y != m - 1) {
            for (int i = 0; i < 4; i++) {
                int o = x + xy[i][0];
                int p = y + xy[i][1];
                if (o >= 0 && o < n && p >= 0 && p < m && a[o][p] == '0') {
                    // 若当前数等于下一个数+1
                    if (vis[x][y] == vis[o][p] + 1) {
                        x = o;
                        y = p;
                        res += dir[i];
                        break;
                    }
                }
            }
        }
        System.out.println(res.length());
        System.out.println(res);
    }
}

class Demo5_迷宫1 {

    private static int[][] a, vis, xy = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    private static String[] fx = {"D", "U", "L", "R"};
    private static int n, m;
    private static String str = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        a = new int[n][m];
        vis = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split("");
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(s[j]);
            }
        }
        // 倒序广度遍历
        bfs();
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(n * m - 1);
        while(!queue.isEmpty()) {
            int q = queue.poll();
            // 将队列中的下标转换为数组中的下标
            int x = q / m;
            int y = q % m;
            for (int i = 0; i < 4; i++) {
                int o = x + xy[i][0];
                int p = y + xy[i][1];
                if (o >= 0 && o < n && p >= 0 && p < m && a[o][p] == 0 && vis[o][p] == 0) {
                    vis[o][p] = vis[x][y] + 1;
                    queue.add(o * m + p);
                    if (o == 0 && p == 0)
                        break;
                }
            }
        }
        // 将倒数第一个设为0
        vis[n - 1][m - 1] = 0;
        // 深度优先遍历
        dfs(0, 0);
        System.out.println(str);
    }

    private static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int o = x + xy[i][0];
            int p = y + xy[i][1];
            if (o >= 0 && o < n && p >= 0 && p < m && vis[x][y] == vis[o][p] + 1) {
                str += fx[i];
                dfs(o, p);
            }
        }
    }
}
