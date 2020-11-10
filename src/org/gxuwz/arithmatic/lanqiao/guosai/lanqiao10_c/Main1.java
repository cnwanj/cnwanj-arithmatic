package org.gxuwz.arithmatic.lanqiao.guosai.lanqiao10_c;

/**
 * @Author: 韦永恒
 * @Date: 2020-10-28 13:58:01
 * @Description:
 *
 *
 * 题意: 求2019<X<Y ,使2019*2019,X*X,Y*Y组成等差数列且X+Y最小.
 * 结果: 7020
 *
 * 【题目】
 * 1、2019<X<Y
 * 2、2019^2, X^2, Y^2构成等差数列
 * 满足条件的X和Y可能有多种情况，请给出X+Y的值，并且令X+Y尽可能的小。
 *
 */
public class Main1 {
    public static void main(String[] args) {
        boolean tag = false;
        for (long i = 2020; i < 10000; i++) {
            long d = i * i - 2019 * 2019;
            for (long j = i + 1; j < 10001; j++) {
                long e = j * j - i * i;
                if (d == e) {
                    tag = true;
                    System.out.println(i + " + " + j + " = " + (i + j));
                    break;
                }
            }
            if (tag)
                break;
        }
    }
}
