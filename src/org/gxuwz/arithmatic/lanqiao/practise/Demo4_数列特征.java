package org.gxuwz.arithmatic.lanqiao.practise;

import java.util.Scanner;

/**
 * 4、 基础练习 数列特征
 * 问题描述
 * 给出n个数，找出这n个数的最大值，最小值，和。
 * 输入格式
 * 第一行为整数n，表示数的个数。
 * 第二行有n个数，为给定的n个数，每个数的绝对值都小于10000。
 * 输出格式
 * 输出三行，每行一个整数。第一行表示这些数中的最大值，第二行表示这些数中的最小值，第三行表示这些数的和。
 * 样例输入
 * 5
 * 1 3 -2 4 5
 * 样例输出
 * 5
 * -2
 * 3
 * 数据规模与约定
 * 1 <= n <= 10000。
 */
public class Demo4_数列特征 {
    public static void f1(int[] arr) {
        int sum = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++) {         // 控制对比次数
            for (int j = i + 1; j < len; j++) {    // 相邻两元素比较
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            sum += arr[i];
        }
        System.out.println("最小：" + arr[0]);
        System.out.println("最大：" + arr[len - 1]);
        System.out.println("和：" + sum);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        String s = input.nextLine();
        String[] str = s.split(" ");
        int[] ins = new int[n];
        for (int i = 0; i < str.length; i++) {
            ins[i] = Integer.parseInt(str[i]);
        }
        f1(ins);
    }
}
