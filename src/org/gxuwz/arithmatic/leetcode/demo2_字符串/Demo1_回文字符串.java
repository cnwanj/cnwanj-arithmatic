package org.gxuwz.arithmatic.leetcode.demo2_字符串;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
验证回文字符串
给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:

输入: "A man, a plan, a canal: Panama"
输出: true
示例 2:

输入: "race a car"
输出: false
 */
public class Demo1_回文字符串 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        isPalindrome(in.nextLine());
    }

    public static boolean isPalindrome(String s) {
        if (s.split(" ").length == 0)
            return true;
        List<Character> l = new ArrayList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch <= 57 && ch >= 48 || ch <= 90 && ch >= 65 || (ch <= 122 && ch >= 97)) {
                l.add(ch);
            }
        }
        boolean t = false;
        for (int i = 0; i < l.size() / 2; i++) {
            char ch = l.get(i);
            if (ch <= 57 && ch >= 48) {
                if (ch == l.get(l.size() - i - 1)) {
                    t = true;
                } else
                    t = false;
            } else {
                if ((ch + "").equalsIgnoreCase(l.get(l.size() - i - 1) + "")) {
                    t = true;
                } else
                    t = false;
            }
        }
        return t;
    }
}
