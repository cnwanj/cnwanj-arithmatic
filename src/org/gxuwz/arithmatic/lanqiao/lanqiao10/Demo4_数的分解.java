package org.gxuwz.arithmatic.lanqiao.lanqiao10;

import java.util.HashSet;
import java.util.Set;

/**
 * 【题目】
 * 数的分解
 *
 * 把 2019 分解成 3 个各不相同的正整数之和，并且要求每个正整数都不包
 *
 * 含数字 2 和 4，一共有多少种不同的分解方法？
 *
 * 注意交换 3 个整数的顺序被视为同一种方法，例如 1000+1001+18 和
 *
 * 1001 + 1000 + 18 被视为同一种。
 *
 * 【答案】
 * 40785
 */
public class Demo4_数的分解 {
    public static void main(String[] args) {
        f();
    }

    public static boolean check(int i) {
        if (("" + i).contains("2") || ("" + i).contains("4")) {
            return true;
        }
        return false;
    }

    public static void f() {
        int n = 2019, count = 0;
        for (int i = 1; i < n; i++) {
            if (check(i))
                continue;

            for (int j = 1; j < n; j++) {
                if (check(j))
                    continue;

                int k = n - i - j;
                if (check(k))
                    continue;

                if (i == j || j == k || i == k)
                    continue;

                if (k > 0)
                    count ++;
            }
        }
        System.out.println(count / 6);
    }
}

class Demo4_数的分解1 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i < 2019; i++) {
            if (check(i)) {
                for (int j = 1; j < 2019; j++) {
                    if (check(j)) {
                        int k = 2019 - i - j;
                        if (k > 0 && check(k) && i != j && j != k && i != k) {
                            count ++;
                        }
                    }
                }
            }

        }
        System.out.println(count / 6);
    }

    static boolean check(int n) {
        if (!String.valueOf(n).contains("2") && !String.valueOf(n).contains("4"))
            return true;
        return false;
    }
}
