package org.gxuwz.arithmatic.lanqiao.guosai.lanqiao6;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: 韦永恒
 * @Date: 2020-10-26 20:32:49
 * @Description:
 *
 * 标题：穿越雷区
 *
 * X星的坦克战车很奇怪，它必须交替地穿越正能量辐射区和负能量辐射区才能保持正常运转，否则将报废。
 *
 * 某坦克需要从A区到B区去（A，B区本身是安全区，没有正能量或负能量特征），怎样走才能路径最短？
 *
 * 已知的地图是一个方阵，上面用字母标出了A，B区，其它区都标了正号或负号分别表示正负能量辐射区。
 * 例如：
 * A + - + -
 * - + - - +
 * - + + + -
 * + - + - +
 * B + - + -
 *
 * 坦克车只能水平或垂直方向上移动到相邻的区。
 *
 * 数据格式要求：
 *
 * 输入第一行是一个整数n，表示方阵的大小， 4<=n<100
 * 接下来是n行，每行有n个数据，可能是A，B，+，-中的某一个，中间用空格分开。
 * A，B都只出现一次。
 *
 * 要求输出一个整数，表示坦克从A区到B区的最少移动步数。
 * 如果没有方案，则输出-1
 *
 * 例如：
 * 用户输入：
 * 5
 * A + - + -
 * - + - - +
 * - + + + -
 * + - + - +
 * B + - + -
 *
 * 则程序应该输出：
 * 10
 *
 * 资源约定：
 * 峰值内存消耗（含虚拟机） < 512M
 * CPU消耗  < 2000ms
 *
 *
 * 请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。
 *
 * 所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
 * 注意：不要使用package语句。不要使用jdk1.7及以上版本的特性。
 * 注意：主类的名字必须是：Main，否则按无效代码处理。
 *
 */
public class Main4_穿越雷区 {

    static char[][] arr;
    static int[][] xy = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static boolean[][] vis;
    static int n = 0, count = 0, min;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        // 初始化地图
        arr = new char[n][n];
        // 记录踩过的轨迹
        vis = new boolean[n][n];
        // 最少移动步数
        min = n * n;

        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = s[j].charAt(0);
            }
        }
        sc.close();
        f();
        System.out.println(min == n * n ? -1 : min);
    }

    static void f() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 'A' && !vis[i][j]) {
                    vis[i][j] = true;
                    dfs(i, j);
                    return;
                }
            }
        }
    }

    static void dfs(int x, int y) {
        // 四周探测
        for (int i = 0; i < xy.length; i++) {
            int o = x + xy[i][0];
            int p = y + xy[i][1];
            // 若没有越界且没有走过
            if (o >= 0 && o < n && p >= 0 && p < n && !vis[o][p]) {
                // 若没有到达终点B继续递归
                if (arr[o][p] != 'B') {
                    // 若当前坐标为起点A
                    if (arr[x][y] == 'A') {
                        if (arr[o][p] == '-' || arr[o][p] == '+') {
                            dg(o, p);
                        }
                    } else if (arr[x][y] == '-' && arr[o][p] == '+') {
                        dg(o, p);
                    } else if (arr[x][y] == '+' && arr[o][p] == '-') {
                        dg(o, p);
                    }
                } else {
                    // 若到达终点B
                    if (count < min) {
                        min = count;
                        // 将最后一步终点B加上
                        min ++;
                    }
                }
            }
        }
    }

    static void dg(int o, int p) {
        // 每走一步加一
        count ++;
        // 标记已走过
        vis[o][p] = true;
        dfs(o, p);
        // 回溯减一
        count --;
        // 标记未走过
        vis[o][p] = false;
    }
}
