package org.gxuwz.arithmatic.practice.t1;

public class Demo4 {
    public static int f(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        return f(n - 1) + f(n - 2);
    }

    public static int f1(int n) {
        if (n == 1) {
            return 1;
        }
        return f1(n - 1) / 2 - 1;
    }

    public static void main(String[] args) {
//        System.out.println(f(9)%(1e9+7));
        System.out.println(f1(3));
    }
}
