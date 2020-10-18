package org.gxuwz.arithmatic.lanqiao.lanqiao11_模拟2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 *
 * 【问题描述】如果一个序列的奇数项都比前一项大，偶数项都比前一项小，则称为一个摆动序列。
 * 即 a[2i]&lt;a[2i-1], a[2i+1]&gt;a[2i]。
 * 小明想知道，长度为 m，每个数都是 1 到 n 之间的正整数的摆动序列一共有多少个。
 * 【输入格式】输入一行包含两个整数 m，n。
 * 【输出格式】输出一个整数，表示答案。答案可能很大，请输出答案除以10000的余数。
 * 【样例输入】3 4
 * 【样例输出】14
 * 【样例说明】以下是符合要求的摆动序列：
 * 2 1 2
 * 2 1 3
 * 2 1 4
 * 3 1 2
 * 3 1 3
 * 3 1 4
 * 3 2 3
 * 3 2 4
 * 4 1 2
 * 4 1 3
 * 4 1 4
 * 4 2 3
 * 4 2 4
 * 4 3 4
 * 【评测用例规模与约定】
 * 对于 20% 的评测用例，1 &lt;= n, m &lt;= 5；<br>对于 50% 的评测用例，1 &lt;= n, m &lt;= 10；
 * 对于 80% 的评测用例，1 &lt;= n, m &lt;= 100；
 * 对于所有评测用例，1 &lt;= n, m &lt;= 1000。
 *
 * 【思路】奇数项都比前一项大，偶数项都比前一项小；简单理解就是 ====> （奇数项 > 偶数项 < 奇数项）
 *
 * @author: 韦永恒
 * @date: 2020-09-09 11:24:28
 */
public class Demo8_摆动序列 {

    static int m, n, count = 0;
    static int[] arr;
    static int[] arr2;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();

        arr = new int[n];
        arr2 = new int[m];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        f1(arr, 0);
        System.out.println(count);
    }

    /**
     * 从数组中抽取n个元素的全排列
     * @param arr 抽取的数组
     * @param p 抽取的第几次
     */
    static void f1(int[] arr, int p) {
        if (p == m) {
            if (checkSort(arr2)) {
                System.out.println(Arrays.toString(arr2));
                count  = (count + 1) % 10000;
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            arr2[p] = arr[i];
            f1(arr, p + 1);
        }
    }

    /**
     * 偶数项都比前一项小，奇数项都比前一项大 ---> 摆动序列（奇数项 > 偶数项 < 奇数项）
     */
    static boolean checkSort(int[] arr) {
        if (arr.length == 1)
            return true;
        if (arr.length == 2 && arr[0] > arr[1]) {
            return true;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            // 偶数 && 偶数项都比前一项小 && 奇数项都比前一项大（偶数 && 奇数 > 偶数 && 偶数 < 奇数）
            if ((i + 1) % 2 == 0 && arr[i - 1] > arr[i] && arr[i] < arr[i + 1]) {
                return true;
            }
        }
        return false;
    }
}

// 方法二，完成所有用例
class Demo8_摆动序列1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.close();

        // a[i][j] i表示第多少位，j表示一个分界线
        // 奇数行就是大于j的方案数，偶数行就是小于j的方案数
        // 奇数要比前面的大，所以要大于的，偶数要比前面的小，所以要小于的
        int[][] a = new int[m + 2][n + 2];
        // 初始化边界
        for (int i = 1; i <= n; i++) {
            a[1][i] = n - i + 1;
        }

        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
        System.out.println();
        for (int i = 2; i <= m; i++) {
            // 将i转换为2进制的各位数，若等于1为奇数，否则为偶数
            if ((i & 1) == 1) {
                // 若是奇数，倒序
                for (int j = n; j >= 1; j--) {
                    a[i][j] = (a[i - 1][j - 1] + a[i][j + 1] % 10000);
                }
            } else {
                // 若为偶数
                for (int j = 1; j <= n; j++) {
                    a[i][j] = (a[i - 1][j + 1] + a[i][j - 1] % 10000);
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }

        // 判断奇偶从此我要改成这个了，一位位运算确实快
        // m&1，就是把m换成二进制看看最后一位是不是1，如果是1证明就是奇数，如果是0证明是偶数
        int r = (m & 1) == 1 ? a[m][1] : a[m - 1][n];
        System.out.println(r);
    }
}
