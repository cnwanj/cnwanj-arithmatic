package org.gxuwz.arithmatic.nowcoder.main1_练习;

import java.util.Scanner;

public class Demo6_序列中整数去除 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
        String[] s = str.split(" ");
        String s1 = "";
        for (int i = 0; i < s.length; i++) {
            if(s1.indexOf(s[i]) == -1) {
                s1 = s1 + s[i]+" ";
            }
        }
        System.out.println(s1);
    }

}
