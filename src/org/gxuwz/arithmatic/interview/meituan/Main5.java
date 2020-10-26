package org.gxuwz.arithmatic.interview.meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 矩阵游戏
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 小美有一个2×2的矩阵，矩阵左上角、右上角、左下角、右下角的数字分别为0、A、B、C。
 *
 * 小美觉得该矩阵不够大，她按如下方法扩展该矩阵：
 *
 * 将2×2的矩阵扩展为4×4的矩阵，4×4的矩阵被分为左上角、右上角、左下角、右下角这4个2×2的矩阵，
 *
 * 其中左上角为原2×2的矩阵，右上角为原2×2的矩阵每个位置上的数加上A，左下角为原2×2的矩阵每个位置上的数加上B，右下角为原2×2的矩阵每个位置上的数加上C；
 *
 * 将4×4的矩阵扩展为8×8的矩阵，8×8的矩阵被分为左上角、右上角、左下角、右下角这4个4×4的矩阵，
 *
 * 其中左上角为原4×4的矩阵，右上角为原4×4的矩阵每个位置上的数加上A，左下角为原4×4的矩阵每个位置上的数加上B，右下角为原4×4的矩阵每个位置上的数加上C；
 *
 * ……
 *
 * 经过不断扩展，小美可以得到一个无穷大的矩阵。小美打算用该矩阵和小团玩游戏，即对小团进行N次提问，每次给出正整数X、Y，并问小团矩阵上第X行第Y列上的数是多少，由于该数可能很大，只要求小团回答该数除以10^9后的余数。
 *
 * 输入描述
 * 第一行输入四个由空格隔开的整数A、B、C和N（0<=A,B,C<10^9、1<=N<=10^5）。
 *
 * 接下来N行，每行输入两个由空格隔开的整数X和Y（1<=X,Y<=10^9）。
 *
 * 输出描述
 * 输出N行，每行输出一个整数，第i行输出第i次提问的答案，即矩阵对应位置上的数除以10^9后的余数。
 *
 * 样例输入
 * 1 2 3 5
 * 3 3
 * 5 6
 * 6 1
 * 8 3
 * 8 8
 * 样例输出
 * 3
 * 4
 * 4
 * 7
 * 9
 *
 * 提示
 * 样例解释：
 * 扩展后的矩阵前8行和前8列如下：
 * 0 1 1 2 1 2 2 3
 * 2 3 3 4 3 4 4 5
 * 2 3 3 4 3 4 4 5
 * 4 5 5 6 5 6 6 7
 * 2 3 3 4 3 4 4 5
 * 4 5 5 6 5 6 6 7
 * 4 5 5 6 5 6 6 7
 * 6 7 7 8 7 8 8 9
 *
 * 0 1 1 2
 * 2 3 3 4
 * 2 3 3 4
 * 4 5 5 6
 */
public class Main5 {

    static int[][] arr, arr1, xy;
    static int n = 0;
    static int m = 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int N = sc.nextInt();
        sc.nextLine();
        arr = new int[N][2];
        int max = 0;
        for (int i = 0; i < N; i++) {
            String[] s = sc.nextLine().split(" ");
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }
        int n = 0;
        while(true) {
            n ++;
            if (Math.pow(2, n) > max) {
                n = (int)Math.pow(2, n);
                break;
            }
        }
        arr1 = new int[n][n];
        xy = new int[][]{{0, m - 1}, {m - 1, 0}, {m - 1, m - 1}};
        f(1, 0, 0);

        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(arr1[i]));
        }
    }

    static void f(int index, int x, int y) {
        if (x == m - 1 && y == m - 1) {
            index ++;
            xy = new int[][]{{0, m - 1}, {m - 1, 0}, {m - 1, m - 1}};
            m = (int)Math.pow(2, index);
        }
        for (int i = 0; i < xy.length; i++) {
            int o = x + xy[i][0];
            int p = y + xy[i][1];
            if (o <= n && p <= n) {
                if (i == 0) {
                    for (int j = 0; j < m; j++) {
                        for (int k = m - 1; k < 2 * m; k++) {
                            arr1[j][k] = arr1[o][p] + arr1[j][k - m];
                        }
                    }
                } else if (i == 1) {
                    for (int j = m - 1; j < 2 * m; j++) {
                        for (int k = 0; k < m - 1; k++) {
                            arr[j][k] = arr1[o][p] + arr1[j - m][k];
                        }
                    }
                } else if (i == 2) {
                    for (int j = m - 1; j < 2 * m; j++) {
                        for (int k = m - 1; k < 2 * m; k++) {
                            arr[j][k] = arr[o][p] + arr1[j - m][k - m];
                        }
                    }
                }
                f(index, o, p);
            }
        }
    }
}
