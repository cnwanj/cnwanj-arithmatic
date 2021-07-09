package org.gxuwz.arithmatic.nowcoder.main2_动态规划;

import java.util.Scanner;

/**
 * 127.最长公共子串
 *
 * 描述
 * 给定两个字符串str1和str2,输出两个字符串的最长公共子串
 * 题目保证str1和str2的最长公共子串存在且唯一。
 *
 * 示例1
 * 输入：
 * "1AB2345CD","12345EF"
 *
 * 返回值：
 * "2345"
 */
public class Main127_最长公共子串 {

    public static void main(String[] args) {
        /**
         * 1AB2345CD
         * 12345EF
         */
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
//        f1(str1, str2);
        System.out.println(f2(str1, str2));

    }

    static String f1(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] arr = new int[m][n];
        int count = 0, x = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    if (i == 0 || j == 0 || arr[i - 1][j - 1] == 0) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }
                }
                if (arr[i][j] > count) {
                    count = arr[i][j];
                    x = i;
                }
            }
        }
        return str1.substring(x - count + 1, x + 1);
    }

    static String f2(String str1, String str2) {
        int left = 0, right = 1;
        String str = "";
        while (right <= str2.length()) {
            String substring = str2.substring(left, right);
            // 若包含子序列，则替换
            if (str1.contains(substring)) {
                str = substring;
            } else {
                // 否则左指针右移
                left ++;
            }
            right ++;
        }
        return str;
    }
}
