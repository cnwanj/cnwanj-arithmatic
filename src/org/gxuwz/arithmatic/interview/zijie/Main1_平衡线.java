package org.gxuwz.arithmatic.interview.zijie;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: vovhh
 * @Date: 2020-12-29 09:45:57
 * @Description:
 *
 * M * N 二维数组所有平衡线
 * 对每列来说，如果在第X行上、下部分元素的和都相等，则X行为平衡线，输出平衡线行下标
 * 输入：
 * a[M][N] =
 * 1 2 3
 * 5 3 1
 * 0 1 2 <--- 平衡线
 * 3 6 2
 * 3 -1 2
 * 输出：
 * 2
 *
 * 5 3
 * 1 2 3
 * 5 3 1
 * 0 1 2
 * 3 6 2
 * 3 -1 2
 *
 * 思路：
 * 1.将二维数每行组总和放入一维数组中
 * 2.计算二维数组所有元素总和sum
 * 3.上部分总和 等于 下部分总和 -> 上部分总和 == sum - 平衡线 - 上部分总和
 */
public class Main1_平衡线 {
    static int[][] arr;
    static int n, m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        f();
    }
    static void f() {
        // 将二维数组每一行的和放入该数组中
        int[] a = new int[n];
        // 二维数组每一行的和，二维数组总和
        int line, sum = 0;
        for (int i = 0; i < n; i++) {
            line = 0;
            for (int j = 0; j < m; j++) {
                line += arr[i][j];
            }
            sum += line;
            a[i] = line;
        }
        // i为分割线
        for (int i = 1; i < n; i++) {
            // 上半部分总和
            int upNum = 0;
            // j表示分割线上面部分
            for (int j = 0; j < i; j++) {
                upNum += a[j];
            }
            // 若平衡线以上部分等于平衡线以下部分
            if (upNum == (sum - upNum - a[i])) {
                System.out.println(i);
                break;
            }
        }
    }
}
