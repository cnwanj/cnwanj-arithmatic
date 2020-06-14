package org.gxuwz.arithmatic.leetcode.demo5_排序和搜索;

import java.util.Arrays;

/*
合并两个有序数组
给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。

说明:

初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。

示例:

输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]
 */
public class Demo1_合并两个有序数组 {

    public static void main(String[] args) {
//        int[] a = new int[]{2, 5, 6, 0};
//        int b = 3;
//        for (int i = 0; i < a.length; i++) {
//            if (a[i] >= b) {
//                for (int j = a.length - 1; j > i; j--) {
//                    a[j] = a[j-1];
//                }
//                a[i] = b;
//                break;
//            }
//        }
//        System.out.println(Arrays.toString(a));
        int[] a = {1, 2, 3, 0, 0, 0};
        int[] b = {2, 5, 6};
        merge(a, 3, b, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        int j = 0;
//        for (int i = 0; i < n; i++) {
//            while(j < nums1.length) {
//                if (nums1[j] >= nums2[i]) {
//                    for (int k = nums1.length - 1; k > j; k--) {
//                        nums1[k] = nums1[k - 1];
//                    }
//                    nums1[j] = nums2[i];
//                    j ++;
//                    break;
//                }
//                j ++;
//            }
//            if (j == nums1.length) {
//                nums1[m + i] = nums2[i];
//            }
//        }
        int j = 0;
        for (int i = nums1.length - 1; i >= m; i--) {
            nums1[i] = nums2[j++];
        }
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }
}
