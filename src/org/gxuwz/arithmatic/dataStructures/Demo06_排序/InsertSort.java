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
        for (int i = 1; i < arr.length; i++) {
            // 定义待插入的数
            int insertVal = arr[i];
            // 定义待插入的数前一位下标
            int index = i - 1;
            // 判断该下标是否大于0，前一位数是否大于待插入的数
            while (index >= 0 && arr[index] > insertVal) {
                // 将前一位数赋给待插入数位置
                arr[index + 1] = arr[index];
                // 下标-1
                index--;
            }
            // 将待插入的数插入到前一位数
            arr[index + 1] = insertVal;
        }
    }

    public static void main(String[] args){
        int[] arr = {17, 3, 25, 14, 20, 9};
        insert(arr);
        System.out.println(Arrays.toString(arr));

        // 测试排序算法速度
//        int[] arr = new int[80000];
//        for(int i=0; i<80000; i++){
//            arr[i] = (int)(Math.random()*8000000);
//        }
//        Long time1 = System.currentTimeMillis();
//        insert(arr);
//        Long time2 = System.currentTimeMillis();
//        System.out.println(time2-time1);
    }
}

/**
 * 第二次写
 */
class InsertSort1 {
    /**
     * while循环方法
     * @param arr
     */
    static void f1(int[] arr) {
        for (int i = 1, len = arr.length; i < len; i++) {
            // 待插入元素
            int val = arr[i];
            // 待插入元素前一位下标
            int index = i - 1;
            // 若待插入位置 > 0 && 已插入元素 > 待插入元素
            while (index >= 0 && arr[index] > val) {
                // 将已插入元素往后移
                arr[index + 1] = arr[index];
                // 下标往前移
                index--;
            }
            // 已插入元素 <= 当待插入元素，退出循环，将待插入元素插入到前一位
            arr[index + 1] = val;
        }
    }

    /**
     * for循环方法
     * @param arr
     */
    static void f2(int[] arr) {
        // 从第二个元素开始遍历待插入元素
        for (int i = 1, len = arr.length; i < len; i++) {
            // 定义待插入元素、待插入元素下标
            int val = arr[i], index = i;
            // 倒序遍历从待插入元素前一位开始
            for (int j = i - 1; j >= 0; j--) {
                // 若已插入元素 > 待插入元素
                if (arr[j] > val) {
                    // 将已插入元素往后移
                    arr[j + 1] = arr[j];
                    // 记录移动下标
                    index = j;
                }
            }
            // 将待插入元素插入数组中
            arr[index] = val;
        }
    }
}
