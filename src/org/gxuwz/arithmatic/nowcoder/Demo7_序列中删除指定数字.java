package org.gxuwz.arithmatic.nowcoder;

import java.util.Scanner;

public class Demo7_序列中删除指定数字 {
    public static void f(int[] arr, int n) {
        int p = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) {
                p = i;
                break;
            }
        }
        if (p != -1) {
            int p1 = 0;
            int[] arr1 = new int[arr.length - 1];
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == arr[p]) {
                    i++;
                }
                arr1[p1++] = arr[i];
            }
            for (int i = 0; i < arr1.length; i++) {
                System.out.print(arr1[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] str = sc.nextLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        int in = sc.nextInt();
        f(arr, in);
    }
}
