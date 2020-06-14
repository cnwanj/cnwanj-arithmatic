package org.gxuwz.arithmatic.dataStructures.Demo09_二叉树;

public class ArrBinaryTreeDemo {
    /*
     * 数组存储二叉树
     * 当前节点下标：n
     * 当前节点左节点下标：2 * n + 1
     * 当前节点右节点下标：2 * n + 2
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree tree = new ArrBinaryTree(arr);
        tree.preOrder();
        System.out.println();
        tree.infixOrder(0);
        System.out.println();
        tree.laterOrder(0);
    }
}

class ArrBinaryTree {
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    // 重载
    public void preOrder() {
        this.preOrder(0);
    }

    // 前序遍历：根节点 -> 左节点 -> 右节点
    public void preOrder(int n) {
        if (arr.length == 0 || arr == null) {
            System.out.println("空");
            return;
        }
        // 输出当前元素
        System.out.print(arr[n]);
        // 向左递归
        if ((2 * n + 1) < arr.length) {
            preOrder(2 * n + 1);
        }
        // 向右递归
        if ((2 * n + 2) < arr.length) {
            preOrder(2 * n + 2);
        }
    }

    // 中序遍历：左节点 -> 根节点 -> 右节点
    public void infixOrder(int n) {
        if (arr.length == 0 || arr == null) {
            System.out.println("空");
        }
        // 左节点递归
        if ((2 * n + 1) < arr.length) {
            infixOrder(2 * n + 1);
        }
        // 输出当前节点
        System.out.print(arr[n]);
        // 右节点递归
        if ((2 * n + 2) < arr.length) {
            infixOrder(2 * n + 2);
        }
    }

    // 后序遍历：左节点 -> 右节点 -> 根节点
    public void laterOrder(int n) {
        if (arr.length == 0 || arr == null) {
            System.out.println("空");
        }
        // 左节点递归
        if ((2 * n + 1) < arr.length) {
            laterOrder(2 * n + 1);
        }
        // 右节点递归
        if ((2 * n + 2) < arr.length) {
            laterOrder(2 * n + 2);
        }
        // 输出当前节点
        System.out.print(arr[n]);
    }
}
