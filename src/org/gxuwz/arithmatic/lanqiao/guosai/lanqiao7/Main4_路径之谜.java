package org.gxuwz.arithmatic.lanqiao.guosai.lanqiao7;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: vovhh
 * @Date: 2020-10-28 09:30:43
 * @Description:
 *
 * 路径之谜
 *
 * 小明冒充X星球的骑士，进入了一个奇怪的城堡。
 *
 * 城堡里边什么都没有，只有方形石头铺成的地面。
 *
 * 假设城堡地面是 n x n 个方格。【如图1.png】所示。
 *
 * 按习俗，骑士要从西北角走到东南角。
 *
 * 可以横向或纵向移动，但不能斜着走，也不能跳跃。
 *
 * 每走到一个新方格，就要向正北方和正西方各射一箭。
 *
 * （城堡的西墙和北墙内各有 n 个靶子）
 *
 * 同一个方格只允许经过一次。但不必做完所有的方格。
 *
 * 如果只给出靶子上箭的数目，你能推断出骑士的行走路线吗？
 *
 * 有时是可以的，比如图1.png中的例子。
 *
 * 本题的要求就是已知箭靶数字，求骑士的行走路径（测试数据保证路径唯一）
 *
 * 输入：
 * 第一行一个整数N(0<N<20)，表示地面有 N x N 个方格
 * 第二行N个整数，空格分开，表示北边的箭靶上的数字（自西向东）
 * 第三行N个整数，空格分开，表示西边的箭靶上的数字（自北向南）
 *
 * 输出：
 * 一行若干个整数，表示骑士路径。
 *
 * 为了方便表示，我们约定每个小格子用一个数字代表，从西北角开始编号: 0,1,2,3....
 * 比如，图1.png中的方块编号为：
 *
 * 0  1  2  3
 * 4  5  6  7
 * 8  9  10 11
 * 12 13 14 15
 *
 * 示例：
 * 用户输入：
 * 4
 * 2 4 3 4
 * 4 3 3 3
 *
 * 程序应该输出：
 * 0 4 5 1 2 3 7 11 10 9 13 14 15
 *
 * 资源约定：
 * 峰值内存消耗 < 256M
 * CPU消耗  < 1000ms
 *
 *
 * 请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。
 *
 * 所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
 * 注意：不要使用package语句。不要使用jdk1.7及以上版本的特性。
 * 注意：主类的名字必须是：Main，否则按无效代码处理。
 *
 * 【思路】
 * 深度遍历dfs
 * 每走一步就将北边和西边的靶子上的箭数-1
 * 在回溯的时候将靶子上的箭数+1，
 * 每走到终点的时候进行判断是否已经射完靶子上的箭
 *
 */
public class Main4_路径之谜 {

    // 地图数组、靶子数组
    static int[][] arr, arr1, path, xy = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static boolean[][] vis;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();
        // 地图数组
        arr = new int[N][N];
        // 靶子数组
        arr1 = new int[2][N];
        // 记录是否经过
        vis = new boolean[N][N];
        // 记录经过的路径
        path = new int[N][N];
        int c = 0;
        for (int i = 0; i < arr1.length; i++) {
            String[] s = sc.nextLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr1[i][j] = Integer.parseInt(s[j]);
            }
        }
        sc.close();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = c ++;
            }
        }
        f();
    }

    static void f() {
        // 从起点开始，且靶子箭的数目大于0
        if (arr1[0][0] > 0 && arr1[1][0] > 0) {
            // 标记已经过
            vis[0][0] = true;
            // 北方向靶子数-1
            arr1[0][0] -= 1;
            // 西方向靶子数-1
            arr1[1][0] -= 1;
            // 深度遍历
            dfs(0, 0);
        }
    }

    static void dfs(int x, int y) {
        // 若走到终点
        if (x == N - 1 && y == N - 1) {
            // 判断靶子是否射完
            if (check()) {
                for (int i = 0; i < N; i++) {
                    System.out.println(Arrays.toString(path[i]));
                }
                System.out.print(arr[0][0] + " ");
                // 深度遍历进行打印
                dfs1(0, 0);
            }
            return;
        }
        // 上下左右走
        for (int i = 0; i < xy.length; i++) {
            int o = x + xy[i][0];
            int p = y + xy[i][1];
            // 若没有越界 且 未经过 且 靶子箭的数量不为0
            if (o >= 0 && o < N && p >= 0 && p < N && !vis[o][p] && arr1[0][p] > 0 && arr1[1][o] > 0) {
                arr1[0][p] -= 1;
                arr1[1][o] -= 1;
                vis[o][p] = true;
                // 记录经过的路径
                path[o][p] += path[x][y] + 1;
                dfs(o, p);
                arr1[0][p] += 1;
                arr1[1][o] += 1;
                vis[o][p] = false;
                // 回溯时将当前路径置为0
                path[o][p] = 0;
            }
        }
    }

    static boolean check() {
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                if (arr1[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    static void dfs1(int x, int y) {
        for (int i = 0; i < xy.length; i++) {
            int o = x + xy[i][0];
            int p = y + xy[i][1];
            if (o >= 0 && o < N && p >= 0 && p < N && path[o][p] == path[x][y] + 1) {
                System.out.print(arr[o][p] + " ");
                dfs1(o, p);
            }
        }
    }
}
