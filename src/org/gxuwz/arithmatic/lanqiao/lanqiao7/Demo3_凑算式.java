package org.gxuwz.arithmatic.lanqiao.lanqiao7;

import java.util.Arrays;

/*

凑算式

     B      DEF
A + --- + ------- = 10
     C      GHI

（如果显示有问题，可以参见【图1.jpg】）


这个算式中A~I代表1~9的数字，不同的字母代表不同的数字。

比如：
6+8/3+952/714 就是一种解法，
5+3/1+972/486 是另一种解法。

这个算式一共有多少种解法？

注意：你提交应该是个整数，不要填写任何多余的内容或说明性文字。

 */
public class Demo3_凑算式 {

    static int s = 0;

    public static void main(String[] args) {
        // , 4, 5, 6, 7, 8, 9
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        f(arr, 0);
        System.out.println(s);
    }

    static void f(int[] arr, int p) {
        if (p == arr.length - 1) {
            //     B      DEF
            //A + --- + ------- = 10
            //     C      GHI
            int DEF = arr[3] * 100 + arr[4] * 10 + arr[5];
            int GHI = arr[6] * 100 + arr[7] * 10 + arr[8];
            double sum = arr[0] + arr[1] * 1.0/arr[2] + DEF * 1.0/GHI;
            if (sum == 10.0) {
                System.out.println(arr[0] + "+" + arr[1] + "/" + arr[2] + "+" + DEF + "/" + GHI);
                s ++;
            }
            return;
        }
        for (int i = p; i < arr.length; i++) {
            // 交换
            swap(arr, i, p);
            f(arr, p + 1);
            swap(arr, i, p);
        }
    }

    // 交换
    static void swap(int[] arr, int i, int p) {
        int t = arr[i];
        arr[i] = arr[p];
        arr[p] = t;
    }
}
