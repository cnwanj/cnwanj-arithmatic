package org.gxuwz.arithmatic.lanqiao.guosai.lanqiao9;

/**
 * @Author: 韦永恒
 * @Date: 2020-10-28 13:58:53
 * @Description:
 *
 * 标题：三角形面积
 *
 * 已知三角形三个顶点在直角坐标系下的坐标分别为：
 * (2.3, 2.5)
 * (6.4, 3.1)
 * (5.1, 7.2)
 *
 * 求该三角形的面积。
 *
 * 注意，要提交的是一个小数形式表示的浮点数。
 * 要求精确到小数后3位，如不足3位，需要补零。
 *
 * 【思路】
 * 三角形面积 = 正方形 - 三个直角三角形
 *
 * 答案：8.795
 */
public class Main1_三角形面积 {

    public static void main(String[] args) {
        // 高
        double h = 7.2 - 2.5;
        // 长
        double s = 6.4 - 2.3;

        double a1 = h * (5.1 - 2.3) / 2;
        double a2 = (6.4 - 5.1) * (7.2 - 3.1) / 2;
        double a3 = s * (3.1 - 2.5) / 2;

        double res = s * h - (a1 + a2 + a3);
        System.out.printf("%.3f", res);
    }
}
