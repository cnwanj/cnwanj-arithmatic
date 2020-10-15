package org.gxuwz.arithmatic.lanqiao.lanqiao9;

/**
 * 标题：方格计数
 *
 * 如图p1.png所示，在二维平面上有无数个1x1的小方格。
 *
 * 我们以某个小方格的一个顶点为圆心画一个半径为1000的圆。
 *
 * 你能计算出这个圆里有多少个完整的小方格吗？
 *
 * 注意：需要提交的是一个整数，不要填写任何多余内容。
 *
 * 答案：3137548
 */
public class Demo2_方格计算 {

    public static void main(String[] args) {
        int n = 1000, count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < n; j++) {
                if (Math.sqrt(i * i + j * j) <= n) {
                    count++;
                }
            }
        }
        System.out.println(count * 4);
    }
}
