package org.gxuwz.arithmatic.lanqiao.shengsai.lanqiao5;

/**
 * @description:
 *
 * 1/1 + 1/2 + 1/3 + 1/4 + ... 在数学上称为调和级数。
 *
 * 它是发散的，也就是说，只要加上足够多的项，就可以得到任意大的数字。
 *
 * 但是，它发散的很慢：
 *
 * 前1项和达到 1.0
 * 前4项和才超过 2.0
 * 前83项的和才超过 5.0
 *
 * 那么，请你计算一下，要加多少项，才能使得和达到或超过 15.0 呢？
 *
 * 请填写这个整数。
 *
 * 注意：只需要填写一个整数，不要填写任何多余的内容。比如说明文字。
 *
 * 思路：double类型遍历求和
 *
 * 答案：1835421
 *
 * @author: 韦永恒
 * @date: 2020-09-25 10:34:51
 */
public class Demo2_调和级数 {

    public static void main(String[] args) {
        double a = 1;
        double b = 3;
        System.out.println(a/b);
        double sum = 1;
        for (double i = 2; i <= 10000000; i++) {
            sum += 1 / i;
            if ((long)sum == 15) {
                System.out.println(i);
                break;
            }
        }
        System.out.println(sum);
    }
}
