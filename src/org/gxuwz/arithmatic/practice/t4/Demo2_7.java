package org.gxuwz.arithmatic.practice.t4;

/**
 * 二分法查找
 */
public class Demo2_7 {
    static int f(int[] arr, int low, int high, int key) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        int midVal = arr[mid];
        if (midVal < key) {
            return f(arr, mid + 1, high, key);

        } else if (midVal > key) {
            return f(arr, low, high - 1, key);
        } else {
            return mid;
        }

    }
}
