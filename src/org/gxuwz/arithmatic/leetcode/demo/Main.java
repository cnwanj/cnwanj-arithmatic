package org.gxuwz.arithmatic.leetcode.demo;

public class Main {

    public TreeNode f(int[] nums) {
        return nums == null ? null : tree(nums, 0, nums.length - 1);
    }

    public TreeNode tree(int[] nums, int l, int r) {
        if (l > r) return null;
        int m = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = tree(nums, l, m - 1);
        root.right = tree(nums, m + 1, r);
        return root;
    }
}
