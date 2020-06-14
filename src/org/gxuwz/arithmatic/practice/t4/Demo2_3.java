package org.gxuwz.arithmatic.practice.t4;

public class Demo2_3 {
    /**
     * 斐波那锲数列
     *
     * @param n
     * @return
     */
    static int f1(int n) {
        if (n == 1 || n == 2)
            return 1;
        return f1(n - 1) + f1(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(f1(6));
    }
}
