package org.gxuwz.arithmatic.lanqiao.lanqiao7;

import java.util.Arrays;

/*

方格填数

如下的10个格子
    +---+---+---+
    | 0 | 1 | 2 |
+---+---+---+---+
| 3 | 4 | 5 | 6 |
+---+---+---+---+
| 7 | 8 | 9 |
+---+---+---+

（如果显示有问题，也可以参看【图1.jpg】）

填入0~9的数字。要求：连续的两个数字不能相邻。
（左右、上下、对角都算相邻）

一共有多少种可能的填数方案？

请填写表示方案数目的整数。
注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。
 */
public class Demo6_方格填数 {

    static int count = 0;

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        // 全排列处理
        f(arr, 0);
        System.out.println(count);
    }

    static void f(int[] arr, int k) {
        if (k == arr.length) {
            // 判断是否连续
            if (check(arr)) {
                count++;
                System.out.println(Arrays.toString(arr));
            }
            return;
        }
        for (int i = k; i < arr.length; i++) {
            // 数组之间两数进行交换
            swap(arr, i, k);
            f(arr, k + 1);
            // 交换回来，避免重复
            swap(arr, i, k);
        }
    }

    static void swap(int[] arr, int i, int k) {
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
    static boolean check(int[] arr) {
        boolean tag = true;
        if (c(arr[0], arr[1]) || c(arr[0], arr[4]) || c(arr[0], arr[5]) || c(arr[0], arr[3]))
            tag = false;
        else if (arr[1] + 1 == arr[0] || arr[1] + 1 == arr[2] || arr[1] + 1 == arr[5] || arr[1] + 1 == arr[4] || arr[1] + 1 == arr[6])
            tag = false;
        else if (arr[2] + 1 == arr[1] || arr[2] + 1 == arr[6] || arr[2] + 1 == arr[5])
            tag = false;
        else if (arr[3] + 1 == arr[4] || arr[3] + 1 == arr[7] || arr[3] + 1 == arr[0] || arr[3] + 1 == arr[8])
            tag = false;
        else if (arr[4] + 1 == arr[3] || arr[4] + 1 == arr[0] || arr[4] + 1 == arr[5] || arr[4] + 1 == arr[8] || arr[4] + 1 == arr[1] || arr[4] + 1 == arr[7] || arr[4] + 1 == arr[9])
            tag = false;
        else if (arr[5] + 1 == arr[4] || arr[5] + 1 == arr[1] || arr[5] + 1 == arr[6] || arr[5] + 1 == arr[9] || arr[5] + 1 == arr[0] || arr[5] + 1 == arr[2] || arr[5] + 1 == arr[8])
            tag = false;
        else if (arr[6] + 1 == arr[5] || arr[6] + 1 == arr[2] || arr[6] + 1 == arr[1] || arr[6] + 1 == arr[9])
            tag = false;
        else if (arr[7] + 1 == arr[3] || arr[7] + 1 == arr[8] || arr[7] + 1 == arr[4])
            tag = false;
        else if (arr[8] + 1 == arr[7] || arr[8] + 1 == arr[4] || arr[8] + 1 == arr[9] || arr[8] + 1 == arr[3] || arr[8] + 1 == arr[5])
            tag = false;
        else if (arr[9] + 1 == arr[4] || arr[9] + 1 == arr[5] || arr[9] + 1 == arr[6] || arr[9] + 1 == arr[8])
            tag = false;
        return tag;
    }

    static boolean c(int a, int b) {
        if (a + 1 == b)
            return true;
        return false;
    }
}
