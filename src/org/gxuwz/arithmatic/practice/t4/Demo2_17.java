package org.gxuwz.arithmatic.practice.t4;

/**
 * 数组旋转：
 * 求一个旋转数组的最小值
 * 例如：数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1
 */
public class Demo2_17 {
    public static int f(int[] arr){
        int begin = 0;
        int end = arr.length-1;
        //若数组没有旋转
        if(arr[begin] < arr[end]) return arr[begin];

        //当begin和end指向相邻元素时退出
        while(begin+1 < end){
            int mid = begin+((end-begin)>>1);
            //要么左侧有序
            if(arr[begin] <= arr[mid]){
                begin = mid;
            }else{//要么右侧有序
                end = mid;
            }
        }
        return arr[end];
    }

    public static int f1(int[] a){
        int begin = 0;
        int end = a.length-1;
        if(a[begin] < a[end])       //若该数组没有旋转，为有序,直接返回第一个数
            return a[begin];
        while(begin+1 < end){       //若为相邻元素，退出循环
            int mid = begin+(end-begin)/2;
            if(a[begin] < a[mid]){  //若左边有序
                begin = mid;
            }else{                  //若右边有序
                end = mid;
            }
        }
        return a[end];
    }

    public static void main(String[] args){
        int[] arr = {3,4,5,1,2};
        System.out.println(f(arr));
    }
}
