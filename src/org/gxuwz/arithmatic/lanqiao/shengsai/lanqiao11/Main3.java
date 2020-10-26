package org.gxuwz.arithmatic.lanqiao.shengsai.lanqiao11;

import java.util.Scanner;

/**
 *
 * 试题 C: 蛇形填数
 *
 * 如下图所示，小明用从 1 开始的正整数“蛇形”填充无限大的矩阵。
 1  2  6  7  15 16 28
 3  5  8  14 17 27
 4  9  13 18 26
 10 12 19 25
 11 20 24
 21 23
 22

 1 3 6 10 15 21 28
 1 2 3 4  5  6  7
 (1)
 容易看出矩阵第二行第二列中的数是 5。请你计算矩阵中第 20 行第 20 列
 的数是多少？

 */
public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), sum = 0;
        for (int i = 1; i <= n + n - 1; i++) {
            sum += i;
        }
        System.out.println(sum - (n - 1));
    }
}
