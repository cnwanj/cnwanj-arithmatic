package org.gxuwz.arithmatic.lanqiao.practise;

/**
 * 6、基础练习 杨辉三角形
 * 问题描述
 * 杨辉三角形又称Pascal三角形，它的第i+1行是(a+b)i的展开式的系数。
 * 它的一个重要性质是：三角形中的每个数字等于它两肩上的数字相加。
 * 下面给出了杨辉三角形的前4行：
 * <p>
 * 1
 * 1 1
 * 1 2 1
 * 1 3 3 1
 * <p>
 * 给出n，输出它的前n行。
 * 输入格式
 * 输入包含一个数n。
 * 输出格式
 * 输出杨辉三角形的前n行。每一行从这一行的第一个数开始依次输出，中间使用一个空格分隔。请不要在前面输出多余的空格。
 * 样例输入
 * 5
 * 样例输出
 * 1
 * 1 1
 * 1 2 1
 * 1 3 3 1
 * 1 4 6 4 1
 * 数据规模与约定
 * 1 <= n <= 34。
 */
public class Demo6_杨辉三角形 {
    public static void f1(int n) {
        int[][] arr = new int[n][];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                if (i == 0 || j == 0 || i == j) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        f1(5);
    }
}
