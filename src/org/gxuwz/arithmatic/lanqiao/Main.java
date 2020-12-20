package org.gxuwz.arithmatic.lanqiao;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
//        f(arr);
//        System.out.println(Arrays.toString(arr));

        // 2559
        int[] arr = new int[10000000];
        for (int i = 0; i < 10000000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        Long time1 = System.currentTimeMillis();
        f(arr);
        Long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);
    }

    /**
     * 交换法
     * @param arr
     */
    static void f(int[] arr) {
        for (int len = arr.length, i = len / 2; i > 0; i /= 2) {
            for (int k = i; k < len; k++) {
                boolean tag = true;
                for (int j = i; j < len; j++) {
                    // 前面大于后面的，进行交换
                    if (arr[j - i] > arr[j]) {
                        tag = false;
                        int temp = arr[j - i];
                        arr[j - i] = arr[j];
                        arr[j] = temp;
                    }
                }
                if (tag)
                    break;
            }
        }
    }
}
