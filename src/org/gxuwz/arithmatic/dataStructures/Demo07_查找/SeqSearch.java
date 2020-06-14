package org.gxuwz.arithmatic.dataStructures.Demo07_查找;

/**
 * 线性查找
 */
public class SeqSearch {
    public static int seq(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 9, 11, 67, 4, 8, 33};
        int n = seq(arr, 4);
        if (n == -1)
            System.out.println("该数不存在！");
        else
            System.out.println("该数的下标为：" + n);
    }
}
