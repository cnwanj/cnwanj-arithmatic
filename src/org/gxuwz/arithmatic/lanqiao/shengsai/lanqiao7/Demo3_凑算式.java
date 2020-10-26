package org.gxuwz.arithmatic.lanqiao.shengsai.lanqiao7;

/**
 * 凑算式
 *
 *      B      DEF
 * A + --- + ------- = 10
 *      C      GHI
 *
 * （如果显示有问题，可以参见【图1.jpg】）
 *
 * 这个算式中A~I代表1~9的数字，不同的字母代表不同的数字。
 *
 * 比如：
 * 6+8/3+952/714 就是一种解法，
 * 5+3/1+972/486 是另一种解法。
 *
 * 这个算式一共有多少种解法？
 *
 * 注意：你提交应该是个整数，不要填写任何多余的内容或说明性文字。
 *
 * 【思路】
 * 1-9进行全排列，每完成一次全排列进行逻辑判断
 *
 * 【答案】
 * 29
 */
public class Demo3_凑算式 {

    private static double[] arr;
    private static int count;

    public static void main(String[] args) {
        arr = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        f(0);
        System.out.println(count);
    }

    private static void f(int p) {
        // 每完成一次全排列进行判断
        if (p == arr.length - 1) {
            double a = arr[0];
            double b = arr[1] / arr[2];
            double c = (arr[3] * 100 + arr[4] * 10 + arr[5]) / (arr[6] * 100 + arr[7] * 10 + arr[8]);
            if (a + b + c == 10) {
                count ++;
            }
            return;
        }
        // 全排列
        for (int i = p; i < arr.length; i++) {
            swap(i, p);
            f(p + 1);
            swap(i, p);
        }
    }

    // 交换
    private static void swap(int n, int m) {
        double t = arr[n];
        arr[n] = arr[m];
        arr[m] = t;
    }
}
