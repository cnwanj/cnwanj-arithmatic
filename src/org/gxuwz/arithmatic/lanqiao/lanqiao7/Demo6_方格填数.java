package org.gxuwz.arithmatic.lanqiao.lanqiao7;

import java.util.Arrays;

/**
 * 方格填数
 *
 * 如下的10个格子
 *     +---+---+---+
 *     | 0 | 1 | 2 |
 * +---+---+---+---+
 * | 3 | 4 | 5 | 6 |
 * +---+---+---+---+
 * | 7 | 8 | 9 |
 * +---+---+---+
 *
 * （如果显示有问题，也可以参看【图1.jpg】）
 *
 * 填入0~9的数字。要求：连续的两个数字不能相邻。
 * （左右、上下、对角都算相邻）
 *
 * 一共有多少种可能的填数方案？
 *
 * 请填写表示方案数目的整数。
 * 注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。
 */
public class Demo6_方格填数 {

    private static int[] arr;
    private static int count;

    public static void main(String[] args) {
        arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        // 全排列处理
        f(0);
        System.out.println(count);
    }

    static void f(int k) {
        if (k == arr.length) {
            // 判断是否连续
            if (check()) {
                count++;
                System.out.println(Arrays.toString(arr));
            }
            return;
        }
        for (int i = k; i < arr.length; i++) {
            // 数组之间两数进行交换
            swap(i, k);
            f(k + 1);
            // 交换回来，避免重复
            swap(i, k);
        }
    }

    static void swap(int i, int k) {
        int t = arr[i];
        arr[i] = arr[k];
        arr[k] = t;
    }

    /*
     *     +---+---+---+
     *     | 0 | 1 | 2 |
     * +---+---+---+---+
     * | 3 | 4 | 5 | 6 |
     * +---+---+---+---+
     * | 7 | 8 | 9 |
     * +---+---+---+
     */
    static boolean check() {
        if (c(0, 1) || c(0, 3) || c(0, 4) || c(0, 5)) {
            return false;
        } else if (c(1, 0) || c(1, 2) || c(1, 4) || c(1, 5) || c(1, 6)) {
            return false;
        } else if (c(2, 1) || c(2, 5) || c(2, 6)) {
            return false;
        } else if (c(3, 0) || c(3, 4) || c(3, 8) || c(3, 7)) {
            return false;
        } else if (c(4, 0) || c(4, 1) || c(4, 3) || c(4, 5) || c(4, 7) || c(4, 8) || c(4, 9)) {
            return false;
        } else if (c(5, 0) || c(5, 1) || c(5, 2) || c(5, 4) || c(5, 6) || c(5, 8) || c(5, 9)) {
            return false;
        } else if (c(6, 1) || c(6, 2) || c(6, 5) || c(6, 9)) {
            return false;
        } else if (c(7, 3) || c(7, 4) || c(7, 8)) {
            return false;
        } else if (c(8, 3) || c(8, 4) || c(8, 5) || c(8, 7) || c(8, 9)) {
            return false;
        } else if (c(9, 4) || c(9, 5) || c(9, 6) || c(9, 8)) {
            return false;
        }
        return true;
    }

    static boolean c(int a, int b) {
        if (arr[a] + 1 == arr[b])
            return true;
        return false;
    }
}
