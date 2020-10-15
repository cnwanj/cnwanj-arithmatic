package org.gxuwz.arithmatic.lanqiao.lanqiao10;

import java.util.Scanner;

public class Demo8_人物相关性分析 {

    public static void main(String[] args) {
        /**
         * This is a story about Alice and Bob.Alice wants to send a private message to Bob.
         */
        int k = 20;
        String s = "aBob This is a Alice and Bob.Alice wants to send a private message to Bob.Alice";
        int a = 0, b = 0, count = 0;
        for (int i = 0, j = 0; i < s.length() && j < s.length(); i++, j++) {
            if (i + 5 <= s.length()) {
                if ("Alice".equals(s.substring(i, i + 5))) {
                    // 判断名称是否在开头或末尾
                    if (i + 5 == s.length() || i == 0) {
                        a = i + 5;
                        i += 5;
                    } else
                        // 判断后面是否还存在字母
                        if ((s.charAt(i + 5) < 65 || (s.charAt(i + 5) > 90 && s.charAt(i + 5) < 97) || s.charAt(i + 5) > 122) &&
                                (s.charAt(i - 1) < 65 || (s.charAt(i - 1) > 90 && s.charAt(i - 1) < 97) || s.charAt(i - 1) > 122)) {
                            System.out.println(i + "-" + s.charAt(i));
                            a = i + 5;
                            i += 5;
                        }
                }
            }
            if (i + 3 <= s.length()) {
                if ("Bob".equals(s.substring(i, i + 3))) {
                    if (i + 3 == s.length() || i == 0) {
                        System.out.println(i + "-" + s.charAt(i));
                        b = i + 3;
                        i += 3;
                    } else if ((s.charAt(i + 3) < 65 || (s.charAt(i + 3) > 90 && s.charAt(i + 3) < 97) || s.charAt(i + 3) > 122) &&
                            (s.charAt(i - 1) < 65 || (s.charAt(i - 1) > 90 && s.charAt(i - 1) < 97) || s.charAt(i - 1) > 122)) {
                        System.out.println(i + "-" + s.charAt(i));
                        b = i + 3;
                        i += 3;
                    }
                }
            }

            if (a != 0 && b != 0) {
                // 判断a在后面还是b在后面
                if (a == Math.max(a, b)) {
                    a = a - 5;
                } else {
                    b = b - 3;
                }
                // 求出间距
                if (a > b) {
                    if (a - b < k) {
                        count++;
                        // 将在前面的人物指针置零
                        b = 0;
                    }
                } else {
                    if (b - a < k) {
                        count++;
                        // 将在前面的人物指针置零
                        a = 0;
                    }
                }
            }
        }
        System.out.println(count);
    }
}

/**
 * 方法二
 */
class Demo8_人物相关性分析1 {
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
        if ((le >= 65 && le <= 90) || (le >= 97 && le <= 122)) {
            return false;
        }
        if ((ri >= 65 && ri <= 90) || (ri >= 97 && ri <= 122)) {
            return false;
        }
        return true;
    }
}
