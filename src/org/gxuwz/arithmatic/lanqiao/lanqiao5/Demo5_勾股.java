package org.gxuwz.arithmatic.lanqiao.lanqiao5;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @description:
 *
 * 勾股定理，西方称为毕达哥拉斯定理，它所对应的三角形现在称为：直角三角形。
 * <p>
 * 已知直角三角形的斜边是某个整数，并且要求另外两条边也必须是整数。
 * <p>
 * 求满足这个条件的不同直角三角形的个数。
 * <p>
 * 【数据格式】
 * 输入一个整数 n (0<n<10000000) 表示直角三角形斜边的长度。
 * 要求输出一个整数，表示满足条件的直角三角形个数。
 * <p>
 * 例如，输入：
 * 5
 * 程序应该输出：
 * 1
 * <p>
 * 再例如，输入：
 * 100
 * 程序应该输出：
 * 2
 * <p>
 * 再例如，输入：
 * 3
 * 程序应该输出：
 * 0
 * <p>
 * 资源约定：
 * 峰值内存消耗（含虚拟机） < 256M
 * CPU消耗  < 1000ms
 * <p>
 * 请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。
 * <p>
 * 所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
 * 注意：不要使用package语句。不要使用jdk1.7及以上版本的特性。
 * 注意：主类的名字必须是：Main，否则按无效代码处理。
 *
 * 思路：
 * 暴力破解：双循环遍历（超时）
 * 优化：单循环遍历，斜边^2 - 直角边^2 = 直角边^2 ---> c^2 - b^2 = a^2
 * 若 a + b > c (条件成立)
 *
 * @author: 韦永恒
 * @date: 2020-10-06 13:37:55
 */
public class Demo5_勾股 {

    static int count = 0;
    static long n = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextLong();
        f2();
        System.out.println(count / 2);
        sc.close();
    }

    static void f2() {
        for (long i = 1; i <= n; i++) {
            long s = (long) Math.sqrt(n * n - i * i);
            if (s + i > n && i * i + s * s == n * n) {
                count ++;
                System.out.println(i + "-" + s);
            }
        }
    }
}
