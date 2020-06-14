package org.gxuwz.arithmatic.lanqiao.lanqiao9;

import java.math.BigInteger;
import java.util.Scanner;

/*

标题：螺旋折线

如图p1.pgn所示的螺旋折线经过平面上所有整点恰好一次。
对于整点(X, Y)，我们定义它到原点的距离dis(X, Y)是从原点到(X, Y)的螺旋折线段的长度。

例如dis(0, 1)=3, dis(-2, -1)=9

给出整点坐标(X, Y)，你能计算出dis(X, Y)吗？

【输入格式】
X和Y

对于40%的数据，-1000 <= X, Y <= 1000
对于70%的数据，-100000 <= X， Y <= 100000
对于100%的数据, -1000000000 <= X, Y <= 1000000000

【输出格式】
输出dis(X, Y)


【输入样例】
0 1

【输出样例】
3


资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 1000ms


请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。

所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
不要使用package语句。不要使用jdk1.7及以上版本的特性。
主类的名字必须是：Main，否则按无效代码处理。

 */
public class Demo7_螺旋折线 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x, y;
        while (true) {
            x = sc.nextInt();
            y = sc.nextInt();
            t(x, y);
        }
    }

    static void t(long x, long y) {
        long sum = g(x, y);
        BigInteger g = g1(x, y);
        System.out.println(g.add(BigInteger.valueOf(sum)));
    }

    // 计算外圈
    static long g(long x, long y) {
        long sum = 0;
        if (x < 0 && y >= 0) {       // 第二象限
            if (a(x) >= y) {
                // 左下
                sum = a(x) + y;
            } else {
                sum = 2 * m(x, y) + x + y;
            }
        } else if (x >= 0 && y > 0) {// 第一象限
            if (y >= x) {
                // 左上
                sum = 3 * m(x, y) + x;
            } else {
                sum = 4 * m(x, y) + x - y;
            }
        } else if (x > 0 && y <= 0) {// 第四象限
            if (x >= a(y)) {
                // 右上
                sum = 5 * m(x, y) + a(y);
            } else {
                sum = 6 * m(x, y) + a(x + y);
            }
        } else {                    // 第三象限
            if (x >= y) {
                // 右上
                sum = 7 * m(x, y) + a(x);
            } else {
                sum = a(x - y);
            }
        }
        return sum;
    }

    // 计算内圈
    static BigInteger g1(long x, long y) {
        BigInteger sum = BigInteger.valueOf(0), w;
        long m = m(x, y);
        if (m > 1) {
            // 外圈的长度
            // 等差数列：s = a1 + (n - 1) * d
            long n = 8 + (m - 2) * 8;
            w = BigInteger.valueOf(8 + (m - 2) * 8);
            // 等差数列求和：n*a1 + (n*n - n)/2 * d 或者 n*(a1 + an)/2
            sum = BigInteger.valueOf(m-1).multiply(BigInteger.valueOf(8).add(w)).divide(BigInteger.valueOf(2));
        }
        return sum;
    }

    public static long a(long a) {
        return Math.abs(a);
    }

    public static long m(long x, long y) {
        return Math.max(a(x), a(y));
    }
}
