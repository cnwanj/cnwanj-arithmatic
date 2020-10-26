package org.gxuwz.arithmatic.lanqiao.shengsai.lanqiao11;
/**
 *
 * 【样例输入】
 lanqiao
 【样例输出】
 a
 2
 【样例输入】
 longlonglongistoolong
 试题G: 单词分析 9
 第十一届蓝桥杯大赛软件类省赛第二场 Java 大学 B 组
 【样例输出】
 o
 6

 */

import java.util.Scanner;

/**
 * 试题 G: 单词分析
 */
public class Main7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        f(s);
    }

    static void f(String s) {
        if (s.length() == 1) {
            System.out.println(s);
            System.out.println(s.length());
        }
        char m = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == m) {
                count ++;
            } else {
                int num = 1;
                for (int j = 0; j < i; j++) {
                    if (s.charAt(j) == s.charAt(i)) {
                        num ++;
                    }
                }
                if (num > count) {
                    m = s.charAt(i);
                    count = num;
                }
            }
        }
        System.out.println(m);
        System.out.println(count);
    }
}
