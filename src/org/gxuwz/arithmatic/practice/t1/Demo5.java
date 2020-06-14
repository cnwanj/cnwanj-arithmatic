package org.gxuwz.arithmatic.practice.t1;

public class Demo5 {
    /**
     * 1
     * 12
     * 123
     * 1234
     * 12345
     * 123456
     */
    static void f1(int n) {
        for (int j = 0; j <= n; j++) {
            for (int i = 0; i < j; i++) {
                System.out.print(i + 1);
            }
            System.out.println();
        }
    }

    /**
     * 123456
     * 12345
     * 1234
     * 123
     * 12
     * 1
     */
    static void f2(int n) {
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                System.out.print(i + 1);
            }
            System.out.println();
        }
    }

    /**
     * 1
     * 212
     * 32123
     * 4321234
     * 543212345
     * 65432123456
     */
    static void f3(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                System.out.print(" ");
            }
            for (int k = i + 1; k > 0; k--) {
                System.out.print(k);
            }
            for (int l = 0; l < i; l++) {
                System.out.print(l + 2);
            }
            System.out.println();
        }
    }

    /**
     * ABCDEFG
     * BABCDEF
     * CBABCDE
     * DCBABCD
     * EDCBABC
     */
    static void f4(int n, int m) {

    }

    static void f5(int n) {
        double s = Math.PI * n * n;
        System.out.printf("%.7f\n", s);
    }

    public static void main(String[] args) {
        f5(2);
    }
}
