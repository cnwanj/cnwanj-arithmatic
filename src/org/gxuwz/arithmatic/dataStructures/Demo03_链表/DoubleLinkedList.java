package org.gxuwz.arithmatic.dataStructures.Demo03_链表;

/**
 *  双向链表
 */
public class DoubleLinkedList {
    public static void main(String[] args){
        Node2 node1 = new Node2(1, "张三", "zs");
        Node2 node2 = new Node2(2, "李四", "ls");
        Node2 node3 = new Node2(3, "王五", "ww");
        Node2 node4 = new Node2(4, "赵六", "zl");
        DoubleLinked list = new DoubleLinked();

        // 测试添加节点
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);

        // 测试删除节点
//        list.delete(1);

        // 测试修改节点
//        list.update(new Node2(2, "李四--", "ls--"));

        // 测试顺序添加节点
//        list.addByOrder(node1);
//        list.addByOrder(node2);
//        list.addByOrder(node4);
//        list.addByOrder(node3);
        list.show(list.getHead());
    }
}
// 定义链表
class DoubleLinked{
    // 初始化头结点
    Node2 head = new Node2(0, "", "");
    // 返回头结点
    public Node2 getHead(){
        return head;
    }
    // 遍历显示链表信息
    public void show(Node2 head){
        if(head.next == null){
            System.out.println("链表为空！");
            return;
        }
        // 定义当前节点
        Node2 cur = head.next;
        while(cur != null){
            System.out.println(cur);
            cur = cur.next;
        }
    }
    // 添加节点
    public void add(Node2 node){
        Node2 temp = head;
        while(true){
            if(temp.next == null) break;
            temp = temp.next;
        }
        // 将当前节点下一个节点指向插入节点
        temp.next = node;
        // 将插入节点上一个接待指向当前节点
        node.pre = temp;
    }
    // 顺序添加链表
    public void addByOrder(Node2 node){
        Node2 temp = head;
        boolean flag = false;
        while(true){
            if(temp.next == null) {
                flag = true;
                break;
            }
            if(node.no < temp.next.no) {       // 若插入节点编号大于当前节点编号，插入
                flag = true;
                break;
            }else if(node.no == temp.next.no) {// 若等于，则不进行操作
                break;
            }
            temp = temp.next;
        }
        if(flag){   // 插入该节点
            node.next = temp.next;
            temp.next = node;
            node.pre = temp;
        }else{
            System.out.println("插入失败！该节点已存在");
        }
    }
    // 删除节点
    public void delete(int no){
        if(head.next == null){
            System.out.println("删除失败，链表为空!");
            return;
        }
        Node2 cur = head.next;
        while(true){
            if(cur == null){
                break;
            }
            if(no == cur.no){
                // 删除节点的前一个节点指向删除节点的后一个节点
                cur.pre.next = cur.next;
                // 判断是否为最后一个节点
                if(cur.next != null) {
                    // 删除的后一个节点指向删除的前一个节点
                    cur.next.pre = cur.pre;
                }
            }
            cur = cur.next;
        }
    }
    // 修改节点
    public void update(Node2 node){
        if(head.next == null) return;
        Node2 temp = head;
        while(true){
            if(temp.next == null) break;
            // 找到节点并修改
            if(node.no == temp.next.no){
                temp.name = node.name;
                temp.nickname = node.nickname;
                break;
            }
            temp = temp.next;
        }
    }
}
class Node2{
    public int no;
    public String name;
    public String nickname;
    public Node2 next;  // 下一个节点
    public Node2 pre;   // 前一个节点

    public Node2(int no, String name, String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Node2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
