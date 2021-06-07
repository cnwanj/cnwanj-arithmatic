package org.gxuwz.arithmatic.nowcoder.main_练习;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述
 * 输入两个升序排列的序列，将两个序列合并为一个有序序列并输出。
 * 输入描述:
 * 输入包含三行，
 * <p>
 * 第一行包含两个正整数n, m（1 ≤ n,m ≤ 100），用空格分隔。n表示第二行第一个升序序列中数字的个数，m表示第三行第二个升序序列中数字的个数。
 * <p>
 * 第二行包含n个整数（范围1~5000），用空格分隔。
 * <p>
 * 第三行包含m个整数（范围1~5000），用空格分隔。
 * 输出描述:
 * 输出为一行，输出长度为n+m的升序序列，即长度为n的升序序列和长度为m的升序序列中的元素重新进行升序序列排列合并。
 * 示例1
 * 输入
 * 复制
 * 5 6
 * 1 3 7 9 22
 * 2 8 10 17 33 44
 * 输出
 * 复制
 * 1 2 3 7 8 9 10 17 22 33 44
 */
public class Demo5_有序序列合并 {

    public static void f(int[] arr1, int[] arr2) {

        int a = arr1.length;
        int b = arr2.length;
        int[] arr = new int[a + b];
        // 定义两个指针
        int j = 0, k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (j == a) {
                if (k == b) {
                    break;
                }
                arr[i] = arr2[k];
                k++;
            } else if (k == b) {
                if (j == a) {
                    break;
                }
                arr[i] = arr1[j];
                j++;
            } else {
                if (arr1[j] > arr2[k]) {
                    arr[i] = arr2[k];
                    k++;
                } else {
                    arr[i] = arr1[j];
                    j++;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int[] arr1 = new int[Integer.parseInt(s[0])];
        int[] arr2 = new int[Integer.parseInt(s[1])];

        String[] s1 = sc.nextLine().split(" ");
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = Integer.parseInt(s1[i]);
        }
        String[] s2 = sc.nextLine().split(" ");
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = Integer.parseInt(s2[i]);
        }
        f(arr1, arr2);
    }

}
