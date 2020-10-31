package org.gxuwz.arithmatic.lanqiao.guosai.lanqiao8;

import com.sun.org.apache.xml.internal.utils.StopParseException;

import java.util.Arrays;

/**
 * @Author: vovhh
 * @Date: 2020-10-28 13:58:45
 * @Description:
 *
 * 标题：平方十位数
 *
 * 由0~9这10个数字不重复、不遗漏，可以组成很多10位数字。
 * 这其中也有很多恰好是平方数（是某个数的平方）。
 *
 * 比如：1026753849，就是其中最小的一个平方数。
 *
 * 请你找出其中最大的一个平方数是多少？
 *
 * 注意：你需要提交的是一个10位数字，不要填写任何多余内容。
 *
 * 答案：9814072356
 */
public class Main1 {

    // 9, 8, 7, 6, 5, 4, 3, 2, 1, 0
    static int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    static double Max = 0;

    public static void main(String[] args) {
        f(0);
        System.out.println(String.format("%.0f", Max));
    }

    static void f(int p) {
        if (p == a.length) {
            if (check()) {
                return;
            }
        }
        for (int i = p; i < a.length; i++) {
            swap(i, p);
            f(1 + p);
            swap(i, p);
        }
    }

    static boolean check() {
        // 将数组转换为数字
        StringBuilder sum = new StringBuilder("");
        for (int i = 0; i < a.length; i++) {
            sum.append(a[i]);
        }
        double s = Double.parseDouble(sum.toString());
        double s1 = Math.sqrt(s);
        // 若相等说明为整数开方
        if (s1 == (int)s1) {
            if (s > Max) {
                Max = s;
            }
            return true;
        }
        return false;
    }

    static void swap(int i, int p) {
        int t = a[i];
        a[i] = a[p];
        a[p] = t;
    }
}
