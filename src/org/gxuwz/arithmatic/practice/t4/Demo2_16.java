package org.gxuwz.arithmatic.practice.t4;

import java.util.Scanner;

/**
 * 走楼梯：
 * 有n阶楼梯，可以走1阶、2阶或3阶，
 * 有多少种走完楼梯的方式
 */
public class Demo2_16 {
    public static int f(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        return f(n - 1) + f(n - 2) + f(n - 3);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            int s = input.nextInt();
            System.out.println(f(s));
        }
    }
}
