package org.gxuwz.arithmatic.lanqiao.practise;

/**
 * 7、基础练习 特殊的数字
 * 问题描述
 * 　　153是一个非常特殊的数，它等于它的每位数字的立方和，
 *     即153=1*1*1+5*5*5+3*3*3。编程求所有满足这种条件的三位十进制数。
 * 输出格式
 * 　　按从小到大的顺序输出满足条件的三位十进制数，每个数占一行。
 */
public class Demo7_特殊数字 {
    public static void f1(){
        int sum = 0;
        int n = 0;
        int p = 0;
        for(int i=100; i<1000; i++){
            for(int j=0; j<3; j++){
                p = i;
                n = p%10;
                sum += n*n*n;
                p = p-n;
            }
            if(i == sum){
                System.out.println(i);
            }
        }
    }

    public static void f2(){
        int a, b, c, sum;
        for (int i = 100; i < 1000; i++) {
            a = i%10;
            b = (i%100)/10;
            c = i/100;
            sum = a*a*a + b*b*b + c*c*c;
            if(sum == i)
                System.out.println(i);
        }
    }
    public static void main(String[] args){
//        System.out.println(153%10);
        f2();
    }
}
