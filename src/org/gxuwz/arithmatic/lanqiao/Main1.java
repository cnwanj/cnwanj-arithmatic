package org.gxuwz.arithmatic.lanqiao;

import java.util.Arrays;

public class Main1 {

    public static void main(String[] args) {
        int[] arr = {8, 3, 5, 2, 3, 6, 1, 7, 9};
        f(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void f(int[] arr) {
        for (int i = 0, len = arr.length - 1; i < len; i++) {
            int min = arr[i], index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }
            if (arr[i] > min) {
                arr[index] = arr[i];
                arr[i] = min;
            }
        }
    }
}
