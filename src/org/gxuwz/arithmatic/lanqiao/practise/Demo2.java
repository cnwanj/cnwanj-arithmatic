package org.gxuwz.arithmatic.lanqiao.practise;

/**
 * 判断是否为闰年
 * 1、能够整除4不能整除100
 * 2、能够整除400
 */
public class Demo2 {
    public static void f(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            System.out.println("闰年");
        } else {
            System.out.print("平年");
        }
    }

    public static void main(String[] args) {
        f(2016);
    }
}
