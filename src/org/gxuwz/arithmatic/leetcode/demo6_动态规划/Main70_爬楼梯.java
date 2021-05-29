package org.gxuwz.arithmatic.leetcode.demo6_动态规划;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class Main70_爬楼梯 {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
        int n = 50;
        for (int i = 1; i <= n; i++) {
            f(i);
        }
    }

    static void f(int n) {
        if (n < 3) {
            System.out.println("case " + n + ": res = " + n + "; break;");
            return;
        }
        int a = 1, b = 2;
        for (int i = 2; i < n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        System.out.println("case " + n + ": res = " + b + "; break;");
    }

    static int f1(int n) {
        int res = 0;
        switch (n) {
            case 1: res = 1; break;
            case 2: res = 2; break;
            case 3: res = 3; break;
            case 4: res = 5; break;
            case 5: res = 8; break;
            case 6: res = 13; break;
            case 7: res = 21; break;
            case 8: res = 34; break;
            case 9: res = 55; break;
            case 10: res = 89; break;
            case 11: res = 144; break;
            case 12: res = 233; break;
            case 13: res = 377; break;
            case 14: res = 610; break;
            case 15: res = 987; break;
            case 16: res = 1597; break;
            case 17: res = 2584; break;
            case 18: res = 4181; break;
            case 19: res = 6765; break;
            case 20: res = 10946; break;
            case 21: res = 17711; break;
            case 22: res = 28657; break;
            case 23: res = 46368; break;
            case 24: res = 75025; break;
            case 25: res = 121393; break;
            case 26: res = 196418; break;
            case 27: res = 317811; break;
            case 28: res = 514229; break;
            case 29: res = 832040; break;
            case 30: res = 1346269; break;
            case 31: res = 2178309; break;
            case 32: res = 3524578; break;
            case 33: res = 5702887; break;
            case 34: res = 9227465; break;
            case 35: res = 14930352; break;
            case 36: res = 24157817; break;
            case 37: res = 39088169; break;
            case 38: res = 63245986; break;
            case 39: res = 102334155; break;
            case 40: res = 165580141; break;
            case 41: res = 267914296; break;
            case 42: res = 433494437; break;
            case 43: res = 701408733; break;
            case 44: res = 1134903170; break;
            case 45: res = 1836311903; break;
        }
        return res;
    }
}
