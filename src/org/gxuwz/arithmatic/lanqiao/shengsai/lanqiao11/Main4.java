package org.gxuwz.arithmatic.lanqiao.shengsai.lanqiao11;

import java.util.Arrays;

/**
 * 试题 D: 七段码
 */
public class Main4 {
    static char[] a, b;
    static int count = 0, sum = 0;
// 111111
    // 7 21 35 35 21 7 1
    public static void main(String[] args) {
        // , 'd', 'e', 'f', 'g'
        a = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        b = new char[2];
        f(0, 0);
        System.out.println(count);
        System.out.println(7 + 21 + 35 + 35 + 21 + 7 + 1);
        System.out.println(7+ 10+ 12+ 20 +19 + 7 +1);
    }

    static void f(int c, int p) {
        if (p == b.length) {
            System.out.println(Arrays.toString(b));
            count ++;
            return;
        }
        for (int i = c; i < a.length; i++) {
            b[p] = a[i];
            f(i + 1, p + 1);
        }
    }
}
