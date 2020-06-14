package org.gxuwz.arithmatic.practice.t2;

/**
 * 猜生日
 * 2012.03.12
 * ?
 */

public class Demo11 {
    public static void f() {
        for (int i = 20120312; i > 19000101; i--) {
            String n = "" + i;
            int d = Integer.parseInt(n.substring(6));
            int m = Integer.parseInt(n.substring(4, 6));
            if (d > 0 && d < 32 && m == 06 && i % 2012 == 0 && i % 03 == 0 && i % 12 == 0) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        f();
    }
}
