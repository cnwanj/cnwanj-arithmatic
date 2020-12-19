package org.gxuwz.arithmatic.lanqiao;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = {6, 3, 9, 2, 1, 6, 3, 9, 1, 6, 7, 10};
        f2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    static void f(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int mid = arr[(left + right) / 2];
        while (l < r) {
            while (arr[l] < mid)
                l += 1;
            while (mid < arr[r])
                r -= 1;
            if (l >= r)
                break;

            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if (arr[l] == mid)
                r -= 1;
            if (arr[r] == mid)
                l += 1;
        }
        if (l == r) {
            l += 1;
            r -= 1;
        }
        if (left < r)
            f(arr, left, r);
        if (l < right)
            f(arr, l, right);
    }

    static void f1(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int mid = arr[(left + right) / 2];
        while(l < r) {
            while(arr[l] < mid)
                l += 1;
            while(mid < arr[r])
                r -= 1;
            if (l >= r)
                break;

            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if(arr[l] == mid)
                r -= 1;
            if(arr[r] == mid)
                l += 1;
        }
        if(l == r) {
            l += 1;
            r -= 1;
        }
        if(left < r)
            f1(arr, left, r);
        if(l < right)
            f1(arr, l, right);
    }

    static void f2(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int mid = arr[(left + right) / 2];
        int temp;
        while (l < r) {
            while (arr[l] < mid)
                l++;
            while (mid < arr[r])
                r--;
            if (l >= r)
                break;
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == mid)
                r--;
            if (arr[r] == mid)
                l++;
        }
        if (l == r)
            l++;
            r--;
        if (left < r)
            f2(arr, left, r);
        if (l < right)
            f2(arr, l, right);
    }
}
