package org.gxuwz.arithmatic.nowcoder.main_练习;

import java.util.Scanner;

public class Demo3_上三角矩阵判定 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < arr.length; i++) {
            String[] s = sc.nextLine().split(" ");
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
        boolean tag = true;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i][j] != 0) {
                    tag = false;
                    break;
                }
            }
            if (!tag)
                break;
        }
        if (tag)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
