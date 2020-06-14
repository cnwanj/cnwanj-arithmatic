package org.gxuwz.arithmatic.lanqiao.dasai.begin;

import java.util.Scanner;

public class Demo01_圆的面积 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Double r = scan.nextDouble();
        System.out.printf("%.7f", Math.PI * r * r);
    }
}
