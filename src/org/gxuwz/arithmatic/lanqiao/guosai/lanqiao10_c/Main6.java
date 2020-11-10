package org.gxuwz.arithmatic.lanqiao.guosai.lanqiao10_c;

import java.util.Scanner;

/**
 * @Author: 韦永恒
 * @Date: 2020-10-28 13:58:13
 * @Description:
 *
 * 输入一个S串和一个T串，|S|>= |T|,问最少要修改S中的几个字母才能使S中有子序列T
 *
 * 样例输入1：
 *
 * ABCDABCD
 * AABCX
 *
 * 样例输出1：
 *
 * 2
 *
 *
 * 样例输入2：
 *
 * ABCDABCD
 * XAAD
 *
 * 样例输出2：
 *
 * 3
 *
 *
 * 样例输入3：
 *
 * XBBBBBAC
 * ACC
 *
 * 样例输出3：
 *
 * 2
 *
 */
public class Main6 {

    static char[] S, T;

    /**
     * ABCDABCD
     * AABC
     *
     * BBAC
     * ACC
     *
     * ABCECDFF
     * BBDEC
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        S = sc.nextLine().toCharArray();
        T = sc.nextLine().toCharArray();
        sc.close();

        int n, min = T.length;
        for (int i = 0; i < S.length - T.length + 1; i++) {
            n = check(i);
            if (n < min)
                min = n;
        }
        System.out.println(min);
    }

    static int check(int p) {
        int num = 0;
        for (int i = 0; i < T.length; i++) {
            if (S[i + p] != T[i]) {
                num ++;
            }
        }
        return num;
    }
}
