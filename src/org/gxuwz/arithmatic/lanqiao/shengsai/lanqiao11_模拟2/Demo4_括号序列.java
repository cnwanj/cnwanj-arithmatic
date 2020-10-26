package org.gxuwz.arithmatic.lanqiao.shengsai.lanqiao11_模拟2;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 *
 * 【问题描述】
 * 由1对括号，可以组成一种合法括号序列：()。由2对括号，可以组成两种合法括号序列：()()、(())。
 * 由4对括号组成的合法括号序列一共有多少种？
 * 【答案提交】
 * 这是一道结果填空的题，你只需要算出结果后提交即可。
 * 本题的结果为一个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。
 *
 * 答案： 14
 *
 * @author: 韦永恒
 * @date: 2020-09-01 15:00:28
 */
public class Demo4_括号序列 {

    private static int count = 0;
    private static Set<String> set = new HashSet<String>();

    public static void main(String[] args) {
        char[] arr = "()()()()".toCharArray();

        f(arr, 0);
        set.forEach(s -> {
            System.out.println(s);
        });
        System.out.println(set.size());
    }

    static void f(char[] arr, int p) {
        if (p == arr.length - 1) {
            count ++;
            if (arr[0] != ')' && arr[p] != '(') {
                StringBuffer  s = new StringBuffer();
                for (int i = 0; i < arr.length; i++) {
                    s.append(arr[i]);
                }
                set.add(s.toString());
            }
            return;
        }

        for (int i = p; i < arr.length; i++) {
            swap(arr, i, p);
            f(arr, 1 + p);
            swap(arr, i, p);
        }
    }

    static void swap(char[] arr, int i, int p) {
        char t = arr[i];
        arr[i] = arr[p];
        arr[p] = t;
    }
}
