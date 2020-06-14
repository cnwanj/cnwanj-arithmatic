package org.gxuwz.arithmatic.lanqiao.dasai.algo;

import java.util.Scanner;

/**
 * 试题 算法训练 景点游览
 * <p>
 * 资源限制
 * 时间限制：1.0s   内存限制：256.0MB
 * 问题描述
 * 　　小明来到一个景区游玩，但是他的时间有限，没办法逛遍所有的景点，
 * 所以他从网上下载了每个景点的评分，他希望能够使游览的景点的评分总和最高，于是他希望你帮他对于N个景点排下序。
 * 输入格式
 * 　　输入的第一行包含一个正整数N，表示N个景点。
 * 　　第二行有N个正整数，表示每个景点的评分值。
 * 输出格式
 * 　　输出一行，包含N个正整数，表示N个景点的评分从大到小的排列
 * 样例输入
 * 4
 * 3 2 4 1
 * 样例输出
 * 4 3 2 1
 * 数据规模和约定
 * 　　N<=1000,每个景点的评分<=10000。
 */
public class Demo3_景点游览 {

    public static void f(int[] arr) {
        boolean flag = false;
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (flag)
                flag = false;
            else
                break;
        }
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        f(arr);
    }
}
