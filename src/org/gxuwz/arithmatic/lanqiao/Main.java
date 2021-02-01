package org.gxuwz.arithmatic.lanqiao;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        System.out.println(arr.hashCode());
        System.out.println(arr2.hashCode());
    }
}


