package org.gxuwz.arithmatic.dataStructures.Demo05_递归;

public class Recursion {
    public static int f1(int n) {
        if (n == 1) return 1;
        return f1(n - 1) * n;
    }

    public static void main(String[] args) {
        System.out.println(f1(3));
    }
}
