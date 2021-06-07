package org.gxuwz.arithmatic.nowcoder.main_练习;

import java.util.Scanner;

public class Demo1_班级成绩输入输出 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] arr = new double[5][6];
        for (int i = 0; i < 5; i++) {
            String[] str = sc.nextLine().split(" ");
            for (int j = 0; j < str.length; j++) {
                arr[i][j] = Double.parseDouble(str[j]);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            double d = 0;
            for (int j = 0; j < arr[i].length; j++) {
                d = d + arr[i][j];
            }
            arr[i][5] = d;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
