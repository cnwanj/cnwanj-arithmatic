package org.gxuwz.arithmatic.lanqiao.shengsai.lanqiao5;

/**
 * @description:
 *
 * java中提供了对正则表达式的支持。
 * 有的时候，恰当地使用正则，可以让我们的工作事半功倍！
 *
 * 如下代码用来检验一个四则运算式中数据项的数目，请填写划线部分缺少的代码。
 *
 * 注意：只填写缺少代码，不要写任何多余内容，例如，已有的双引号。
 *
 * 答案：[^0-9]
 *
 * @author: 韦永恒
 * @date: 2020-09-25 10:05:54
 */
public class Demo1_正则 {

    public static int f(String s)
    {
        return s.split("[^0-9]").length;
    }

    public static void main(String[] args)
    {
        System.out.println(f("12+35*5-2*18/9-3")); //7
        System.out.println(f("354*12+3-14/7*6")); //6
    }
}
