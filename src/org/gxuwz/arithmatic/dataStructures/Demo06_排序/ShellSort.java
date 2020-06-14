package org.gxuwz.arithmatic.dataStructures.Demo06_排序;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {
    // 1、交换法，效率低
    public static void shell(int[] arr) {
        int temp = 0;
        for (int k = arr.length / 2; k > 0; k /= 2) {
            // 逐步推演，第一次步长为5
            for (int i = k; i < arr.length; i++) {
                // 步长之间的元素进行逐步交换
                for (int j = i - k; j >= 0; j -= k) {
                    if (arr[j] > arr[j + k]) {
                        temp = arr[j + k];
                        arr[j + k] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    // 移位法，高效
    public static void shell1(int[] arr) {
        // 循环遍历，每次将步长/2
        for (int i = arr.length / 2; i > 0; i /= 2) {
            // 以步长为起始位置，遍历要交换的数
            for (int j = i; j < arr.length; j++) {
                int in = j;      // 将待插入的数下标保存到变量中
                int temp = arr[j];  // 将待插入的元素保存到变量中
                // 判断当前下标-步长是否大于0，元素是否大于后面一位
                while (in - i >= 0 && arr[in - i] > temp) {
                    arr[in] = arr[in - i];    // 将前面位数赋值给后面位数
                    in -= i;
                }
                // 将待插入元素赋值给前面那位
                arr[in] = temp;
            }
        }
//        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
//        int[] arr = {8,9,1,7,2,3,5,4,6,0,12,11};
//        shell1(arr);
        int[] arr = new int[20000000];
        for (int i = 0; i < 20000000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        Long time1 = System.currentTimeMillis();
        shell1(arr);
        Long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);
    }
}
