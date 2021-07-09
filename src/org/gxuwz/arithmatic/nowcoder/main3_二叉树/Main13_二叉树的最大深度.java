package org.gxuwz.arithmatic.nowcoder.main3_二叉树;

/**
 * 描述
 * 求给定二叉树的最大深度，
 * 最大深度是指树的根结点到最远叶子结点的最长路径上结点的数量。
 *
 * 示例1
 * 输入：
 * {1,2}
 * 返回值：
 * 2
 *
 * 示例2
 * 输入：
 * {1,2,3,4,#,#,5}
 * 返回值：
 * 3
 */
public class Main13_二叉树的最大深度 {

    public static void main(String[] args) throws Exception {
        TreeNode root = new TreeNode();
        root.setVal(0);
        root.setLeft(new TreeNode(1));
        root.setRight(new TreeNode(1));
        root.getLeft().setRight(new TreeNode(1));
        System.out.println(maxDepth(root));
    }

    public static int maxDepth (TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return Math.max(l, r) + 1;
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}