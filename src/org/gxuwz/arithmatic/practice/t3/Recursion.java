package org.gxuwz.arithmatic.practice.t3;

/**
 * 递归联系
 */
public class Recursion {
    //求n的阶乘
    static int f1(int n) {
        if (n == 1) {
            return 1;
        }
        return n * f1(n - 1);
    }

    //打印i-j
    static int f2(int i, int j) {
        if (i > j) {
            return i;
        }
        System.out.println(i);
        return f2(i + 1, j);
    }

    public static void main(String[] args) {
//        System.out.println(f1(5));
        f2(1, 10);
    }
}
