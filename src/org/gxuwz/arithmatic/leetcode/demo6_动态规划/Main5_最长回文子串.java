package org.gxuwz.arithmatic.leetcode.demo6_动态规划;

import java.util.Scanner;

/**
 * 题目：
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 *
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ac"
 * 输出："a"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 *
 * aba
 * abba
 * abcba
 *
 * babad
 * cbbd
 *
 * 思路：
 * 1.采用中心扩散的方法。
 * 2.中心为起点，左右指针向两边移动。
 * 3.若中心字符连续相等，移动指针。
 * 4.若连续不相等，判断左右指针的元素是否相等，相等，移动指针。
 */
public class Main5_最长回文子串 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(f(s));
    }

    public static String f(String s) {
        int len = s.length(), l, r, max = 1;
        String maxLen = s.substring(0, 1);
        for (int i = len - 1; i >= 0; i--) {
            l = i;
            r = i;
            // 解决abba情况，即字符连续相等的情况
            while (l - 1 >= 0 && s.charAt(i) == s.charAt(l - 1)) {
                l --;
            }
            while (r + 1 < len && s.charAt(i) == s.charAt(r + 1)) {
                r ++;
            }
            if (r - l + 1 >= max) {
                maxLen = s.substring(l, r + 1);
                max = r - l + 1;
            }
            // 若对称的两个字符相等
            while (l - 1 >= 0 && r + 1 < len && s.charAt(l - 1) == s.charAt(r + 1)) {
                l --;
                r ++;
                if (r - l + 1 >= max) {
                    maxLen = s.substring(l, r + 1);
                    max = r - l + 1;
                }
            }
        }
        return maxLen;
    }
}
