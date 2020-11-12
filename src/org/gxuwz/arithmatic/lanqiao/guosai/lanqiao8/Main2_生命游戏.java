package org.gxuwz.arithmatic.lanqiao.guosai.lanqiao8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: vovhh
 * @Date: 2020-10-30 19:14:39
 * @Description:
 *
 * 标题：生命游戏
 *
 * 康威生命游戏是英国数学家约翰·何顿·康威在1970年发明的细胞自动机。
 * 这个游戏在一个无限大的2D网格上进行。
 *
 * 初始时，每个小方格中居住着一个活着或死了的细胞。
 * 下一时刻每个细胞的状态都由它周围八个格子的细胞状态决定。
 *
 * 具体来说：
 *
 * 1. 当前细胞为存活状态时，当周围低于2个（不包含2个）存活细胞时，该细胞变成死亡状态。（模拟生命数量稀少）
 * 2. 当前细胞为存活状态时，当周围有2个或3个存活细胞时，该细胞保持原样。
 * 3. 当前细胞为存活状态时，当周围有3个以上的存活细胞时，该细胞变成死亡状态。（模拟生命数量过多）
 * 4. 当前细胞为死亡状态时，当周围有3个存活细胞时，该细胞变成存活状态。（模拟繁殖）
 *
 * 当前代所有细胞同时被以上规则处理后, 可以得到下一代细胞图。按规则继续处理这一代的细胞图，可以得到再下一代的细胞图，周而复始。
 *
 * 例如假设初始是:(X代表活细胞，.代表死细胞)
 * .....
 * .....
 * .XXX.
 * .....
 *
 * 下一代会变为:
 * .....
 * ..X..
 * ..X..
 * ..X..
 * .....
 *
 * 康威生命游戏中会出现一些有趣的模式。例如稳定不变的模式：
 *
 * ....
 * .XX.
 * .XX.
 * ....
 *
 * 还有会循环的模式：
 *
 * ......        ......       ......
 * .XX...        .XX...       .XX...
 * .XX...        .X....       .XX...
 * ...XX.   ->   ....X.  ->   ...XX.
 * ...XX.        ...XX.       ...XX.
 * ......        ......       ......
 *
 *
 * 本题中我们要讨论的是一个非常特殊的模式，被称作"Gosper glider gun"：
 *
 * 11 38
 * ......................................
 * .........................X............
 * .......................X.X............
 * .............XX......XX............XX.
 * ............X...X....XX............XX.
 * .XX........X.....X...XX...............
 * .XX........X...X.XX....X.X............
 * ...........X.....X.......X............
 * ............X...X.....................
 * .............XX.......................
 * ......................................
 *
 * 假设以上初始状态是第0代，请问第1000000000(十亿)代一共有多少活着的细胞？
 *
 * 注意：我们假定细胞机在无限的2D网格上推演，并非只有题目中画出的那点空间。
 * 当然，对于遥远的位置，其初始状态一概为死细胞。
 *
 * 注意：需要提交的是一个整数，不要填写多余内容。
 */
public class Main2_生命游戏 {

    static int[][] xy = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
    static char[][] a, a1;
    static int N, M;
    static boolean[][] vis;
    static List<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        a = new char[N][M];
        a1 = new char[N][M];

