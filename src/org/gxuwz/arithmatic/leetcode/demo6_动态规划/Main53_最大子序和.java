package org.gxuwz.arithmatic.leetcode.demo6_动态规划;

import java.util.Scanner;

/**
 * 53. 最大子序和
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：0
 * 示例 4：
 *
 * 输入：nums = [-1]
 * 输出：-1
 * 示例 5：
 *
 * 输入：nums = [-100000]
 * 输出：-100000
 *
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * -105 <= nums[i] <= 105
 *
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 *
 * 思路
 * 1.定义max存储最大值，sum为每次遍历的子序和。
 * 2.若sum为非负数，进行累加，若sum为负数，替换为当前下标元素。
 * 3.每经过一个元素都将sum和max进行比较，获取最大值。
 */
public class Main53_最大子序和 {

    /**
     * -2 1 -3 4 -1 2 1 -5 4
     * -2 -1 -3 -6 -4 -5
     * 1 -3 2 3 1
     * 5 4 -1 7 8
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int[] arr = new int[s.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        System.out.println(maxSubArray(arr));
    }

    public static int maxSubArray(int[] nums) {
        int sum = 0, max = nums[0];
        for (int num : nums) {
            if (sum > 0) {
                // 若元素大于0，进行累加，获取最大和
                sum += num;
            } else {
                // 若元素小于等于0，进行直接比较，获取最大的负数
                sum = num;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
