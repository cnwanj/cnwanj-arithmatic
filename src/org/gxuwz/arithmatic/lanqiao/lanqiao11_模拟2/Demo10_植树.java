package org.gxuwz.arithmatic.lanqiao.lanqiao11_模拟2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 *
 * 【问题描述】
 * 小明和朋友们一起去郊外植树，他们带了一些在自己实验室精心研究出的小树苗。
 * 小明和朋友们一共有 n 个人，他们经过精心挑选，在一块空地上每个人挑选了一个适合植树的位置，
 * 总共 n 个。他们准备把自己带的树苗都植下去。
 * 然而，他们遇到了一个困难：有的树苗比较大，而有的位置挨太近，导致两棵树植下去后会撞在一起。
 * 他们将树看成一个圆，圆心在他们找的位置上。如果两棵树对应的圆相交，这两棵树就不适合同时植下（相切不受影响），称为两棵树冲突。
 * 小明和朋友们决定先合计合计，只将其中的一部分树植下去，保证没有互相冲突的树。他们同时希望这些树所能覆盖的面积和（圆面积和）最大。
 * 【输入格式】
 * 输入的第一行包含一个整数 n ，表示人数，即准备植树的位置数。
 * 接下来 n 行，每行三个整数 x, y, r，表示一棵树在空地上的横、纵坐标和半径。
 * 【输出格式】
 * 输出一行包含一个整数，表示在不冲突下可以植树的面积和。由于每棵树的面积都是圆周率的整数倍，请输出答案除以圆周率后的值（应当是一个整数）。
 * 【样例输入】
 * 6
 * 1 1 2
 * 1 4 2
 * 1 7 2
 * 4 1 2
 * 4 4 2
 * 4 7 2
 * 【样例输出】
 * 12
 * 【评测用例规模与约定】
 * 对于 30% 的评测用例，1 &lt;= n &lt;= 10；
 * 对于 60% 的评测用例，1 &lt;= n &lt;= 20；
 * 对于所有评测用例，1 &lt;= n &lt;= 30，0 &lt;= x, y &lt;= 1000，1 &lt;= r &lt;= 1000。
 *
 * @author: 韦永恒
 * @date: 2020-09-09 12:38:44
 */
public class Demo10_植树 {

    private static int n = 0, count = 0;
    private static int[][] arr;

    public static void main(String[] args) {
//        double r = 2;
//        double x1 = 1, y1 = 1;
//        double x2 = 4, y2 = 4;
//        double s = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
//        System.out.println(Math.sqrt(s) >= r * r);

        double[][] a = {{1,1,2}, {1,4,2}, {1,7,2}};

        for (int i = 0; i < a.length - 1; i ++) {
            double sum = (a[i][0] - a[i + 1][0]) * (a[i][0] - a[i + 1][0]) + (a[i][1] - a[i + 1][1]) * (a[i][1] - a[i + 1][1]);
            System.out.println(Math.sqrt(sum));
        }

//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        arr = new int[n][3];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < 3; j++) {
//                arr[i][j] = sc.nextInt();
//            }
//        }
//        f(arr, 0);
    }

    static void sys() {
        System.out.print("{");
        for (int i = 0; i < n; i++) {
            System.out.print("[");
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("],");
        }
        System.out.print("}==");
    }

    static void f(int[][] arr, int p) {
        if (p == arr.length - 1) {
            count ++;
            sys();
            return;
        }

        for (int i = p; i < arr.length; i++) {
            swap(arr, i, p);
            f(arr, p + 1);
            swap(arr, i, p);
        }
    }

    static void swap(int[][] arr, int i, int p) {
        int[] t = arr[i];
        arr[i] = arr[p];
        arr[p] = t;
    }
}
