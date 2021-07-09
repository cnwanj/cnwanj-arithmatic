package org.gxuwz.arithmatic.nowcoder.main1_练习;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述
 * 牛牛最近搬到了一座新的城镇，这个城镇可以看成是一个一维的坐标系。城镇上有n个居民，第i个居民的位置为a_ia
 * i
 * ​
 * 。现在牛牛有m个搬家方案，在第i个方案中他会搬到位置x_ix
 * i
 * ​
 * 。
 * <p>
 * 俗话说的好，远亲不如近邻。现在牛牛想知道，对于每个搬家方案，搬家后与最近的居民的距离为多少。
 * <p>
 * 示例1
 * 输入
 * 复制
 * 3,2,[2,4,7],[5,8]
 * 输出
 * 复制
 * [1,1]
 * 说明
 * 第一个方案搬到位置5，与5最近的居民在位置4，距离为1.
 * 第二个方案搬到位置8，与8最近的居民在位置7，距离为1
 * 备注:
 * 1\le n,m\le100000, 0\le |a_i|,|x_i|\le 1e91≤n,m≤100000,0≤∣a
 * i
 * ​
 * ∣,∣x
 * i
 * ​
 * ∣≤1e9
 * 第一个参数为int型变量，代表居民个数n
 * 第二个参数为int型变量，代表方案个数m
 * 第三个参数为vector<int>，包含n个元素代表n个居民的位置
 * 第四个参数为vector<int>，包含m个元素代表m个方案对应的位置
 */
public class Demo9_远亲不如近邻 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        // 3,2,[2,4,7],[5,8]
        int n = Integer.parseInt(s.substring(0, 1));
        int m = Integer.parseInt(s.substring(2, 3));
        String[] a = s.substring(5, 5 + (n * 2) - 1).split(",");
        int[] a1 = new int[n];
        for (int i = 0; i < n; i++) {
            a1[i] = Integer.parseInt(a[i]);
        }
        String[] x = s.substring(5 + (n * 2) + 2, s.length() - 1).split(",");
        int[] x1 = new int[m];
        for (int i = 0; i < m; i++) {
            x1[i] = Integer.parseInt(x[i]);
        }
        System.out.println(Arrays.toString(solve(n, m, a1, x1)));
    }

    public static int[] solve(int n, int m, int[] a, int[] x) {
        Arrays.sort(a);
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            int b = Math.abs(x[i] - a[0]);
            int p = 1;
            while (p < n && b > Math.abs(x[i] - a[p])) {
                System.out.println(b);
                b = Math.abs(x[i] - a[p]);
                p++;
            }
            arr[i] = b;
        }
        return arr;
    }

}
