package org.gxuwz.arithmatic.dataStructures.Demo07_查找;

import java.util.Arrays;

import static org.gxuwz.arithmatic.dataStructures.Demo07_查找.BinarySearch.binary1;

/**
 * 插值查找算法：
 * mid = left + (right - left)*(value - arr[left])/(arr[right] - arr[left])
 */
public class InsertValueSearch {
    public static int insertValue(int[] arr, int left, int right, int value) {
        // 左边索引大于右边索引 || 查找值小于数组最小值 || 查找值大于数组最大值
        if (left > right || value < arr[0] || value > arr[arr.length - 1])
            return -1;
        int mid = left + (right + left) * (value - arr[left]) / (arr[right] - arr[left]);
        if (value < arr[mid])         // 向左边查找
            return insertValue(arr, left, mid - 1, value);
        else if (arr[mid] < value)    //向右查找
            return insertValue(arr, mid + 1, left, value);
        else
            return mid;
    }

    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++)
            arr[i] = i + 1;
        System.out.println(insertValue(arr, 0, arr.length - 1, 1));
    }
}
