package org.gxuwz.arithmatic.dataStructures.Demo09_二叉树;

public class BinaryTreeDemo {

    public static void main(String[] args) {
        // 创建二叉树
        Tree tree = new Tree();
        // 创建节点
        Node root = new Node(1, "宋江");
        Node n2 = new Node(2, "吴用");
        Node n3 = new Node(3, "卢俊义");
        Node n4 = new Node(4, "林冲");
        Node n5 = new Node(5, "关胜");

        // 将根节点放入树中
        root.setLeft(n2);
        root.setRight(n3);
        n3.setLeft(n5);
        n3.setRight(n4);
        tree.setRoot(root);

        System.out.println("前序遍历");
        tree.preOrder();
//        System.out.println("中序遍历");
//        root.infixOrder();
//        System.out.println("后序遍历");
//        root.postOrder();
        // 前序遍历查找
//        System.out.println(tree.preOrderSearch(5));
//        System.out.println(tree.infixOrderSearch(5));
//        System.out.println(tree.postOrderSearch(5));
        tree.deleteNode(3);
        System.out.println("删除后的树节点");
        tree.preOrder();
    }
}

// 二叉树
class Tree {
    // 根节点
    private Node root;

    public void setRoot(Node node) {
        this.root = node;
    }

    // 前序遍历
    public void preOrder() {
        // 若根节点不为空
        if (this.root != null)
            this.root.preOrder();
        else
            System.out.println("二叉树为空，无法遍历！");
    }

    // 中序遍历
    public void infixOrder() {
        // 判断根节点不为空
        if (this.root != null)
            this.root.infixOrder();
        else
            System.out.println("二叉树为空，无法遍历！");
    }

    // 后续遍历
    public void postOrder() {
        if (this.root != null)
            this.root.postOrder();
        else
            System.out.println("二叉树为空，无法遍历！");
    }

    // 前序遍历查找
    public Node preOrderSearch(int id) {
        // 若当前节点不为空
        if (root != null)
            return root.preOrderSearch(id);
        else
            return null;
    }

    // 中序遍历查找
    public Node infixOrderSearch(int id) {
        if (root != null)
            return root.infixOrderSearch(id);
        else
            return null;
    }

    // 后序遍历查找
    public Node postOrderSearch(int id) {
        if (root != null)
            return root.postOrderSearch(id);
        else
            return null;
    }

    // 遍历删除
    public void deleteNode(int id) {
        // 判断根节点是否为空
        if (root != null) {
            if (root.getId() == id) {
                // 若左节点不为空，赋值给当前节点
//                if (root.getLeft() != null) {
//                    root = root.getLeft();
//                    return;
//                } else if (root.getRight() != null) {
//                    root = root.getRight();
//                    return;
//                } else {
                root = null;
//                }
            } else {
                root.deleteNode(id);
            }
        } else
            System.out.println("树空");
    }
}

// 节点
class Node {

    private int id;
    private String name;
    // 左节点
    private Node left;
    // 右节点
    private Node right;

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

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    // 前序遍历
    public void preOrder() {
        // 先输出根节点
        System.out.println(this);
        // 若左节点不为空，左查找
        if (this.left != null)
            this.left.preOrder();
        // 若右节点不为空，右查找
        if (this.right != null)
            this.right.preOrder();
    }

    // 中序遍历
    public void infixOrder() {
        // 左节点不为空
        if (left != null)
            this.left.infixOrder();
        // 输出当前节点
        System.out.println(this);
        // 右节点不为空
        if (right != null)
            this.right.infixOrder();
    }

    // 后续遍历
    public void postOrder() {
        if (left != null)
            this.left.postOrder();
        if (right != null)
            this.right.postOrder();
        System.out.println(this);
    }

    // 前序遍历查找
    public Node preOrderSearch(int id) {
        System.out.println("前序遍历查找");
        // 判断当前节点是否为查找对象
        if (this.id == id)
            return this;

        Node node = null;
        // 左节点查找
        if (this.left != null)
            node = this.left.preOrderSearch(id);
        // 若节点不为空
        if (node != null)
            return node;
        // 右节点查找
        if (this.right != null)
            node = this.right.preOrderSearch(id);
        return node;
    }

    // 中序遍历查找
    public Node infixOrderSearch(int id) {
        Node node = null;
        // 左节点遍历
        if (this.left != null) {
            node = this.left.infixOrderSearch(id);
        }
        // 若节点不为空
        if (node != null) {
            return node;
        }

        System.out.println("中序遍历查找");
        // 返回当前节点
        if (this.id == id)
            return this;

        // 右节点遍历
        if (this.right != null)
            node = this.right.infixOrderSearch(id);

        return node;
    }

    // 后续遍历查找
    public Node postOrderSearch(int id) {
        Node node = null;
        // 1、左节点查找
        if (this.left != null)
            node = this.left.postOrderSearch(id);
        if (node != null)
            return node;

        // 2、右节点查找
        if (this.right != null)
            node = this.right.postOrderSearch(id);
        if (node != null)
            return node;

        System.out.println("后序遍历查找");
        // 若左节点和右节点都找不到
        if (this.id == id)
            return this;
        return node;
    }

    // 前序遍历删除节点
    public void deleteNode(int id) {
        // 左节点遍历
        if (this.left != null && this.left.id == id) {
            // 判断左节点的左节点是否为空，不为空将左子节点的左赋给当前节点的左节点
//            if (this.left.left != null) {
//                this.left = this.left.left;
//                //this.left.left = null;
//                return;
//            }
            // 删除该节点
            this.left = null;
            return;
        }
        // 右节点遍历
        if (this.right != null && this.right.id == id) {
            // 将右节点的左节点赋给当前节点
//            if (this.right.left != null) {
//                this.right = this.right.left;
//                return;
//            } else if (this.right.right != null) {
//                this.right = this.right.right;
//                return;
//            }
            // 删除右节点
            this.right = null;
            return;
        }

        // 左节点递归删除
        if (this.left != null)
            this.left.deleteNode(id);
        // 右节点递归删除
        if (this.right != null)
            this.right.deleteNode(id);
    }
}
