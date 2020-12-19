package org.gxuwz.arithmatic.lanqiao;

import java.util.Arrays;

public class Main1 {

    public static void main(String[] args) {
        int[] arr = {8, 3, 5, 2, 3, 6, 1, 7, 9};
        f1(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 未优化的冒泡排序
     * @param arr
     */
    static void f(int[] arr) {
        // i为冒泡的次数（每次最大元素冒泡到末尾算一次）
        for (int i = 0, len = arr.length; i < len - 1; i++) {
            // len - 1：总共交换的次数；len - 1 - i：每次交换的次数
            for (int j = 0; j < len - 1 - i; j++) {
                // 若当前元素大于下一个元素，则进行交换（冒泡）
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 优化后的冒泡排序
     * @param arr
     */
    static void f1(int[] arr) {
        // i为冒泡的次数（每次最大元素冒泡到末尾算一次）
        for (int i = 0, len = arr.length; i < len - 1; i++) {
            // 记录每一趟是否有元素交换
            boolean tag = true;
            // len - 1：总共交换的次数；len - 1 - i：每次交换的次数
            for (int j = 0; j < len - 1 - i; j++) {
                // 若当前元素大于下一个元素，则进行交换（冒泡）
                if (arr[j] > arr[j + 1]) {
                    tag = false;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            // 若无元素交换退出循环
            if (tag)
                break;
        }
    }
}
