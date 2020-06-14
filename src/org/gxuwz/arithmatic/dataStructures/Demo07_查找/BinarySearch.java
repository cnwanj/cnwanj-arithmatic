package org.gxuwz.arithmatic.dataStructures.Demo07_查找;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分法查找
 */
public class BinarySearch {
    // 循环思想
    public static int binary(int[] arr, int n) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            System.out.println("hello");
            int mid = (left + right) / 2;
            if (n < arr[mid]) { // 向左寻找
                right = mid - 1;
            }
            if (arr[mid] < n) { // 向右寻找
                left = mid + 1;
            }
            if (arr[mid] == n) {
                return mid;
            }
        }
        return -1;
    }

    // 递归思想
    public static int binary1(int[] arr, int left, int right, int n) {
        System.out.println("hello");
        if (left > right)   //结束条件
            return -1;
        int mid = (left + right) / 2;
        if (arr[mid] > n) {      // 向左递归
            return binary1(arr, left, mid - 1, n);
        } else if (n > arr[mid]) {// 向右递归
            return binary1(arr, mid + 1, right, n);
        } else {
            return mid;
        }
    }

    // 查找多位
    public static List<Integer> binary2(int[] arr, int left, int right, int n) {
        int mid = (left + right) / 2;
        int value = arr[mid];
        if (left >= right)   //结束条件
            return null;
        if (value > n) {      // 向左递归
            return binary2(arr, left, mid - 1, n);
        } else if (n > value) {// 向右递归
            return binary2(arr, mid + 1, right, n);
        } else {
            List<Integer> list = new ArrayList<>();
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != n)
                    break;
                list.add(temp);
                temp--;
            }
            list.add(mid);
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != n)
                    break;
                list.add(temp);
                temp++;
            }
            return list;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 9};
        System.out.println(binary1(arr, 0, arr.length - 1, 1));
    }
}
