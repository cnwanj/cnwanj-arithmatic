package org.gxuwz.arithmatic.lanqiao.lanqiao5;

import java.util.Arrays;

/**
 * @description:
 *
 * 今有7对数字：两个1，两个2，两个3，...两个7，把它们排成一行。
 *
 * 要求，两个1间有1个其它数字，两个2间有2个其它数字，以此类推，两个7之间有7个其它数字。如下就是一个符合要求的排列：
 *
 * 17126425374635
 *
 * 当然，如果把它倒过来，也是符合要求的。
 *
 * 请你找出另一种符合要求的排列法，并且这个排列法是以74开头的。
 *
 * 注意：只填写这个14位的整数，不能填写任何多余的内容，比如说明注释等。
 *
 * 7, 4, 1, 5, 1, 6, 4, 3, 7, 5, 2, 3, 6, 2
 *
 * @author: 韦永恒
 * @date: 2020-09-25 12:03:16
 */
public class Demo4_7对数字 {

    static int[] arr = new int[]{7, 4, 0, 0, 0, 0, 4, 0, 7, 0, 0, 0, 0, 0};

    public static void main(String[] args) {
        f1(1);
    }

    static void f(int p) {
        if (p == 4) {
            p ++;
        }
        if (p >= 7) {
            System.out.println(Arrays.toString(arr));
        }
        // 遍历排列数组元素
        for (int i = 2; i < 13; i++) {
            if (i + p + 1 <= 13 && arr[i] == 0 && arr[i + p + 1] == 0) {
                // 将两边的元素赋值
                arr[i] = arr[i + p + 1] = p;
                // 递归并将下标往后移动一位
                f(p + 1);
                arr[i] = arr[i + p + 1] = 0;
            }
        }
    }

    static void f1(int p) {
        // 若元素为4，则跳过
        if (p == 4) {
            p ++;
        }
        // 若元素为7，则结束输出
        if (p == 7) {
            System.out.println(Arrays.toString(arr));
        }
        // 从下标为2开始，循环遍历数组元素
        for (int i = 2; i < arr.length; i ++) {
            // 若结束坐标在范围内
            if (i + p + 1 < 14 && arr[i] == 0 && arr[i + p + 1] == 0) {
                arr[i] = arr[i + p + 1] = p;
                // 递归循环进行全排列选择
                f1(1 + p);
                // 回退
                arr[i] = arr[i + p + 1] = 0;
            }
        }
    }
}
