package org.gxuwz.arithmatic.lanqiao.lanqiao11_模拟;


import java.util.Scanner;

public class Demo5_数位递增的数 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            String s = i + "";
            boolean tag = true;
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j - 1) > s.charAt(j)) {
                    tag = false;
                    break;
                }
            }
            if (tag) {
                count++;
            }
        }
        System.out.println(count);
    }
}
