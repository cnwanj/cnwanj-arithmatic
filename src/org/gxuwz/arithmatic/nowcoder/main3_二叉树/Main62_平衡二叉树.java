package org.gxuwz.arithmatic.nowcoder.main3_二叉树;

/**
 * 平衡二叉树
 *
 * # 描述
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 * 平衡二叉树（Balanced Binary Tree），具有以下性质：
 * 它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，
 * 并且左右两个子树都是一棵平衡二叉树。
 *
 * 注：我们约定空树是平衡二叉树。
 *
 * ## 示例1
 * 输入：
 * {1,2,3,4,5,6,7}
 * 返回值：
 * true
 */
public class Main62_平衡二叉树 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.setVal(0);
        root.setLeft(new TreeNode(1));
        root.setRight(new TreeNode(1));
//        root.getLeft().setRight(new TreeNode(1));
        System.out.println(IsBalanced_Solution(root));
    }

    public static boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return true;
        // 若左右两棵子树的高度差不超过1
        if (Math.abs(depth(root.left) - depth(root.right)) > 1) return false;
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    public static int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
