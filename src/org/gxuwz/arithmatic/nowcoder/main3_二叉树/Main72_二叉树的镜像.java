package org.gxuwz.arithmatic.nowcoder.main3_二叉树;

/**
 * 描述
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 比如：    源二叉树
 *              8
 *            /  \
 *           6   10
 *          / \  / \
 *         5  7 9 11
 *         镜像二叉树
 *              8
 *            /  \
 *           10   6
 *          / \  / \
 *         11 9 7  5
 *
 * 示例1
 * 输入：
 * {8,6,10,5,7,9,11}
 *
 * 返回值：
 * {8,10,6,11,9,7,5}
 */
public class Main72_二叉树的镜像 {

    public static TreeNode Mirror (TreeNode pRoot) {
        if (pRoot == null) {
            return null;
        }
        TreeNode temp;
        temp = pRoot.right;
        pRoot.right = pRoot.left;
        pRoot.left = temp;
        Mirror(pRoot.right);
        Mirror(pRoot.left);
        return pRoot;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(root);
        System.out.println(Mirror(root));
    }
}
