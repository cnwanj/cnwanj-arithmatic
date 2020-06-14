package org.gxuwz.arithmatic.dataStructures.Demo08_哈希表;

import java.util.Scanner;

/**
 * 哈希表（散链表）
 */
public class HashTable {
    public static void main(String[] args) {
        // 实例化一个哈希表
        HashTab hashTab = new HashTab(7);
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("a：添加");
            System.out.println("l：显示");
            System.out.println("f：查找");
            System.out.println("d：删除");
            System.out.println("u：修改");
            System.out.println("e：退出");
            String s = input.next();
            switch (s) {
                case "a":
                    System.out.println("请输入编号：");
                    int id = input.nextInt();
                    System.out.println("请输入姓名：");
                    String name = input.next();
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "l":
                    hashTab.list();
                    break;
                case "f":
                    System.out.println("请输入编号");
                    id = input.nextInt();
                    hashTab.find(id);
                    break;
                case "d":
                    System.out.println("请输入编号");
                    id = input.nextInt();
                    hashTab.delete(id);
                    break;
                case "u":
                    System.out.println("请输入编号");
                    id = input.nextInt();
                    System.out.println("请输入姓名");
                    name = input.next();
                    emp = new Emp(id, name);
                    hashTab.update(emp);
                    break;
                case "e":
                    input.close();
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}

// 创建一个雇员
class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}

// 创建一个哈希表，管理多条链表
class HashTab {
    private EmpLinkedList[] empList;
    private int size;

    public HashTab(int size) {
        empList = new EmpLinkedList[size];
        this.size = size;
        // 初始化哈希表中的每一个链表
        for (int i = 0; i < size; i++) {
            empList[i] = new EmpLinkedList();
        }
    }

    // 添加链表到数组
    public void add(Emp emp) {
        // 取模获取哈希表数组的下标
        int empListNo = hashFun(emp.id);
        empList[empListNo].add(emp);
    }

    // 遍历哈希表中的信息
    public void list() {
        for (int i = 0; i < size; i++) {
            empList[i].list();
        }
    }

    // 根据编号查找雇员在哪个链表
    public void find(int id) {
        int empListNo = hashFun(id);
        empList[empListNo].find(id);
    }

    // 删除雇员
    public void delete(int id) {
        int empListNo = hashFun(id);
        Emp emp = empList[empListNo].delete(id);
        if (emp == null)
            System.out.println("删除失败，不存在该雇员！");
        else
            System.out.printf("该雇员在第 %d 条链表，删除成功！\n", (empListNo + 1));
    }

    // 修改雇员信息
    public void update(Emp emp) {
        int empListNo = hashFun(emp.id);
        empList[empListNo].update(emp);
    }

    // 根据id取模
    public int hashFun(int id) {
        return id % size;
    }
}

// 创建一个链表
class EmpLinkedList {
    // 初始化一个头结点，默认为null
    private Emp head;

    // 添加雇员到链表
    public void add(Emp emp) {
        // 若头结点为空，直接添加
        if (head == null) {
            head = emp;
            return;
        }
        Emp curEmp = head;
        while (true) {
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }

    // 删除雇员
    public Emp delete(int id) {
        if (head == null) {
            System.out.println("链表为空！");
            return null;
        }
        Emp curEmp = head;
        while (true) {
            if (curEmp.id == id) {
                break;
            }
            if (curEmp.next == null) {
                // 若查找不到，设置为null返回判断
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }

    // 修改
    public void update(Emp emp) {
        if (head == null) {
            System.out.println("链表为空！");
            return;
        }
        Emp cur = head;
        while (true) {
            if (cur.id == emp.id) {
                break;
            }
            if (cur.next == null) {
                // 若查找不到，设置为null返回判断
                cur = null;
                break;
            }
            cur = cur.next;
        }
        if (cur != null) {
            cur.id = emp.id;
            cur.name = emp.name;
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败，为空");
        }
    }

    // 遍历
    public void list() {
        if (head == null) {
            System.out.println("链表为空！");
            return;
        }
        System.out.print("链表信息为：");
        Emp curEmp = head;
        while (true) {
            System.out.print(" " + curEmp);
            if (curEmp.next == null)
                break;
            curEmp = curEmp.next;
        }
        System.out.println();
    }

    // 根据编号查找
    public void find(int id) {
        if (head == null) {
            System.out.println("查找失败，链表为空！");
            return;
        }
        Emp cur = head;
        while (true) {
            if (head.id == id) {
                break;
            }
            if (cur.next == null) {
                cur = null;
                break;
            }
            cur = cur.next;
        }
        if (cur != null) {
            System.out.println("查找到的雇员为：" + cur);
        } else {
            System.out.println("不存在！");
        }
    }
}
