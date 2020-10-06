package org.gxuwz.arithmatic.lanqiao.lanqiao5;

import java.text.DecimalFormat;

/**
 * @description:
 *
 * 如果x的x次幂结果为10（参见【图1.png】），你能计算出x的近似值吗？
 *
 * 显然，这个值是介于2和3之间的一个数字。
 *
 * 请把x的值计算到小数后6位（四舍五入），并填写这个小数值。
 *
 * 注意：只填写一个小数，不要写任何多余的符号或说明。
 *
 * 答案：506184
 * 2.5061841991715896
 *
 * @author: 韦永恒
 * @date: 2020-09-25 11:07:59
 */
public class Demo3_次幂近似值 {

    public static void main(String[] args) {
        for (double x = 2.0; x < 3.0; x += 0.0000001) {
            if (Math.abs((Math.pow(x, x) - 10.0)) < 0.000001) {
                DecimalFormat df = new DecimalFormat("#.000000");

                System.out.println(df.format(x));
                break;
            }
        }
    }
}
