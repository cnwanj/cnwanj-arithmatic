package org.gxuwz.arithmatic.lanqiao.lanqiao11;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 试题 E: 排序
 */
public class Main5 {
    // mnlkojihgfedcba
    // komnljihgfedcba
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String str = sc.nextLine();
            char[] a = new char[str.length()];
            for (int i = 0; i < a.length; i++) {
                a[i] = str.charAt(i);
            }

            int count = 0;
            for (int i = 0; i < a.length - 1; i++) {
                for (int j = 0; j < a.length - i - 1; j++) {
                    if (a[j] > a[j+1]) {
                        count ++;
                        char t = a[j];
                        a[j] = a[j+1];
                        a[j+1] = t;
                    }
                }
            }
            System.out.println(count);
            System.out.println(Arrays.toString(a));
        }

    }
}
