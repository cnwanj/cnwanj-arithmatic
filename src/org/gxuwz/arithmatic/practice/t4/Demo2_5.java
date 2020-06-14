package org.gxuwz.arithmatic.practice.t4;

/**
 * 插入排序找递归
 */
public class Demo2_5 {
    static void insert(int[] arr, int k) {
        if (k == 0) {
            return;
        }
        //  对k-1进行排序
        insert(arr, k - 1);
        //  把位置k的元素插入到前面部分
        int x = arr[k];
        int index = k - 1;
        while (index > -1 && x < arr[index]) {
            arr[index + 1] = arr[index];
            index--;
        }
        arr[index + 1] = x;
    }
}
