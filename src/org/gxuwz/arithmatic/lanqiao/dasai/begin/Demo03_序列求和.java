package org.gxuwz.arithmatic.lanqiao.dasai.begin;

import java.util.Scanner;

public class Demo03_序列求和 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();
        if(n >= 1 && n <= 1000000000){
            long sum = (1 + n)*n/2;
            System.out.println(sum);
        }
    }
}
