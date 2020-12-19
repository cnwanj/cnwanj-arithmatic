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
