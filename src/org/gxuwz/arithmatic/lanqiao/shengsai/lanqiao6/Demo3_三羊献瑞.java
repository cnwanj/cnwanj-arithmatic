package org.gxuwz.arithmatic.lanqiao.shengsai.lanqiao6;

/**
 * 三羊献瑞
 *
 * 观察下面的加法算式：
 *
 *       祥 瑞 生 辉
 *   +   三 羊 献 瑞
 * -------------------
 *    三 羊 生 瑞 气
 *
 *       a b c d
 *   +   e f g b
 * -------------------
 *     e f c b h
 *
 * (如果有对齐问题，可以参看【图1.jpg】)
 *
 * 其中，相同的汉字代表相同的数字，不同的汉字代表不同的数字。
 *
 * 请你填写“三羊献瑞”所代表的4位数字（答案唯一），不要填写任何多余内容。
 *
 * 【思路】
 * 将0-9整数放入数组中，进行全排列，获取前8位进行逻辑判断是否符合“三样献瑞”规则
 *
 * 答案：9567+1085=10652
 */
public class Demo3_三羊献瑞 {

    // 前面8位表示 (祥 瑞 生 辉 + 三 羊 献 瑞) 这8个字
    private static int[] arr  = new int[]{1, 0, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] args) {
        f(0);
    }

    private static void f(int p) {
        // 每完成一次全排列进行逻辑判断
        if (p == arr.length - 1) {
            if (arr[0] != 0 && arr[4] != 0) {
                // 祥 瑞 生 辉
                int a = arr[0] * 1000 + arr[1] * 100 + arr[2] * 10 + arr[3];
                // 三 羊 献 瑞
                int b = arr[4] * 1000 + arr[5] * 100 + arr[6] * 10 + arr[1];
                // 三 羊 生 瑞 气
                int c = arr[4] * 10000 + arr[5] * 1000 + arr[2] * 100 + arr[1] * 10 + arr[8];
                if (a + b == c) {
                    System.out.println(a + " + " + b + " = " + c);
                }
            }
            return;
        }

        // 进行全排列(遇到全排列的题都按以下这个模板写)
        for (int i = p; i < arr.length; i++) {
            swap(i, p);
            f(1 + p);
            swap(i, p);
        }
    }

    // 进行元素交换
    private static void swap(int n, int m) {
        int t = arr[n];
        arr[n] = arr[m];
        arr[m] = t;
    }
}
