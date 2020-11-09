package org.gxuwz.arithmatic.lanqiao.guosai.lanqiao9;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: vovhh
 * @Date: 2020-11-06 12:41:00
 * @Description:
 *
 * 标题4：整理玩具
 *
 * 小明有一套玩具，一共包含NxM个部件。这些部件摆放在一个包含NxM个小格子的玩具盒中，每个小格子中恰好摆放一个部件。
 *
 * 每一个部件上标记有一个0~9的整数，有可能有多个部件标记相同的整数。
 *
 * 小明对玩具的摆放有特殊的要求：标记相同整数的部件必须摆在一起，组成一个矩形形状。
 *
 * 如以下摆放是满足要求的：
 *
 * 00022
 * 00033
 * 44444
 *
 * 12244
 * 12244
 * 12233
 *
 * 01234
 * 56789
 *
 * 以下摆放不满足要求：
 *
 * 11122
 * 11122
 * 33311
 *
 * 111111
 * 122221
 * 122221
 * 111111
 *
 * 3 5
 * 11122
 * 11113
 * 33333
 *
 * 给出一种摆放方式，请你判断是否符合小明的要求。
 *
 * 输入
 * ----
 * 输入包含多组数据。
 * 第一行包含一个整数T，代表数据组数。 (1 <= T <= 10)
 * 以下包含T组数据。
 * 每组数据第一行包含两个整数N和M。  (1 <= N, M <= 10)
 * 以下包含N行M列的矩阵，代表摆放方式。
 *
 * 输出
 * ---
 * 对于每组数据，输出YES或者NO代表是否符合小明的要求。
 *
 * 【样例输入】
 * 3
 * 3 5
 * 00022
 * 00033
 * 44444
 * 3 5
 * 11122
 * 11122
 * 33311
 * 2 5
 * 01234
 * 56789
 *
 * 【样例输出】
 * YES
 * NO
 * YES
 *
 * 资源约定：
 * 峰值内存消耗（含虚拟机） < 256M
 * CPU消耗  < 1000ms
 *
 * 请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。
 *
 * 所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
 * 不要使用package语句。不要使用jdk1.7及以上版本的特性。
 * 主类的名字必须是：Main，否则按无效代码处理。
 *
 * 【思路】
 * - 查找同元素的位置并获取对应的下标
 * - 矩形的起点为坐标最小的行列(xMin, yMin)
 * - 矩形的终点为坐标最大的行列(xMax, yMax)
 * - 在上述基础上判断矩形内的元素是否相同
 *
 */
public class Main4_整理玩具 {

    static char[][] a;
    static boolean[][] vis;
    static int[][] xy = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int T, N, M, xMin = 0, yMin = 0, xMax = 0, yMax = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            N = sc.nextInt();
            M = sc.nextInt();
            sc.nextLine();
            a = new char[N][M];
            vis = new boolean[N][M];
            for (int j = 0; j < N; j++) {
                a[j] = sc.nextLine().toCharArray();
            }
            f();
        }
        sc.close();
    }

    static void f() {
        // 遍历查找玩具类型为0-9
        for (int i = 0; i < 10; i++) {
            // 坐标点最小位置
            xMin = N;
            yMin = M;
            // 坐标点最大位置
            xMax = 0;
            yMax = 0;
            char c = (char)(i + '0');
            // 是否查找到该编号类型的玩具
            boolean tag = false;
            // 对编号类型的玩具类型进行查找
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (!vis[j][k] && a[j][k] == c) {
                        tag = true;
                        vis[j][k] = true;
                        dfs(j, k);
                    }
                }
            }
            // 若该矩形内玩具没有全部一样
            if (tag && !isQuarter(c)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    static void dfs(int x, int y) {
        // 查找最大最小坐标值
        if (x < xMin)
            xMin = x;
        if (y < yMin)
            yMin = y;
        if (x > xMax)
            xMax = x;
        if (y > yMax)
            yMax = y;
        for (int i = 0; i < xy.length; i++) {
            int o = x + xy[i][0];
            int p = y + xy[i][1];
            // 深度遍历查找相同的玩具
            if (o >= 0 && o < N && p >= 0 && p < M && !vis[o][p] && a[x][y] == a[o][p]) {
                vis[o][p] = true;
                dfs(o, p);
            }
        }
    }

    // 判断是否是矩形
    static boolean isQuarter(char ch) {
        // 遍历矩形内的元素是否一样
        for (int i = xMin; i <= xMax; i++) {
            for (int j = yMin; j <= yMax; j++) {
                if (a[i][j] != ch) {
                    return false;
                }
            }
        }
        return true;
    }
}
