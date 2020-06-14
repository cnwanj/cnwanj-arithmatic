package org.gxuwz.arithmatic.dataStructures.Demo06_排序;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {
    public static void quick(int[] arr, int left, int right) {
        int l = left;                   // 保存最左边元素
        int r = right;                  // 保存最右边元素
        int pivot = arr[(left + right) / 2];// 算出中轴
        int temp = 0;
        // 若左边小于右边，循环交换中轴两边的数
        while (l < r) {
            // 如果左边元素小于中轴元素，将左元素下标+1
            while (arr[l] < pivot) {
                l++;
            }
            // 若右边元素大于中轴元素，将右边元素下标-1
            while (pivot < arr[r]) {
                r--;
            }
            // 判断左下标是否大于等于右下标，若大于等于则break，退出循环
            if (l >= r) {
                break;
            }
            // 将左边元素和右边元素进行交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            // 交换后判断左边元素是否与中轴相等
            if (arr[l] == pivot) {
                r--;
            }
            // 交换后判断右边元素是否与中轴相等
            if (arr[r] == pivot) {
                l++;
            }
        }
        // 若左边下标和右边下标相等，将其错位移开，防止栈溢出
        if (l == r) {
            l++;
            r--;
        }
        // 向左边递归，右边元素改变
        if (left < r) {
            quick(arr, left, r);
        }
        // 向右边递归，左边元素改变
        if (l < right) {
            quick(arr, l, right);
        }
    }

    public static void quick1(int[] arr, int start, int end) {
        if (start < end) {
            // 把第0个作为基准数
            int first = arr[start];
            // 记录高位和低位的下标
            int low = start;
            int high = end;
            // 循环找出比基准数大而且比基准数小的数
            while (low < high) {
                // 右边数比基准数大，将下标往左移动
                while (low < high && first < arr[high]) {
                    high--;
                }
                // 将右边的数替换掉左边的
                arr[low] = arr[high];
                // 左边数比基准数小，将下标往右移
                while (low < high && arr[low] < first) {
                    low++;
                }
                // 将左边数替换掉右边的
                arr[high] = arr[low];
            }
            // 把基准数赋给低位所在的数
            arr[low] = first;
            quick1(arr, start, low);
            quick1(arr, low + 1, end);
        }
    }

    public static void main(String[] args) {
//        int[] arr = {8,9,1,7,2,3,5,4,6,0,12,11};
//        quick1(arr, 0, arr.length-1);
//        System.out.println(Arrays.toString(arr));
        int[] arr = new int[80000000];
        for (int i = 0; i < 80000000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        Long time1 = System.currentTimeMillis();
        quick(arr, 0, arr.length - 1);
        Long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);
    }
}
