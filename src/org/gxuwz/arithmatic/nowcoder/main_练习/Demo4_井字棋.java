package org.gxuwz.arithmatic.nowcoder.main_练习;

import java.util.*;

public class Demo4_井字棋 {

    public static void f(int in, char ch) {
        if (in == 2) {
            if (ch == 'K') {
                System.out.println("KiKi wins!");
                return;
            } else if (ch == 'B') {
                System.out.println("BoBo wins!");
                return;
            } else {
                System.out.println("No winner!");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] arr = new char[3][3];
        for (int i = 0; i < arr.length; i++) {
            String[] c = sc.nextLine().split(" ");
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = c[j].charAt(0);
            }
        }

        // 判断行
        int in = 0;
        char first;
        for (int i = 0; i < arr.length; i++) {
            first = arr[i][0];
            in = 0;
            for (int j = 1; j < arr[i].length; j++) {
                if (first == arr[i][j]) {
                    in++;
                }
                f(in, arr[i][j]);
            }
        }

        // 判断列
        for (int i = 0; i < arr.length; i++) {
            in = 0;
            first = arr[0][i];
            for (int j = 1; j < arr[i].length; j++) {
                if (first == arr[j][i]) {
                    in++;
                }
                f(in, arr[j][i]);
            }
        }
        in = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[0][0] == arr[i][i]) {
                in++;
            }
        }
        f(in, arr[0][0]);
        if (arr[0][2] == arr[1][1] && arr[0][2] == arr[2][0]) {
            if (arr[0][2] == 'K') {
                System.out.println("KiKi wins!");
            } else if (arr[0][2] == 'B') {
                System.out.println("BoBo wins!");
            } else {
                System.out.println("No winner!");
            }
        }
    }
}
