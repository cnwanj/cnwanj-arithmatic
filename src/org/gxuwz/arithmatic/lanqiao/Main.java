package org.gxuwz.arithmatic.lanqiao;


import java.util.Scanner;

/**
 * 【问题描述】
 * 小明正在分析一本小说中的人物相关性。他想知道在小说中 Alice 和 Bob
 * 有多少次同时出现。
 * 更准确的说，小明定义 Alice 和 Bob“同时出现”的意思是：在小说文本
 * 中 Alice 和 Bob 之间不超过 K 个字符。
 * 例如以下文本：
 * 20
 * This is a story about Alice and Bob. Alice wants to send a private message to Bob.Alice and Bob. Alice wants to send a private message to Bob.
 *
 * 假设 K = 20，则 Alice 和 Bob 同时出现了 2 次，分别是”Alice and Bob”
 * 和”Bob. Alice”。前者 Alice 和 Bob 之间有 5 个字符，后者有 2 个字符。
 * 注意:
 * 1. Alice 和 Bob 是大小写敏感的，alice 或 bob 等并不计算在内。
 * 2. Alice 和 Bob 应为单独的单词，前后可以有标点符号和空格，但是不能
 * 有字母。例如 Bobbi 並不算出现了 Bob。
 */
public class Main {
    private static int K, count;
    private static String s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        sc.nextLine();
        s = sc.nextLine();
        f();
        System.out.println(count);
    }

    static void f() {
        if (s.length() <= 7)
            return;

        for (int i = 0; i < s.length() - 3; i++) {
            // 共同出现的长度范围
            int len = 0, p = 0;
            // 寻找第一个为Alice
            if (i + 5 < s.length() && s.substring(i, i + 5).equals("Alice")) {
                p = i + 5;
                while (len <= K && p + 3 <= s.length()) {
                    if (s.substring(p, p + 3).equals("Bob")) {
                        if (check(i, i + 5) && check(p, p + 3)) {
                            System.out.println("Alice: " + i + ", Bob: " + p);
                            count ++;
                            break;
                        }
                    }
                    p ++;
                    len ++;
                }
            } else if (s.substring(i, i + 3).equals("Bob")) {
                // 寻找第一个为Bob
                p = i + 3;
                while (len <= K && p + 5 <= s.length()) {
                    if (s.substring(p, p + 5).equals("Alice")) {
                        if (check(i, i + 3) && check(p, p + 5)) {
                            System.out.println("Bob: " + i + ", Alice: " + p);
                            count ++;
                            break;
                        }
                    }
                    p ++;
                    len ++;
                }
            }
        }
    }

    // 判断前后是否符合规则
    static boolean check(int l, int r) {
        if (l - 1 < 0 || r == s.length())
            return true;

        char le = s.charAt(l - 1);
        char ri = s.charAt(r);
//        System.out.println(s.charAt(l - 1) + "==" + s.charAt(r));
        if ((le >= 65 && le <= 90) || (le >= 97 && le <= 122)) {
            return false;
        }
        if ((ri >= 65 && ri <= 90) || (ri >= 97 && ri <= 122)) {
            return false;
        }
        return true;
    }
}

