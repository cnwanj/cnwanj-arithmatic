package org.gxuwz.arithmatic.nowcoder.main3_二叉树;

/**
 * 描述
 * 给定一棵二叉树，判断其是否是自身的镜像（即：是否对称）
 * 例如：下面这棵二叉树是对称的
 *     1
 *   /  \
 *  2    2
 * / \  / \
 * 3 4 4  3
 * 下面这棵二叉树不对称。
 *   1
 * /  \
 * 2   2
 * \    \
 * 3    3
 * 备注：
 * 希望你可以用递归和迭代两种方法解决这个问题
 *
 * 示例1
 * 输入：
 * {1,2,2}
 * 返回值：
 * true
 *
 * 示例2
 * 输入：
 * {1,2,3,3,#,2,#}
 * 返回值：
 * false
 */
public class Main16_判断二叉树是否对称 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right = new TreeNode(1);
        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric (TreeNode root) {
        return f(root, root);
    }

    public static boolean f(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return f(left.left, right.right) && f(left.right, right.left);
    }
}
