package org.gxuwz.arithmatic.practice.t2;

import java.math.BigInteger;

//放麦子
public class Demo9 {
    public static void f() {
        //方法1.创建超整形类
        BigInteger t = new BigInteger("0");
        BigInteger s = new BigInteger("2");
        for (int i = 0; i < 64; i++) {
            t = t.add(s.pow(i));        //相当于int类型的  t + s的i次幂
        }
        System.out.println(t);
        //方法2.（推荐）
        System.out.println(s.pow(64).subtract(new BigInteger("1")));
    }

    public static void f1() {
        BigInteger bi = new BigInteger("0");
        for (int i = 0; i < 64; i++) {
            bi = bi.add(BigInteger.valueOf((long) (Math.pow(2, i))));
        }
        System.out.println(bi);
    }

    public static void main(String[] args) {
//        f();
        f1();
    }
}
