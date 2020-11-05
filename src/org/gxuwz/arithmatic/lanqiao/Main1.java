package org.gxuwz.arithmatic.lanqiao;

import java.util.Scanner;

/**
 * 4
 * ***
 * L**L
 * L**L***L
 * L*****L
 */
public class Main1 {

    static String[] s;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        input.nextLine();
        s = new String[num];
        for (int i = 0; i < num; i++) {
            s[i] = input.nextLine();
        }
        for (int i = 0; i < num; i++) {
            System.out.println(fun(s[i]));
        }

    }

    private static int fun(String str) {
        if (str.contains("LOL")) {   // 已经有LOL,输了
            return -1;
        }
        if (!str.contains("*")) {    // 没有空了，打成平局
            return 0;
        }
        int res = -1;  // 初始化输了
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {   // 遍历每个空
            if (arr[i] == '*') {
                arr[i] = 'L';
                res = Math.max(res, -fun(String.valueOf(arr)));   // 返回最大的那一个，对手
                if (res == 1) {     // 赢了
                    arr[i] = '*';   // 提前回溯
                    return 1;
                }
                arr[i] = 'O';
                res = Math.max(res, -fun(new String(arr)));
                if (res == 1) {     // 赢了
                    arr[i] = '*';   // 回溯
                    return 1;
                }
                arr[i] = '*';       // 固定回溯
            }
        }
        return res;
    }
}
