package org.gxuwz.arithmatic.dataStructures.Demo06_排序;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {
    /**
     * 合并方法
     *
     * @param arr   原始数组
     * @param left  左边初始索引
     * @param mid   中间索引
     * @param right 右边初始值索引
     * @param temp  中转数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;   // 左边有序序列的初始索引
        int j = mid + 1;  // 右边序列的初始索引
        int t = 0;      // 指向中转下标的初始索引
        // 1、左边序列和右边序列的初始值依次比较，将小的填充到中转索引
        while (i <= mid && j <= right) {// 判断索引是否在范围内
            if (arr[i] <= arr[j]) {    // 若左边小于右边
                temp[t] = arr[i];
                i++;
                t++;
            } else {                  // 若右边小于左边
                temp[t] = arr[j];
                j++;
                t++;
            }
        }
        // 2、把剩余的数填充到中转数组
        while (i <= mid) {    // 左边剩下的数全部填充到中转数组
            temp[t] = arr[i];
            i++;
            t++;
        }
        while (j <= right) {  // 右边剩下的数全部填充到中转数组
            temp[t] = arr[j];
            j++;
            t++;
        }
        // 3、将中转数组填充到原始数组
        t = 0;
        int start = left;   // 原始数组初始下标
        while (start <= right) {
            arr[start] = temp[t];
            start++;
            t++;
        }
    }

    // 将原始数组分开并合并
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            // 向左分解
            mergeSort(arr, left, mid, temp);
            // 向右分解
            mergeSort(arr, mid + 1, right, temp);
            // 合并
            merge(arr, left, mid, right, temp);
        }
    }

    public static void main(String[] args) {
//        int[] arr = {2,6,1,3,6,4,9,5,0,7};
//        int[] temp = new int[arr.length];
//        mergeSort(arr, 0, arr.length-1, temp);
//        System.out.println(Arrays.toString(arr));
        // 测试速度
        int[] arr = new int[80000000];
        for (int i = 0; i < 80000000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        Long time1 = System.currentTimeMillis();
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        Long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);
    }
}
