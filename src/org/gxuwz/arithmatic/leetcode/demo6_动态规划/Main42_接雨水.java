package org.gxuwz.arithmatic.leetcode.demo6_动态规划;

import java.util.Arrays;

/**
 * 给定n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 *
 * 示例 2：
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 * 提示：
 * n == height.length
 * 0 <= n <= 3 * 104
 * 0 <= height[i] <= 105
 */
public class Main42_接雨水 {

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
//        int[] arr = new int[]{1, 2, 1, 2, 3, 1, 0, 1, 2, 0, 1, 0};
//        int[] arr = new int[]{4, 2, 0, 3, 2, 5};
        System.out.println(trap(arr));
    }

    public static int trap(int[] height) {
        int len = height.length, max = 0, sum = 0;
        int[] left = new int[len];
        int[] right = new int[len];
        for (int i = 0; i < len; i++) {
            max = Math.max(height[i], max);
            left[i] = max;
        }
        max = 0;
        for (int i = len - 1; i >= 0; i--) {
            max = Math.max(height[i], max);
            right[i] = max;
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        System.out.println(Arrays.toString(height));
        for (int i = 1; i < len - 1; i++) {
            sum += Math.max(0, Math.min(left[i], right[i]) - height[i]);
        }
        return sum;
    }
}