        vis = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextLine().toCharArray();
        }
        sc.close();

        f(100);
        getList();
    }

    static void f(int p) {
        init();
        if (p == 0) {
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dfs(i, j);
            }
        }
        // 统计个数
        getSum();
        if (p == 77 || p == 78 || p == 79) {
            // 打印
            print();
            System.out.println();
        }
        setA();
        // 赋值
        f(p - 1);
    }

    static void dfs(int x, int y) {
        // 记录周围存活细胞个数
        int count = 0;
        for (int i = 0; i < xy.length; i++) {
            int o = x + xy[i][0];
            int p = y + xy[i][1];
            if (o >= 0 && o < N && p >= 0 && p < M && a[o][p] == 'X') {
                count ++;
            }
        }
        if (count < 2 || count > 3) {   // 该细胞变死亡状态
            a1[x][y] = '.';
        } else if (count == 3) {        //
            a1[x][y] = 'X';
        } else if (count == 2) {
            a1[x][y] = a[x][y];
        }
    }

    static void init() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                a1[i][j] = '.';
            }
        }
    }

    static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(a1[i][j]);
            }
            System.out.println();
        }
    }

    static void setA() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                a[i][j] = a1[i][j];
            }
        }
    }

    static void getSum() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (a1[i][j] == 'X') {
                    count ++;
                }
            }
        }
        list.add(count);
        System.out.println(count);
    }

    static void getList() {
        for (int i = 0; i < list.size() - 1; i++) {
            System.out.print(list.get(i + 1) - list.get(i) + " ");
        }
    }
}

class Cell {
    int x;
    int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        Cell cell = (Cell)obj;
        return this.x == cell.x && this.y == cell.y;
    }
}

class Main2_生命游戏1 {

    private static int[][] xy = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
    // liveCell 存活细胞、nextCell 下一代细胞
    private static List<Cell> liveCell = new ArrayList<>(), nextCell;
    // 记录每一代存活的细胞数
    private static List<Integer> cellNum = new ArrayList<>();
    private static int N = 11, M = 38;

    /**
     * ......................................
     * .........................X............
     * .......................X.X............
     * .............XX......XX............XX.
     * ............X...X....XX............XX.
     * .XX........X.....X...XX...............
     * .XX........X...X.XX....X.X............
     * ...........X.....X.......X............
     * ............X...X.....................
     * .............XX.......................
     * ......................................
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 'X') {
                    // 存放存活的细胞
                    liveCell.add(new Cell(i, j));
                }
            }
        }
        sc.close();
        f();
    }

    public static void f() {
        // 记录第0代存活细胞数
        cellNum.add(liveCell.size());
        // i为遍历代数
        for (int i = 0; i < 100; i++) {
            // 初始化下一代
            nextCell = new ArrayList<>();
            // 遍历存活细胞
            for (int j = 0; j < liveCell.size(); j++) {
                df(j);
            }
            // 保存下一代存活细胞数
            cellNum.add(nextCell.size());
            liveCell = nextCell;
        }
        getNum();
    }

    public static void df(int index) {
        // 获取当前存活的细胞
        Cell cell = liveCell.get(index);
        // 记录四周存活细胞数
        int count = 0;
        // 四周遍历
        for (int i = 0; i < xy.length; i ++) {
            int o = cell.x + xy[i][0];
            int p = cell.y + xy[i][1];
            // 若四周的细胞存活
            if (liveCell.contains(new Cell(o, p))) {
                count ++;
            } else if (!nextCell.contains(new Cell(o, p))) {
                // 若四周细胞不存活，且不存在下一代中，就以这为起点继续进行四周查找
                int count1 = 0;
                for (int j = 0; j < xy.length; j++) {
                    int oo = o + xy[j][0];
                    int pp = p + xy[j][1];
                    // 记录这细胞的四周存活细胞数
                    if (liveCell.contains(new Cell(oo, pp))) {
                        count1 ++;
                    }
                }
                // 复活当前四周的细胞
                if (count1 == 3) {
                    nextCell.add(new Cell(o, p));
                }
            }
        }
        // 活细胞保留
        if (count == 2 || count == 3) {
            nextCell.add(cell);
        }
    }

    public static void getNum() {
        System.out.println(cellNum.get(0));
        for (int i = 0; i < cellNum.size() - 1; i++) {
            System.out.println(cellNum.get(i + 1) + " " + (cellNum.get(i + 1) - cellNum.get(i)));
        }
        // 得出规律，每经过30代就整体+5
        double dou = 1000000000;
        // 每30代一轮：33333333 * 5 + 48（48为第10个）
        int d = (int)dou / 30 * 5 + cellNum.get((int)dou % 30);
        System.out.println(d);
    }
}


