package org.gxuwz.arithmatic.lanqiao.lanqiao11_模拟;

import java.util.*;

/*
第八题 长草
题目
【问题描述】

    小明有一块空地，他将这块空地划分为 n 行 m 列的小块，每行和每列的长度都为 1。

    小明选了其中的一些小块空地，种上了草，其他小块仍然保持是空地。

    这些草长得很快，每个月，草都会向外长出一些，如果一个小块种了草，

    则它将向自己的上、下、左、右四小块空地扩展，这四小块空地都将变为有草的小块。

    请告诉小明，k 个月后空地上哪些地方有草。

【输入格式】
    输入的第一行包含两个整数 n, m。
    接下来 n 行，每行包含 m 个字母，表示初始的空地状态，字母之间没有空格。
    如果为小数点，表示为空地，如果字母为 g，表示种了草。接下来包含一个整数 k。

【输出格式】
    输出 n 行，每行包含 m 个字母，表示 k 个月后空地的状态。
    如果为小数点，表示为空地，如果字母为 g，表示长了草。

【样例输入】
4 5
.g...
.....
..g..
.....
2
【样例输出】
    gggg.
    gggg.
    ggggg
    .ggg.
【评测用例规模与约定】
    对于 30% 的评测用例，2 <= n, m <= 20。
    对于 70% 的评测用例，2 <= n, m <= 100。
    对于所有评测用例，2 <= n, m <= 1000，1 <= k <= 1000。
 */
public class Demo8_长草 {
    // 记录上下左右
    static int[][] xy = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] tag;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        // 存放初始值
        char[][] a = new char[n][m];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextLine().toCharArray();
        }
        // 月份
        int k = sc.nextInt();
        // 记录是否长草
        tag = new boolean[n][m];

        // 深度优先遍历
        f(a, k);

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }

    static void f(char[][] a, int k) {
        if (k == 0) {
            return;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                // 若为草地，且没有标记过
                if (a[i][j] == 'g' && !tag[i][j]) {
                    tag[i][j] = true;
                    // 深度遍历
                    dfs(a, i, j);
                }
            }
        }
        // 清空标记
        tag = new boolean[a.length][a[0].length];
        // 递归调用下一个月份
        f(a, k - 1);
    }

    static void dfs(char[][] a, int x, int y) {
        int o, p;
        // 进行上下左右遍历
        for (int i = 0; i < 4; i++) {
            o = x + xy[i][0];
            p = y + xy[i][1];
            // 若没有越界 && 没有标记过 && 空地
            if (o >= 0 && o < a.length && p >= 0 && p < a[0].length && !tag[o][p] && a[o][p] == '.') {
                tag[o][p] = true;
                a[o][p] = 'g';
            }
        }
    }
}
