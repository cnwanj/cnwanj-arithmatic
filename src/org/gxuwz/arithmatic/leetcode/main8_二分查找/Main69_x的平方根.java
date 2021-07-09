package org.gxuwz.arithmatic.leetcode.main8_二分查找;

/**
 * 69. x 的平方根
 *
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 *
 * https://leetcode-cn.com/problems/sqrtx/
 */
public class Main69_x的平方根 {

    public static void main(String[] args) {
        System.out.println(mySqrt1(9));
    }

    // 二分法
    public static int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int l = 0, r = x;
        while (l <= r) {
            // 获取中位数
            int m = l + (r - l) / 2;
            int n = x / m;
            // 往右走
            if (n > m) {
                l = m + 1;
            } else if (n < m) {
                r = m - 1;
            } else {
                return m;
            }
        }
        return r;
    }

    // 循环遍历法
    public static int mySqrt1(int x) {
        int a = 1;
        while (x / a >= a) {
            a ++;
        }
        return a - 1;
    }
}
