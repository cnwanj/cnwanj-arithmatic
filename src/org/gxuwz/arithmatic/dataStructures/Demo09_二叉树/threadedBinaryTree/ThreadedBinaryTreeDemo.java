package org.gxuwz.arithmatic.dataStructures.Demo09_二叉树.threadedBinaryTree;

// 线索化二叉树
public class ThreadedBinaryTreeDemo {

    public static void main(String[] args) {
        // 测试线索化二叉树的功能
        Node root = new Node(1, "tom");
        Node node2 = new Node(3, "tom3");
        Node node3 = new Node(6, "tom6");
        Node node4 = new Node(8, "tom8");
        Node node5 = new Node(10, "tom10");
        Node node6 = new Node(14, "tom14");

        // 手动创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        // 创建二叉树
        Tree t = new Tree();
        t.setRoot(root);
        t.threadedTree();

        // 测试10号节点
        Node leftNode = node5.getLeft();
        System.out.println(leftNode);

        // 遍历线索化二叉树
        t.threadedList();   // 8, 3, 10, 1, 14, 6
    }
}

// 二叉树
class Tree {
    // 根节点
    private Node root;
    // 前驱节点
    private Node pre;

    public Node getRoot() {
        return root;
    }

    // 重载
    public void threadedTree() {
        this.threadedTree(root);
    }

    public void setRoot(Node root) {
        this.root = root;
    }

//    // 前序遍历
//    public void preOrder() {
//        if (this.root != null)
//            this.root.preOrder();
//        else
//            System.out.println("树空！");
//    }
//
//    // 中序遍历
//    public void infixOrder() {
//        if (this.root != null)
//            this.root.infixOrder();
//        else
//            System.out.println("树空！");
//    }
//
//    // 后序遍历
//    public void postOrder() {
//        if (this.root != null)
//            this.root.postOrder();
//        else
//            System.out.println("树空！");
//    }
//
//    // 前序遍历查找
//    public Node preOrderSearch(int id) {
//        // 若当前节点不为空
//        if (root != null)
//            return root.preOrderSearch(id);
//        else
//            return null;
//    }
//
//    // 中序遍历查找
//    public Node infixOrderSearch(int id) {
//        if (root != null)
//            return root.infixOrderSearch(id);
//        else
//            return null;
//    }
//
//    // 后序遍历查找
//    public Node postOrderSearch(int id) {
//        if (root != null)
//            return root.postOrderSearch(id);
//        else
//            return null;
//    }

    // 中序遍历线索化二叉树
    public void threadedList() {
        // 1、存储当前的遍历节点，从root开始
        Node node = root;
        while (node != null) {
            // 2、左节点查找，直到存在前驱节点
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }

            // 打印节点
            System.out.println(node);
            // 若当前节点的右指针指向后继节点，就一直输出
            while (node.getRightType() == 1) {
                // 右节点查找
                node = node.getRight();
                System.out.println(node);
            }

            // 替换当前遍历节点
            node = node.getRight();
        }
    }

    // 线索化二叉树，参数为要线索的节点
    public void threadedTree(Node node) {
        if (node == null)
            return;
        // 左节点递归，左线索化
        threadedTree(node.getLeft());

        // 若左节点为空，处理前驱节点
        if (node.getLeft() == null) {
            // 将左节点指向前驱节点
            node.setLeft(pre);
            // 设置状态为1
            node.setLeftType(1);
        }

        // 处理后继节点
        if (pre != null && pre.getRight() == null) {
            // 前驱节点的右指针指向当前节点
            pre.setRight(node);
            // 修改前驱节点的右指针类型
            pre.setRightType(1);
        }
        // 修改前驱节点的指向
        pre = node;

        // 右节点递归，右线索化
        threadedTree(node.getRight());
    }
}

// 节点
class Node {

    private int id;

    private String name;

    private Node left;

    private Node right;
    // 0：指向左子树，1：指向前驱节点
    private int leftType;
    // 0：指向右子树，1：指向后继节点
    private int rightType;

    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    // 前序遍历
//    public void preOrder() {
//        // 根节点
//        System.out.println(this);
//        // 左节点
//        if (this.left != null)
//            this.left.preOrder();
//        // 右节点
//        if (this.right != null)
//            this.right.preOrder();
//    }
//
//    // 中序遍历
//    public void infixOrder() {
//        // 左节点
//        if (this.left != null)
//            this.left.infixOrder();
//        // 根节点
//        System.out.println(this);
//        // 右节点
//        if (this.right != null)
//            this.right.infixOrder();
//    }
//
//    // 后序遍历
//    public void postOrder() {
//        // 左节点
//        if (this.left != null)
//            this.left.postOrder();
//        // 右节点
//        if (this.right != null)
//            this.right.postOrder();
//        // 根节点
//        System.out.println(this);
//    }
//
//    // 前序遍历查找
//    public Node preOrderSearch(int id) {
//        System.out.println("前序遍历查找");
//        // 根节点
//        if (this.id == id)
//            return this;
//        // 左节点
//        Node node = null;
//        if (this.left != null)
//            node = this.left.preOrderSearch(id);
//        if (node != null)
//            return node;
//        // 右节点
//        if (this.right != null)
//            node = this.right.preOrderSearch(id);
//        return node;
//    }
//
//    // 中序遍历查找
//    public Node infixOrderSearch(int id) {
//        // 左节点
//        Node node = null;
//        if (this.left != null)
//            node = this.left.infixOrderSearch(id);
//        if (node != null)
//            return node;
//        // 根节点
//        System.out.println("中序遍历查找");
//        if (this.id == id)
//            return this;
//        // 右节点
//        if (this.right != null)
//            node = this.right.infixOrderSearch(id);
//        return node;
//    }
//
//    // 后序遍历查找
//    public Node postOrderSearch(int id) {
//        // 左节点
//        Node node = null;
//        if (this.left != null)
//            node = this.left.postOrderSearch(id);
//        if (node != null) {
//            return node;
//        }
//        // 右节点
//        if (this.right != null)
//            node = this.right.postOrderSearch(id);
//        if (node != null) {
//            return node;
//        }
//        // 根节点
//        System.out.println("后续遍历查找");
//        if (this.id == id)
//            return this;
//        return node;
//    }
//
//    // 删除节点
//    public void deleteNode(int id) {
//        // 左节点
//        if (this.left != null && this.left.id == id) {
//            this.left = null;
//            return;
//        }
//        // 右节点
//        if (this.right != null && this.right.id == id) {
//            this.right = null;
//            return;
//        }
//        // 左节点递归
//        if (this.left != null)
//            this.left.deleteNode(id);
//        // 右节点递归
//        if (this.right != null) {
//            this.right.deleteNode(id);
//        }
//    }
}
