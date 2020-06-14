package org.gxuwz.arithmatic.dataStructures.Demo06_排序;

import java.util.Arrays;
/**
 * 插入排序
 * 思路：
 *   1、定义待插入的数
 *   2、定义待插入的数前一位下标
 *   3、判断该下标是否大于0，前一位数是否大于待插入的数
 *   4、将前一位数赋给待插入数位置
 *   5、下标-1
 *   6、将待插入的数插入到前一位数
 */
public class InsertSort {
    public static void insert(int[] arr){
        int insertVal = 0;
        int index = 0;
        for(int i=1; i<arr.length; i++){
            // 定义待插入的数
            insertVal = arr[i];
            // 定义待插入的数前一位下标
            index = i-1;
            // 判断该下标是否大于0，前一位数是否大于待插入的数
            while(index >= 0 && arr[index] > insertVal){
                // 将前一位数赋给待插入数位置
                arr[index+1] = arr[index];
                // 下标-1
                index--;
            }
            // 将待插入的数插入到前一位数
            arr[index+1] = insertVal;
//            System.out.println(Arrays.toString(arr));
        }
    }
    public static void main(String[] args){
//        int[] arr = {101, 34, 119, 1};
//        insert(arr);
        // 测试排序算法速度
        int[] arr = new int[80000];
        for(int i=0; i<80000; i++){
            arr[i] = (int)(Math.random()*8000000);
        }
        Long time1 = System.currentTimeMillis();
        insert(arr);
        Long time2 = System.currentTimeMillis();
        System.out.println(time2-time1);
    }
}
