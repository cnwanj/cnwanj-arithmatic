package org.gxuwz.arithmatic.lanqiao.dasai.algo;

import java.util.Scanner;

/**
 * 试题 算法训练 RP大冒险
 *
 * 资源限制
 * 时间限制：200ms   内存限制：64.0MB
 * 问题描述
 * 　　请尽情使用各种各样的函数来测试你的RP吧~~~
 * 输入格式
 * 　　一个数N表示测点编号。
 * 输出格式
 * 　　一个0~9的数。
 * 样例输入
 * 0
 * 样例输出
 * X
 * {当且仅当输出仅有一个数X且X为0~9的数时你的得分不为零，此时你的得分为系统根据你的输出而计算出的你本次的RP。}
 * 数据规模和约定
 * 　　测点编号为1~10，且stdans随机。
 * 　　究竟使用怎样的函数才能获得较高的RP呢？指数函数？幂函数？斐波那契数？圆周曲线的导数函数？好想尝试一下哦~
 */
public class Demo2_RP大冒险 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n > 10)
            n %= 10;
        System.out.println((int)(Math.random()*n));
    }
}
