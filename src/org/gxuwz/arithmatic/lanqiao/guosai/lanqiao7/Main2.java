package org.gxuwz.arithmatic.lanqiao.guosai.lanqiao7;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: 韦永恒
 * @Date: 2020-10-28 09:30:22
 * @Description:
 *
 * 反幻方
 *
 * 我国古籍很早就记载着
 *
 * 2 9 4
 * 7 5 3
 * 6 1 8
 *
 * 这是一个三阶幻方。每行每列以及对角线上的数字相加都相等。
 *
 * 下面考虑一个相反的问题。
 *
 * 可不可以用 1~9 的数字填入九宫格。
 *
 * 使得：每行每列每个对角线上的数字和都互不相等呢？
 *
 * 这应该能做到。
 *
 * 比如：
 *
 * 9 1 2
 * 8 4 3
 * 7 5 6
 *
 * 你的任务是搜索所有的三阶反幻方。并统计出一共有多少种。
 *
 * 旋转或镜像算同一种。
 *
 * 比如：
 *
 * 9 1 2
 * 8 4 3
 * 7 5 6
 *
 * 7 8 9
 * 5 4 1
 * 6 3 2
 *
 * 2 1 9
 * 3 4 8
 * 6 5 7
 *
 * 等都算作同一种情况。
 *
 * 请提交三阶反幻方一共多少种。
 *
 * 这是一个整数，不要填写任何多余内容。
 *
 * 【思路】
 * 进行全排列，判断行列斜线上是否有相等的，若有相等的返回false，否则返回true
 *
 * 【答案】3120
 */
public class Main2 {

    static int n = 9, count = 0;
    static int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] args) {
        f(0);
        System.out.println(count + " " + count / 4 / 2);
    }

    static void f(int p) {
        if (p == a.length) {
            if (check()) {
                count ++;
            }
            return;
        }
        for (int i = p; i < n; i++) {
            swap(i, p);
            f(1 + p);
            swap(i, p);
        }
    }

    static boolean check() {
        Set<Integer> set = new HashSet<Integer>();
        set.add(a[0] + a[1] + a[2]);
        set.add(a[3] + a[4] + a[5]);
        set.add(a[6] + a[7] + a[8]);
        set.add(a[0] + a[3] + a[6]);
        set.add(a[1] + a[4] + a[7]);
        set.add(a[2] + a[5] + a[8]);
        set.add(a[0] + a[4] + a[8]);
        set.add(a[2] + a[4] + a[6]);
        return set.size() == n - 1;
    }

    static void swap(int i, int p) {
        int t = a[i];
        a[i] = a[p];
        a[p] = t;
    }
}
