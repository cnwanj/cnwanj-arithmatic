package org.gxuwz.arithmatic.dataStructures.Demo06_排序;

import java.util.Arrays;

/**
 * 基数排序
 */
public class RadixSort {
    public static void radix(int[] arr) {
        // 定义10个桶
        int[][] bucket = new int[10][arr.length];
        // 用来存放每个桶数据的个数，共有十个桶
        int[] count = new int[10];
        // 找出元素中最大值
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        // 取出最大值的位数
        int len = (max + "").length();
        for (int i = 0, n = 1; i < len; i++, n *= 10) {
            // 1、针对每个元素进行排位处理
            for (int j = 0; j < arr.length; j++) {
                // 取出元素的每一位数
                int num = arr[j] / n % 10;
                // 将元素放入对应的桶中
                bucket[num][count[num]] = arr[j];
                count[num]++;
            }
            // 2、按照桶的顺序依次取出放入原始数组中
            int index = 0;
            // 遍历10个桶
            for (int k = 0; k < bucket.length; k++) {
                // 判断该桶是否有数据
                if (count[k] != 0) {
                    // 依次将桶中的数据取出
                    for (int l = 0; l < count[k]; l++) {
                        arr[index] = bucket[k][l];
                        index++;
                    }
                }
                // 将count[k]数组进行清0
                count[k] = 0;
            }
//            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
//        int[] arr = {53,3,542,748,14,214};
//        radix(arr);
        // 数据测试
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000000);
        }
        Long time1 = System.currentTimeMillis();
        radix(arr);
        Long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);
    }
}
