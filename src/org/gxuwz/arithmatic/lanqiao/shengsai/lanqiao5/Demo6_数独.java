package org.gxuwz.arithmatic.lanqiao.shengsai.lanqiao5;

import java.util.Scanner;

/**
 * @description:
 *
 * 你一定听说过“数独”游戏。
 * 如【图1.png】，玩家需要根据9×9盘面上的已知数字，推理出所有剩余空格的数字，
 *
 * 并满足每一行、每一列、每一个同色九宫内的数字均含1-9，不重复。
 *
 * 数独的答案都是唯一的，所以，多个解也称为无解。
 *
 * 本图的数字据说是芬兰数学家花了3个月的时间设计出来的较难的题目。但对会使用计算机编程的你来说，恐怕易如反掌了。
 *
 * 本题的要求就是输入数独题目，程序输出数独的唯一解。我们保证所有已知数据的格式都是合法的，并且题目有唯一的解。
 *
 * 格式要求，输入9行，每行9个字符，0代表未知，其它数字为已知。
 * 输出9行，每行9个数字表示数独的解。
 *
 * 例如：
 * 输入（即图中题目）：
 * 005300000
 * 800000020
 * 070010500
 * 400005300
 * 010070006
 * 003200080
 * 060500009
 * 004000030
 * 000009700
 *
 * 程序应该输出：
 * 145327698
 * 839654127
 * 672918543
 * 496185372
 * 218473956
 * 753296481
 * 367542819
 * 984761235
 * 521839764
 *
 * 再例如，输入：
 * 800000000
 * 003600000
 * 070090200
 * 050007000
 * 000045700
 * 000100030
 * 001000068
 * 008500010
 * 090000400
 *
 * 程序应该输出：
 * 812753649
 * 943682175
 * 675491283
 * 154237896
 * 369845721
 * 287169534
 * 521974368
 * 438526917
 * 796318452
 *
 *
 * 资源约定：
 * 峰值内存消耗（含虚拟机） < 256M
 * CPU消耗  < 2000ms
 *
 *
 * 请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。
 *
 * 所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
 * 注意：不要使用package语句。不要使用jdk1.7及以上版本的特性。
 * 注意：主类的名字必须是：Main，否则按无效代码处理。
 *
 * 思路：宫内检测、行列检测 ---> 循环递归、无解回溯
 *
 * @author: 韦永恒
 * @date: 2020-10-06 19:02:32
 */
public class Demo6_数独 {

    static int[][] arr = new int[9][9];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            String a = sc.nextLine();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = a.charAt(j) - '0';
            }
        }

        // n行、m列
        f(0, 0);
        sc.close();
    }

    static void f(int n, int m) {
        // 若为第9行则输出
        if (n == 9) {
            print();
            return;
        }
        // 若元素为0
        if (arr[n][m] == 0) {
            for (int i = 1; i <= arr.length; i++) {
                // 宫内检测 && 行列检测
                if (checkG(n, m, i) && checkNM(n, m, i)) {
                    // 若无重复元素，将当前元素赋值
                    arr[n][m] = i;
                    // 递归判断
                    hs(n, m);
                    // 回溯重置赋值
                    arr[n][m] = 0;
                }
            }
        } else {
            // 若元素不为0
            hs(n, m);
        }
    }

    // 条件递归
    static void hs(int n, int m) {
        if (m < 8) {
            // 若不为行尾元素
            f(n, m + 1);
        } else if (n < 9 && m == 8) {
            // 行在范围内 && 换行，并指向第一列
            f(n + 1, 0);
        }
    }

    // 宫格检测
    static boolean checkG(int n, int m, int val) {
        // 切割行宫格并赋起点下标
        if (n >= 0 && n <= 2) n = 0;
        if (n >= 3 && n <= 5) n = 3;
        if (n >= 6 && n <= 8) n = 6;
        // 切割列宫格并赋起点下标
        if (m >= 0 && m <= 2) m = 0;
        if (m >= 3 && m <= 5) m = 3;
        if (m >= 6 && m <= 8) m = 6;
        // 宫格内循环遍历
        for (int i = n; i < n + 3; i++) {
            for (int j = m; j < m + 3; j++) {
                // 若有重复的值，返回false
                if (arr[i][j] == val)
                    return false;
            }
        }
        return true;
    }

    // 行列检测
    static boolean checkNM(int n, int m, int val) {
        for (int i = 0; i < arr.length; i++) {
            // 遍历行 || 遍历列
            if (arr[n][i] == val || arr[i][m] == val) {
                return false;
            }
        }
        return true;
    }

    // 输出
    static void print() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
