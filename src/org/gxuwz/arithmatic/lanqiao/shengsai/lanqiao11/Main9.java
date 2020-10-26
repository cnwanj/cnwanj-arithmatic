package org.gxuwz.arithmatic.lanqiao.shengsai.lanqiao11;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 试题 I: 子串分值和
 */
public class Main9 {

    static Set<String> set = new HashSet<String>();
    static int sum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                sum += num(s.substring(i, j + 1));
            }
        }
        System.out.println(sum);
    }

    static int num(String str) {
        set.clear();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.substring(i, i + 1));
        }
        return set.size();
    }
}
