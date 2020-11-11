package org.gxuwz.arithmatic.lanqiao.guosai.lanqiao10_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @Author: vovhh
 * @Date: 2020-11-10 22:35:26
 * @Description:
 * 试题 F: 最长子序列
 * 时间限制: 1.0s 内存限制: 512.0MB 本题总分：15 分
 * 【问题描述】
 * 我们称一个字符串 S 包含字符串 T 是指 T 是 S 的一个子序列，即可以从
 * 字符串 S 中抽出若干个字符，它们按原来的顺序组合成一个新的字符串与 T 完
 * 全一样。
 * 给定两个字符串 S 和 T，请问 T 中从第一个字符开始最长连续多少个字符
 * 被 S 包含？
 * 【输入格式】
 * 输入两行，每行一个字符串。第一行的字符串为 S，第二行的字符串为 T。
 * 两个字符串均非空而且只包含大写英文字母。
 * 【输出格式】
 * 输出一个整数，表示答案。
 * 【样例输入】
 * ABCDEEF
 * ABDZAZ
 * 【样例输出】
 * 3
 * 【评测用例规模与约定】
 * 对于 20% 的评测用例，1 ≤ |T| ≤ |S | ≤ 20；
 * 对于 40% 的评测用例，1 ≤ |T| ≤ |S | ≤ 100；
 * 对于所有评测用例，1 ≤ |T| ≤ |S | ≤ 1000。
 *
 */
public class Main6_最长子序列 {

    static char[] S, T;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        S = sc.nextLine().toCharArray();
        T = sc.nextLine().toCharArray();

        int count = 0, max = 0, p = 0;
        for (int i = 0; i < T.length; i++) {
            boolean tag = false;
            for (int j = p; j < S.length; j++) {
                if (T[i] == S[j]) {
                    tag = true;
                    count ++;
                    p = j;
                    break;
                }
            }
            if (!tag || i == T.length - 1) {
                if (max < count) {
                    max = count;
                }
                count = 0;
            }
        }
        System.out.println(max);

//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String S = in.readLine();
//        String T = in.readLine();
//        int j = 0;
//        for (int i = 0, sLen = S.length(), tLen = T.length(); i < sLen && j < tLen; i++)
//            if (S.charAt(i) == T.charAt(j))
//                j++;
//        System.out.println(j);
    }
}
