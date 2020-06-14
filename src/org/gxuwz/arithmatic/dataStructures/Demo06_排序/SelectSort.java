package org.gxuwz.arithmatic.dataStructures.Demo06_排序;

import java.util.Arrays;
/**
 * 选择排序
 * 思路：先推算出第一躺的数字交换，再进行完善
 *      [101, 119, 34, 1]
 *      [1, 119, 34, 101]
 *      [1, 34, 119, 101]
 *      [1, 34, 101, 119]
 */
public class SelectSort {
    public static void quick(int[] arr){
        for(int j=0; j<arr.length-1; j++) {
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
//            System.out.print(Arrays.toString(arr));
//            System.out.println();
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
