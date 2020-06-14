package org.gxuwz.arithmatic.practice.recursive;

import java.util.Scanner;

/*
3. 数的全排列问题。将n个数字1，2，…n的所有排列按字典顺序枚举出来
  1 2 3
  1 3 2
  2 3 1
  2 1 3
  3 1 2
  3 2 1
 */
public class Demo1_数的全排列 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[sc.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        // System.out.println(Arrays.toString(arr));

        // 全排列
        f(arr, 0);
    }

    static void f(int[] arr, int p) {
        // 若指针等于数组长度
        if (p == arr.length - 1) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            // 终止递归
            return;
        }
        // 遍历，i指针+1
        for (int i = p; i < arr.length; i++) {
            // 进行数据交换，i和p都会递增，进行交换全排列
            swap(arr, i, p);
            // 递归调用，p指针+1
            f(arr, p + 1);
            // 交换回来
            swap(arr, i, p);
        }
    }

    static void swap(int[] arr, int i, int p) {
        int t = arr[i];
        arr[i] = arr[p];
        arr[p] = t;
    }
}
