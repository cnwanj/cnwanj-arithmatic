package org.gxuwz.arithmatic.dataStructures.Demo06_排序;

import java.util.Arrays;
/**
 * 选择排序
 * 思路：
 *      以arr[i]为基准数。
 *      找出i后面的最小数min。
 *      若arr[i]大于min则进行交换。
 */
public class SelectSort {
    public static void quick(int[] arr){
        for (int j = 0; j < arr.length - 1; j++) {
            // 假设第一个数为最小
            int min = arr[j];
            int index = 0;
            for (int i = j + 1; i < arr.length; i++) {
                if (min > arr[i]) {
                    min = arr[i];   // 将假设的数不是最小，将其换掉
                    index = i;      // 找出最小数的索引
                }
            }
            if(index != j) {
                arr[index] = arr[j];// 第一个数赋值给最小的数
                arr[j] = min;       // 最小的数赋值给第一个数
            }
        }
    }
    public static void quick1(int[] arr){
        // 以第i个数组为基准数
        for (int i = 0; i < arr.length - 1; i++) {
            // 与基准数交换的元素下标
            int p = i + 1;
            // 与基准数要交换的最小数
            int min = arr[i + 1];
            // 遍历除i以后的元素
            for (int j = i + 1; j < arr.length; j++) {
                // 找出最小的数及最小数的下标
                if (arr[j] < min) {
                    min = arr[j];
                    p = j;
                }
            }
            // 若基准数大于找出的最小数，则将两数进行交换
            if (arr[i] > min) {
                arr[p] = arr[i];
                arr[i] = min;
            }
        }
    }
    public static void main(String[] args){
//        int[] arr = {101, 119, 34, 1};
//        quick(arr);
        // 设置数组长度为80000，测试时间复杂度
        int[] arr = new int[80000];
        for(int i=0; i<80000; i++){
            arr[i] = (int)(Math.random()*8000000);
        }
        Long time1 = System.currentTimeMillis();
        quick(arr);
        Long time2 = System.currentTimeMillis();
        System.out.println(time2-time1);
    }
}
