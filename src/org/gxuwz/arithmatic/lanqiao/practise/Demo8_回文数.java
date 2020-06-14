package org.gxuwz.arithmatic.lanqiao.practise;

/**
 * 8、基础练习 回文数
 * 问题描述
 * 　　1221是一个非常特殊的数，它从左边读和从右边读是一样的，
 * 编程求所有这样的四位十进制数。
 * 输出格式
 * 　　按从小到大的顺序输出满足条件的四位十进制数。
 */
public class Demo8_回文数 {
    public static void f1() {
        int a, b, c, d;
        for (int i = 1000; i < 10000; i++) {
            a = i % 100;
            b = i / 100;
            c = a / 10 + a % 10 * 10;
            if (b == c) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        f1();
    }
}
