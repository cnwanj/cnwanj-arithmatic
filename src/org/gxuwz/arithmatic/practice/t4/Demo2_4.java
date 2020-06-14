package org.gxuwz.arithmatic.practice.t4;

/**
 * 最大公约数
 */
public class Demo2_4 {
    static int f1(int n, int m) {
        if (m == 0) return n;
        return f1(m, n % m);
    }

    public static void main(String[] args) {
        System.out.println(f1(4, 2));
    }
}
