package org.gxuwz.arithmatic.lanqiao.dasai.basic;

import java.util.Scanner;

public class Demo1_数列排序 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if(n >= 1 && n <= 200){
            int[] arr = new int[n];
            for (int i = 0; i < n; i++){
                arr[i] = scan.nextInt();
            }
            // 冒泡排序
            boolean f = false;
            for (int i = 0; i < arr.length-1; i++){
                for (int j = 0; j < arr.length-1-i; j++){
                    if(arr[j] > arr[j + 1]){
                        f = true;
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
                if(f)
                    f = false;
                else
                    break;
            }
            for(int i = 0; i < arr.length; i++)
                System.out.print(arr[i]+" ");
        }
    }
}
