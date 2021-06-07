package org.gxuwz.arithmatic.nowcoder.main_练习;

import java.util.Scanner;

/**
 * 题目描述
 * KiKi想从n行m列的方阵队列中找到身高最高的人的位置，请你帮助他完成这个任务。
 * <p>
 * 输入描述:
 * 第一行包含两个整数n和m，表示这个方阵队列包含n行m列。从2到n+1行，
 * 每行输入m个整数（范围-2^31~2^31-1），用空格分隔，共输入n*m个数，表示方阵中的所有人的身高（保证输入身高都不相同）。(1≤x≤n≤10，1≤y≤m≤10)
 * <p>
 * 输出描述:
 * 一行，输出两个整数，用空格分隔，表示方阵中身高最高的人所在的行号和列号。
 * 示例1
 * 输入
 * 复制
 * 2 2
 * 175 180
 * 176 185
 * 输出
 * 复制
 * 2 2
 */
public class Demo2_最高身高 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int[][] arr = new int[Integer.parseInt(s[0])][Integer.parseInt(s[1])];
        for (int i = 0; i < arr.length; i++) {
            String[] s1 = sc.nextLine().split(" ");
            for (int j = 0; j < s1.length; j++) {
                arr[i][j] = Integer.parseInt(s1[j]);
            }
        }

        int max = arr[0][0], a = 0, b = 0;
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (max < arr[i][j]) {
                    temp = max;
                    max = arr[i][j];
                    arr[i][j] = temp;
                    a = i;
                    b = j;
                }
            }
        }
        System.out.println((a + 1) + " " + (b + 1));
    }
}
