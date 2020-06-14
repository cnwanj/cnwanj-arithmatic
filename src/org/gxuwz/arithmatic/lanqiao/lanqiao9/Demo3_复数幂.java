package org.gxuwz.arithmatic.lanqiao.lanqiao9;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/*
标题：复数幂

设i为虚数单位。对于任意正整数n，(2+3i)^n 的实部和虚部都是整数。
求 (2+3i)^123456 等于多少？ 即(2+3i)的123456次幂，这个数字很大，要求精确表示。

答案写成 "实部±虚部i" 的形式，实部和虚部都是整数（不能用科学计数法表示），中间任何地方都不加空格，实部为正时前面不加正号。
(2+3i)^2 写成: -5+12i，(2+3i)^5 的写成: 122-597i

注意：需要提交的是一个很庞大的复数，不要填写任何多余内容。
 */
public class Demo3_复数幂 {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        BigDecimal a = new BigDecimal(2);
//        BigDecimal b = new BigDecimal(-3);
//        BigDecimal c = new BigDecimal(2);
//        BigDecimal d = new BigDecimal(-3);

//        BigInteger a = BigInteger.valueOf(2);
//        BigInteger b = BigInteger.valueOf(3);
//        BigInteger c = BigInteger.valueOf(2);
//        BigInteger d = BigInteger.valueOf(3);

//        for (int i = 1; i < n; i++) {
//            BigDecimal t1 = c;
//            c = a.multiply(c).subtract(b.multiply(d));
//            d = b.multiply(t1).add(a.multiply(d));
//        }
//        System.out.println(c +"+"+ d);
//         System.out.println(c + (d.compareTo(BigDecimal.ZERO) == -1 ? "" : "+") + d + "i");
//        sc.close();
        f1();
    }

    public static void f() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigDecimal a = new BigDecimal(2);
        BigDecimal b = new BigDecimal(-3);
        BigDecimal a1 = new BigDecimal(2);
        BigDecimal b1 = new BigDecimal(-3);
        for (int i = 1; i < n; i++) {
            // (a+b)(a+b) = a*a-b*b + a*b+b*a;
            BigDecimal c = a1;
            a1 = a.multiply(a1).subtract(b.multiply(b1));
            b1 = a.multiply(b1).add(c.multiply(b));
        }
        System.out.println(a1 + (b1.compareTo(BigDecimal.ZERO) == -1 ? "" : "+") + b1 + "i");
    }

    public static void f1() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger a = new BigInteger("2");
        BigInteger b = BigInteger.valueOf(3);
        BigInteger c = BigInteger.valueOf(2);
        BigInteger d = BigInteger.valueOf(3);
        for (int i = 1; i < n; i++) {
            BigInteger m = c;
            c = a.multiply(c).subtract(b.multiply(d));
            d = a.multiply(d).add(b.multiply(m));
        }
        // 判断复数部分是否大于0
        String s = d.compareTo(BigInteger.valueOf(0)) == -1 ? "" : "+";
        System.out.println(c + s + d + "i");

    }
}
