package org.gxuwz.arithmatic.lanqiao.lanqiao11_模拟2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 *
 * 【问题描述】
 *  对于一个 n 行 m 列的表格，我们可以使用螺旋的方式给表格依次填上正整数，我们称填好的表格为一个螺旋矩阵。
 *  例如，一个 4 行 5 列的螺旋矩阵如下：
 *  1  2  3  4  5
 *  14 15 16 17 6
 *  13 20 19 18 7
 *  12 11 10 9  8
 * 【输入格式】
 *  输入的第一行包含两个整数 n, m，分别表示螺旋矩阵的行数和列数。
 *  第二行包含两个整数 r, c，表示要求的行号和列号。
 * 【输出格式】
 *  输出一个整数，表示螺旋矩阵中第 r 行第 c 列的元素的值。
 * 【样例输入】
 *  4 5
 *  2 2
 * 【样例输出】
 * 15
 * 【评测用例规模与约定】
 * 对于 30% 的评测用例，2 &lt;= n, m &lt;= 20。
 * 对于 70% 的评测用例，2 &lt;= n, m &lt;= 100。
 * 对于所有评测用例，2 &lt;= n, m &lt;= 1000，1 &lt;= r &lt;= n，1 &lt;= c &lt;= m。
 *
 * @author: 韦永恒
 * @date: 2020-09-06 21:37:11
 */
public class Demo7_螺旋 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        a(arr, n, m);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

    }

    static void a(int[][] arr, int n, int m) {
        final int r = 0, d = 1, l = 2, u = 3;
        int cir = 1, x = 0, y = 0, value = 0, dir = r;

        while (true) {
            value ++;
            arr[x][y] = value;
            switch(dir) {
                case r:
                    if (y < m - cir) {
                        // 向右走
                        y ++;
                    } else {
                        // 向下走
                        dir = d;
                        x ++;
                    }
                    break;
                case d:
                    if (x < n - cir) {
                        // 向下走
                        x ++;

                    } else {
                        // 向左走
                        dir = l;
                        y --;
                    }
                    break;
                case l:
                    if (y > cir - 1) {
                        // 向左走
                        y --;
                    } else {
                        // 向上走
                        dir = u;
                        x --;
                    }
                    break;
                case u:
                    if (x > cir) {
                        x --;
                    } else {
                        // 一圈结束
                        cir ++;
                        dir = r;
                        y ++;
                    }
                    break;
            }
            if (value >= n * m) {
                break;
            }
        }
    }

    static void f(int[][] arr, int n, int m) {
        // 控制走向
        final int r = 0, d = 1, l = 2, u = 3;
        // 填充到数组的值
        int value = 0;
        // 数组的坐标
        int x = 0, y = 0;
        int dir = r;
        // 表示第几圈
        int cir = 1;
        while(true) {
            value ++;
            arr[x][y] = value;
            switch(dir) {
                case r:
                    if (y < m - cir) {
                        // 若没有超出范围，右移
                        y ++;
                    } else {
                        // 向下移动
                        dir = d;
                        x ++;
                    }
                    break;
                case d:
                    if (x < n - cir) {
                        x ++;
                    } else {
                        // 左移
                        dir = l;
                        y --;
                    }
                    break;
                case l:
                    if (y > cir - 1) {
                        y --;
                    } else {
                        dir = u;
                        x --;
                    }
                    break;
                case u:
                    if (x > cir) {
                        x --;
                    } else {
                        // 完成一圈
                        cir ++;
                        dir = r;
                        y ++;
                    }
                    break;
            }
            // 退出循环
            if (value >= n * m) {
                break;
            }
        }
    }
}
