package org.gxuwz.arithmatic.dataStructures.Demo07_查找;

import java.util.Arrays;

/**
 * 斐波那锲查找算法（黄建分割查找算法）
 */
public class FibonacciSearch {
    private static int maxSize = 20;
    // 获取斐波那锲数列
    public static int[] fib(){
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for(int i=2; i<maxSize; i++){
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }
    // 斐波那锲非递归方式查找
    public static int fibonacci(int[] arr, int value){
        int low = 0;
        int high = arr.length - 1;
        int k = 0;
        int mid = 0;
        int[] f = fib();
        // 找到斐波那锲与数组下标分割值对应
        while(high > f[k] - 1) // 因为数组下标从0开始
            k ++;
        // 将数组后面的值填充0
        int[] temp = Arrays.copyOf(arr, f[k]);
        // 将数组后面值进行最大值的填充
        for(int i=high + 1; i<temp.length; i++){
            temp[i] = arr[high];
        }
        // 通过while循环来查找
        while(low <= high){
            // 通过黄金分割：f[k-1]为数组的右边
            mid = low + f[k-1] - 1;
            if(value < temp[mid]){      // 向右边遍历查找
                high = mid - 1;
                k --;
            }else if(temp[mid] < value){// 向左边遍历查找
                low = mid + 1;
                k -= 2;
            }else{
                if(mid <= high)
                    return mid;
                else
                    return high;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int [] arr = {1,8, 10, 89, 1000, 1234};
        System.out.println(fibonacci(arr, 8));
    }
}
