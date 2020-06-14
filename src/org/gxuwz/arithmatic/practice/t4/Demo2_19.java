package org.gxuwz.arithmatic.practice.t4;

/**
 * 最长连续递增的子序列：
 * {1,9,2,5,7,3,4,6,8,0}中最长的子序列为{3,4,6,8}
 */
public class Demo2_19 {
    static int f(int[] a) {
        int max = 0; //指针
        int p = 0;  //长度
        int len = a.length;
        for (int i = 0; i < len - 1; i++) {
            if (a[i] < a[i + 1]) {
                p++;
                if (p > max) {
                    max = p;
                }
            } else {
                p = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {1, 9, 2, 5, 7, 3, 4, 6, 8, 0};
        System.out.println(f(a));
    }
}
