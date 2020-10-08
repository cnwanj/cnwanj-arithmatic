package org.gxuwz.arithmatic.lanqiao;

public class Main {

    // 1+2+3+...+10*11+12+...+27*28+29+...46*47+48*49 = 2015
    public static void main(String[] args) {
        int[] arr = new int[49];
        // s：1-49总和
        int s = 0, left, right;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
            s += i + 1;
        }

        for (int i = 0; i < arr.length - 2; i++) {
            // 保存左边两数相乘减去两数相加
            left = arr[i] * arr[i + 1] - (arr[i] + arr[i + 1]);

            for (int j = i + 2; j < arr.length - 1; j++) {
                // 保存右边两数相乘减去两数相加
                right = arr[j] * arr[j + 1] - (arr[j] + arr[j + 1]);

                // 最终总和 - 左相乘(减去左相加) + 右相乘(减去右相加)
                int sum = s + left + right;
                if (sum == 2015) {
                    System.out.println(arr[i]);
                }
            }
        }
    }
}

