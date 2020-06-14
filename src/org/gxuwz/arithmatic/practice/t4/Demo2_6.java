package org.gxuwz.arithmatic.practice.t4;

/**
 * 汉诺塔问题：从A移动到B
 * 1-N从A移动到B，C作为辅助
 * 1、1~N-1移动到C，B作为辅助
 * 2、N从A移动到B
 * 3、1~N-1移动到B，A作为辅助
 * 切记：
 * 只操作N-1-------参数：个数、起始、目标、辅助
 * 1、先移动到辅助
 * 2、再移动到目标
 * 注意：开始的参数与对应要移动到的目标函数要符合
 */
public class Demo2_6 {
    static void hanoiTower(int n, String from, String to, String help) {
        if (n == 1) {
            System.out.println("将" + n + "从" + from + "移动到" + to);
            return;
        }
        hanoiTower(n - 1, from, help, to);
        System.out.println("将" + n + "从" + from + "移动到" + to);
        hanoiTower(n - 1, help, to, from);
    }

    public static void main(String[] args) {
        f(3, "A", "B", "C");
    }

    static void f(int n, String start, String help, String end) {
        if (n == 1) {
            System.out.println("move " + n + " from " + start + " to " + end);
            return;
        }
        f(n - 1, start, end, help);
        System.out.println("move " + n + " from " + start + " to " + end);
        f(n - 1, help, start, end);
    }
}
