package org.gxuwz.arithmatic.lanqiao;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = {17, 3, 25, 14, 20, 9};
        f(arr);

    }

    static void f(int[] arr) {
        int[] arr1 = new int[arr.length];
        arr1[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            // 标记是否有元素插入
            boolean tag = true;
            for (int j = 0; j < i; j++) {
                // 若待插入元素 <= 新数组中的元素
                if (arr[i] <= arr1[j]) {
                    tag = false;
                    // 将元素插入
                    insert(arr1, j, arr[i], i);
                    break;
                }
            }
            // 若待插入元素没有插入，则将元素赋值给新数组最后一位
            if (tag) {
                // 将元素赋值最后一位
                arr1[i] = arr[i];
            }
        }
        System.out.println(Arrays.toString(arr1));
    }

    /**
     * 将元素插入指定的位置
     * @param arr1  被插入元素
     * @param p     插入下标
     * @param ele   插入元素
     * @param end   新数组结尾下标
     */
    static void insert(int[] arr1, int p, int ele, int end) {
        for (int i = end; i > p; i--) {
            arr1[i] = arr1[i - 1];
        }
        arr1[p] = ele;
    }
}
