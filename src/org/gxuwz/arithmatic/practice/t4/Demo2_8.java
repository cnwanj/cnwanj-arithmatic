package org.gxuwz.arithmatic.practice.t4;

import java.util.Vector;

/**
 * 希尔排序
 * 将数组长度除以2，所得的宽度进行两两比较进行交换
 * 然后再继续除以2，进行比较交换
 * 例如：
 * 9 8 7 6 5 4 3 2 1
 * 9 5 1 进行比较交换
 * 8 4   进行比较交换
 * 7 3   进行比较交换
 * 6 2   进行比较交换
 * 得到的数组：
 * 1 4 3 2 5 8 7 6 9
 * 再除以2进行比较...
 * 1 3
 * 3 5
 * 5 7
 * 7 9
 * 4 2
 * ...
 */
public class Demo2_8 {
    public static void shellSort(int[] arr){
        //将增量两两缩小
        for(int in = arr.length/2; in>0; in = in/2){
            //每减小一轮进行两两交换
            for(int i = in; i<arr.length; i++){
                //取出第一个数
                int target = arr[i];
                int j = i-in;
                //若为倒序，进行交换
                while(j>-1 && target<arr[j]){
                    //将前面的数赋给后面的数
                    arr[j+in] = arr[j];
                    //小-大为负数，退出循环= arr[j];
                    j -= in;
                }
                arr[j+in] = target;
            }
        }
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args){
        int[] arr = {9,8,3,4,5,2,1,6};
        shellSort(arr);
        Vector<String> s = new Vector<>();
        s.elements();
    }
}
