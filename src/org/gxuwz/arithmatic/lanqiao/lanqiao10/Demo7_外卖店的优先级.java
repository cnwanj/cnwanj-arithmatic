package org.gxuwz.arithmatic.lanqiao.lanqiao10;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 试题 G: 外卖店的优先级
 *
 * 　　【问题描述】
 *
 * 　　　“饱了么”外卖系统中维护着 N 家外卖店，编号 1 ∼ N。每家外卖店都有 一个优先级，初始时 (0 时刻) 优先级都为 0。
 *
 * 　　　每经过 1 个时间单位，如果外卖店没有订单，则优先级会减少 1，最低减 到 0；
 *
 * 　　　而如果外卖店有订单，则优先级不减反加，每有一单优先级加 2。
 *
 * 　　　如果某家外卖店某时刻优先级大于 5，则会被系统加入优先缓存中；如果 优先级小于等于 3，则会被清除出优先缓存。
 *
 * 　　　给定 T 时刻以内的 M 条订单信息，请你计算 T 时刻时有多少外卖店在优 先缓存中。
 *
 * 　　【输入格式】
 *
 * 　　　第一行包含 3 个整数 N、M 和 T。 以下 M 行每行包含两个整数 ts 和 id，表示 ts 时刻编号 id 的外卖店收到 一个订单。
 *
 * 　　【输出格式】
 * 　　　输出一个整数代表答案。
 * 　　【样例输入】
 *
2 6 6
1 1
5 2
3 1
6 2
2 1
6 2
 *
 * 　　【样例输出】
 *
 * 　　　1
 *
 * 　　【样例解释】
 *
 * 　　　6 时刻时，1 号店优先级降到 3，被移除出优先缓存；2 号店优先级升到 6， 加入优先缓存。所以是有 1 家店 (2 号) 在优先缓存中。
 *
 * 　　【评测用例规模与约定】
 *
 * 　　　对于 80% 的评测用例，1≤ N,M,T ≤10000。 对于所有评测用例，1≤ N,M,T ≤100000，1≤ts≤T，1≤id ≤ N。
 */
public class Demo7_外卖店的优先级 {
    // 订单实体
    static class R {
        int ts;
        int id;
    }

    public static void main(String[] args) {
        /**
         2 6 6
         1 1
         5 2
         3 1
         6 2
         2 1
         6 2
         * 店数(n) 订单数(m) 时刻(t)
         * 时刻(ts) 店编号(id)
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), t = sc.nextInt();
        R[] rs = new R[m];
        for (int i = 0; i < m; i++) {
            R r = new R();
            r.ts = sc.nextInt();
            r.id = sc.nextInt();
            rs[i] = r;
        }
        System.out.println(f(n, rs));
    }
    static int f(int n, R[] rs) {
        // 按时刻排序订单
        Arrays.sort(rs, new Comparator<R>() {
            public int compare(R r1, R r2) {
                return r1.ts - r2.ts;
            }
        });

        // 用于存放优先级
        int[] arr = new int[n];
        // 遍历订单
        for (int i = 0; i < rs.length; i++) {
            int id = rs[i].id;
            // 若该时刻收到订单，优先级+2
            arr[id - 1] += 2;
            // 遍历缓存中的数组
            for (int j = 0; j < arr.length; j++) {
                // 该时刻内的没有获得订单，优先级 - 1
                if (j == id-1)
                    continue;
                if (arr[j] != 0)
                    arr[j] -= 1;
            }
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 3)
                count ++;
        }
        return count;
    }
}
