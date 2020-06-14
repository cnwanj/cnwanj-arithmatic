package org.gxuwz.arithmatic.lanqiao.dasai.algo;

import java.util.Scanner;

/**
 * 试题 算法训练 P0505
 * <p>
 * 资源限制
 * 时间限制：1.0s   内存限制：256.0MB
 * 　　一个整数n的阶乘可以写成n!，它表示从1到n这n个整数的乘积。
 * 阶乘的增长速度非常快，例如，13！就已经比较大了，已经无法存放在一个整型变量中；
 * 而35！就更大了，它已经无法存放在一个浮点型变量中。
 * 因此，当n比较大时，去计算n!是非常困难的。
 * 幸运的是，在本题中，我们的任务不是去计算n!，而是去计算n!最右边的那个非0的数字是多少。
 * 例如，5！=1*2*3*4*5=120，因此5!最右边的那个非0的数字是2。
 * 再如，7！=5040，因此7！最右边的那个非0的数字是4。
 * 再如，15！= 1307674368000，因此15！最右边的那个非0的数字是8。
 * 请编写一个程序，输入一个整数n(0<n<=100)，然后输出n!最右边的那个非0的数字是多少。
 * <p>
 * 输入：
 * 　　7
 * 输出：
 * 　　4
 */
public class Demo6_P0505 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long x = n;
        for (long i = n - 1; i > 0; i--) {
            x *= i;
            if (x % 10 == 0) {
                x /= 10;
                x %= 1000;
            }
        }
        x %= 10;
        System.out.println(x);
    }
}
