package org.gxuwz.arithmatic.lanqiao.shengsai.lanqiao10;

import java.util.Scanner;

public class Demo6_特别数的和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();
        long sum = 0;
        for (int i = 1; i <= s; i++) {
            String k = String.valueOf(i);
            if (k.contains("0")) {
                sum += i;
            } else if (k.contains("1")) {
                sum += i;
            } else if (k.contains("2")) {
                sum += i;
            } else if (k.contains("9")) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
