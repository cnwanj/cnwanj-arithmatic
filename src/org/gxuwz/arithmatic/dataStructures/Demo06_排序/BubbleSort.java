package org.gxuwz.arithmatic.dataStructures.Demo06_排序;

import java.util.Arrays;

/**
 * 冒泡排序：
 *      元素之间两两交换，将最大的元素往后冒。
 *      若当前元素大于后一个元素，进行交换。
 */
public class BubbleSort {
    public static void bubble(int[] arr) {
        int len = arr.length;
        // 定义flag，若已经排好顺序，则停止判断
        boolean flag = false;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            // 判断是否进行了交换
            if (flag)
                // 重置flag
                flag = false;
            else
                break;
            System.out.print(Arrays.toString(arr));
            System.out.println();
        }
    }

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

    public static void main(String[] args) {
        // int[] arr = {5, 1, 3, 2,4 ,0};
        // bubble(arr);
        // 准备数据，排序80000个数据，测试冒泡排序的时间复杂度
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }
        // 获取系统时间戳
        Long time1 = System.currentTimeMillis();
        bubble(arr);
        Long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);
    }
}
