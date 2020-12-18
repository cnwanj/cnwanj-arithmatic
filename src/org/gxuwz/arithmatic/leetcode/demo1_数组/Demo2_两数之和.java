package org.gxuwz.arithmatic.leetcode.demo1_数组;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: vovhh
 * @Date: 2020-12-12 19:47:09
 * @Description:
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Demo2_两数之和 {
    public static void main(String[] args) {
        int target = 9;

        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, target)));
    }
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0, len = nums.length; i < len; i++) {
            if (map.containsKey(nums[i]))
                return new int[]{map.get(nums[i]), i};
            map.put(target - nums[i], i);
        }
        return null;
//        for (int i = 0, len = nums.length; i < len - 1; i++) {
//            for (int j = i + 1; j < len; j++) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return null;

//        int[] indexs = new int[2];
//        // 建立k-v ，一一对应的哈希表
//        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
//        for(int i = 0; i < nums.length; i++){
//            if(map.containsKey(nums[i])){
//                indexs[0] = i;
//                indexs[1] = map.get(nums[i]);
//                return indexs;
//            }
//            // 将数据存入 key为补数 ，value为下标
//            map.put(target-nums[i],i);
//        }
//        return indexs;
    }
}
