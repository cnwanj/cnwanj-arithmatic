package org.gxuwz.arithmatic.practice.t1;

/**
 * 选择排序
 */
public class Demo3 {
    public static void f(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int p = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[p] > a[j]) {
                    p = j;
                }
            }
            int temp = a[i];
            a[i] = a[p];
            a[p] = temp;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] a = {4, 2, 5, 1, 3, 7};
        f(a);
    }
}
