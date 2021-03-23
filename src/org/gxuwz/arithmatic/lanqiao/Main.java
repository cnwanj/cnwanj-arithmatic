package org.gxuwz.arithmatic.lanqiao;

public class Main {
    public static void main(String[] args) {
        System.out.println(f(3));
    }
    static int f(int n) {
        if (n == 1) {
            return n;
        }
        return f(n - 1) * n;
    }
}






