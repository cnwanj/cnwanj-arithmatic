package org.gxuwz.arithmatic.leetcode.demo7_二叉树;

import org.gxuwz.arithmatic.leetcode.demo.TreeNode;
/**
 * 101. 对称二叉树
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 */
public class Main101_对称二叉树 {

    public static boolean isSymmetric(TreeNode root) {
        return f(root, root);
    }

    public static boolean f(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;
        return f(p.left, q.right) && f(p.right, q.left);
    }
}
