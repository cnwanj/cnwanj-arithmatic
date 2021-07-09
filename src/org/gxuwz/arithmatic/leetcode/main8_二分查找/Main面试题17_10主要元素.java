package org.gxuwz.arithmatic.leetcode.main8_二分查找;

/**
 * 面试题 17.10. 主要元素
 * 数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 * 示例 2：
 *
 * 输入：[3,2]
 * 输出：-1
 * 示例 3：
 *
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *
 * https://leetcode-cn.com/problems/find-majority-element-lcci/
 */
public class Main面试题17_10主要元素 {

    public static void main(String[] args) {
//        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        int[] arr = {1, 2, 5, 9, 5, 9, 5, 5, 5};
//        int[] arr = {1, 2};
        System.out.println(majorityElement(arr));
    }

    public static int majorityElement(int[] nums) {
        if (nums == null) return 0;
        // num表示众数，count用来计数
        int count = 1, num = nums[0];
        for (int i = 1; i < nums.length; i++)
            // 若找到相同元素
            if (num == nums[i])
                count++;
            else
                if (count > 0)
                    count--;
                else {
                    // 若计数为0，需要替换元素
                    num = nums[i];
                    count = 1;
                }
        // 找出众数个数
        if (count > 0)
            for (int i = count = 0; i < nums.length; i++)
                if (nums[i] == num)
                    count++;
        // 若众数大于一半则返回
        return count > nums.length >> 1 ? num : -1;
    }
}
