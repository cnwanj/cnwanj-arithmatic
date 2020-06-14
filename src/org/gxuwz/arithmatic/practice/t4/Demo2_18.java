package org.gxuwz.arithmatic.practice.t4;

/**
 * 有空字符串的有序字符串数组查找：
 * 有一个排序后的字符串数组，其中散步着一些空字符串，
 * 编写一个方法，找出给定字符串（不能是空字符串）的索引
 */
public class Demo2_18 {
    public static int f(String[] arr, String p) {
        int begin = 0;
        int end = arr.length - 1;
        while (begin <= end) {
            int mid = begin + ((end - begin) >> 1);
            while (arr[mid].equals("")) {
                mid++;
                if (mid > end)
                    return -1;
            }
            //如果中间值比目标值p大
            if (arr[mid].compareTo(p) > 0) {
                end = mid - 1;
            } else if (arr[mid].compareTo(p) < 0) {
                begin = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] arr = {"a", "", "ac", "", "ad", "b", "", "ba"};
        System.out.println(f(arr, "ab"));
    }
}
