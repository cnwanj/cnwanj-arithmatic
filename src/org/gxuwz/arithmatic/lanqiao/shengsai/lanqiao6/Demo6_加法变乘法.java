package org.gxuwz.arithmatic.lanqiao.shengsai.lanqiao6;

/**
 * 加法变乘法
 *
 * 我们都知道：1+2+3+ ... + 49 = 1225
 * 现在要求你把其中两个不相邻的加号变成乘号，使得结果为2015
 *
 * 比如：
 * 1+2+3+...+10*11+12+...+27*28+29+...+49 = 2015
 * 就是符合要求的答案。
 *
 * 请你寻找另外一个可能的答案，并把位置靠前的那个乘号左边的数字提交（对于示例，就是提交10）。
 *
 * 注意：需要你提交的是一个整数，不要填写任何多余的内容。
 *
 * 答案：（16）
 * 10 11 27 28
 * 16 17 24 25
 */
public class Demo6_加法变乘法 {

    // 网上的
    public static void main(String[] args) {
        int[] a = new int[49];
        for (int i = 1; i < 50; i++) {
            a[i - 1] = i;
        }

        int r = 0, s = 0;
        for (int i = 0; i < a.length - 1; i++) {
            s = a[i] * a[i + 1];
            r = i + 2;
            while (r < a.length - 1) {
                s += a[r] * a[r + 1];
                for (int j = 0; j < a.length; j++) {
                    s += a[j];
                }
                s = s - (a[i] + a[i + 1] + a[r] + a[r + 1]);
                if (s == 2015) {
                    System.out.println(a[i] + " " + a[i + 1] + " " + a[r] + " " + a[r + 1]);
                }
                s = a[i] * a[i + 1];
                r++;
            }
            s = 0;
        }
    }

    // 自己写的
    static void f() {
        int[] arr = new int[49];
        // s：1-49总和
        int s = 0, left, right;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
            s += i + 1;
        }

        for (int i = 0; i < arr.length - 2; i++) {
            // 保存左边两数相乘减去两数相加
            left = arr[i] * arr[i + 1] - (arr[i] + arr[i + 1]);

            for (int j = i + 2; j < arr.length - 1; j++) {
                // 保存右边两数相乘减去两数相加
                right = arr[j] * arr[j + 1] - (arr[j] + arr[j + 1]);

                // 最终总和 - 左相乘(减去左相加) + 右相乘(减去右相加)
                int sum = s + left + right;
                if (sum == 2015) {
                    System.out.println(arr[i]);
                }
            }
        }
    }
}
















