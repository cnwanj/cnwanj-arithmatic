package org.gxuwz.arithmatic.lanqiao.guosai.lanqiao6;

/**
 * @Author: 韦永恒
 * @Date: 2020-10-26 20:32:49
 * @Description:
 *
 * 标题：分机号
 *
 * X老板脾气古怪，他们公司的电话分机号都是3位数，老板规定，所有号码必须是降序排列，且不能有重复的数位。比如：
 *
 * 751,520,321 都满足要求，而，
 * 766,918,201 就不符合要求。
 *
 * 现在请你计算一下，按照这样的规定，一共有多少个可用的3位分机号码？
 *
 * 请直接提交该数字，不要填写任何多余的内容。
 *
 * 【答案】120
 */
public class Main1_分机号 {
    static int[] a1 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, a2 = new int[3];
    static int count = 0;

    public static void main(String[] args) {
        f(0, 0);
        System.out.println(count);
    }

    static void f(int c, int p) {
        if (p == a2.length) {
            count ++;
            return;
        }
        for (int i = c; i < a1.length; i++) {
            a2[p] = a1[i];
            f(i + 1, p + 1);
        }
    }
}
