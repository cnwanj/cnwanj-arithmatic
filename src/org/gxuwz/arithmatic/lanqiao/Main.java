package org.gxuwz.arithmatic.lanqiao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), sum = 1;
        int i = n % 2 == 0 ? 2 : 1;
        for (; i <= n; i += 2) {
            sum *= i;
            sum %= 100000;
            System.out.println(i + " " + sum);
        }
//        System.out.println(-9 % 5);
//        System.out.println(Math.floorMod(-9, 5));
    }
}






