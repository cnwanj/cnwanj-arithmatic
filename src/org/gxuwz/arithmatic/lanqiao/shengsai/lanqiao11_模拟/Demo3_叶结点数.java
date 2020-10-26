package org.gxuwz.arithmatic.lanqiao.shengsai.lanqiao11_模拟;

import java.util.Scanner;

/**
 * 【问题描述】一棵包含有2019个结点的二叉树，最多包含多少个叶结点？
 * 【答案提交】这是一道结果填空的题，你只需要算出结果后提交即可。
 * 本题的结果为一个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。
 * 【答案】1010
 */
public class Demo3_叶结点数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n % 2 == 0) {
            n = n / 2;
        } else {
            n = n / 2 + 1;
        }
        System.out.println(n);
    }
}
