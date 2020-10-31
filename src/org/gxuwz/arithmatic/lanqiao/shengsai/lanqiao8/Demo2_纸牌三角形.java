package org.gxuwz.arithmatic.lanqiao.shengsai.lanqiao8;

/**
 * 标题：纸牌三角形
 *
 * A,2,3,4,5,6,7,8,9 共9张纸牌排成一个正三角形（A按1计算）。要求每个边的和相等。
 * 下图就是一种排法（如有对齐问题，参看p1.png）。
 *
 *       A
 *      9 6
 *     4   8
 *    3 7 5 2
 *
 * 这样的排法可能会有很多。
 *
 * 如果考虑旋转、镜像后相同的算同一种，一共有多少种不同的排法呢？
 *
 * 请你计算并提交该数字。
 *
 * 注意：需要提交的是一个整数，不要提交任何多余内容。
 */
public class Demo2_纸牌三角形 {

    private static int count = 0;

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        // 从下标为0开始
        f(arr, 0);
        System.out.println(count/3/2);
    }

    static void f(int[] arr, int p) {
        // 终止条件, 当p指针指到最后一位时
        if (p == arr.length - 1) {
            int a = arr[0] + arr[1] + arr[2] + arr[3];
            int b = arr[3] + arr[4] + arr[5] + arr[6];
            int c = arr[6] + arr[7] + arr[8] + arr[0];
            if (a == b && b == c)
                count ++;
            return;
        }
        // 遍历递归，i指针和p指针都 +1
        // 将p赋值给i，进行全排列
        for (int i = p; i < arr.length; i++) {
            // i下标的数和p下标的数进行交换
            swap(arr, i, p);
            // 递归，指针 +1
            f(arr, p + 1);
            // 防止重复，将i和p交换回来
            swap(arr, i, p);
        }
    }

    private static void swap(int[] arr, int i, int p) {
        int t = arr[i];
        arr[i] = arr[p];
        arr[p] = t;
    }
}
