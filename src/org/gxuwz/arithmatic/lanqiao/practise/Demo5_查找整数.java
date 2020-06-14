package org.gxuwz.arithmatic.lanqiao.practise;

import java.util.Scanner;

/**
 * 5、基础练习 查找整数
 * 问题描述
 * 给出一个包含n个整数的数列，问整数a在数列中的第一次出现是第几个。
 * 输入格式
 * 第一行包含一个整数n。
 * 第二行包含n个非负整数，为给定的数列，数列中的每个数都不大于10000。
 * 第三行包含一个整数a，为待查找的数。
 * 输出格式
 * 如果a在数列中出现了，输出它第一次出现的位置(位置从1开始编号)，否则输出-1。
 * 样例输入
 * 6
 * 1 9 4 8 3 9
 * 9
 * 样例输出
 * 2
 * 数据规模与约定
 * 1 <= n <= 1000。
 */
public class Demo5_查找整数 {

    private static void f1(int[] ins, int a) {
        int len = ins.length;
        int p = -1;
        for(int i = 0; i < len; i++){
            if(ins[i] == a){
                p = i;
                break;
            }
        }
        System.out.println(p);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        String s = input.nextLine();
        String[] str = s.split(" ");
        int[] ins = new int[n];
        for(int i=0; i<str.length; i++){
            ins[i] = Integer.parseInt(str[i]);
        }
        int a = input.nextInt();
        f1(ins, a);
    }
}
