package org.gxuwz.arithmatic.lanqiao.lanqiao11_校选;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: 韦永恒
 * @date: 2020-10-16 22:07:43
 *
 * 8.（程序题 10分）质数（Prime number，又称素数），
 *
 * 指在大于1的自然数中，除了1和该数自身外，无法被其他自然数整除的数。
 *
 * 而10以内的质数有2, 3, 5, 7共四个，其中最大的两个数为5和7，
 *
 * 我们把5加上1称之为小合数（6），把7加上1称之为大合数（8），
 *
 * 而小合数与大合数的最大公约数与最小公倍数之和称之为10的有缘数（24+2=26），
 *
 * 现要求编写一道程序，程序开始时输入n（10≤n≤200），求n的有缘数。
 *
 * 输入：
 * 输入n（10≤n≤200）
 * 输出：
 * n的有缘数
 * 数据样例：
 * 输入：
 * 10
 * 输出：
 * 26
 */
public class Demo8_有缘数 {

    /**
     * 判断n是否为质数
     * @param n 需要进行判断的值
     * @return boolean
     */
    public static boolean isPrime(int n) {       //判断是否是质数
        boolean flag = true;
        for (int i = 2; i <= (n + 1) / 2; i++) {   //将n分别与2到(n+1)/2取余，若有一个值为0，则n就不为素数，反之为素数
            if (n % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static int gongyue(int x,int y){//最大公约数
//        if(x>y){
//            int t = x;
//            x = y;
//            y = t;
//        }
        while(x!=0){
            int temp = y%x;
            y = x;
            x = temp;
        }
        return y;
    }

    public static int gongbei(int x,int y){//最小公倍数
        int a = x,b = y;
        int g = gongyue(a,b);
        return x*y/g;
    }

    /**
     * 计算最大公约数与最小公倍数的和
     * @param bigInt 大合数
     * @param smallInt 小合数
     * @return 最大公约数与最小公倍数的和
     */
    public static int calculate(int bigInt,int smallInt) {       //判断是否是质数
        int gongyue = gongyue(bigInt, smallInt);
        int gongbei = gongbei(bigInt, smallInt);
        return gongyue + gongbei;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 2; i <= n; i++) {            //1既不是质数也不是合数,故i从2开始取
            if (isPrime (i)) {
                list.add(i);
            }
        }

        // 计算大合数与小合数
        int bigInt = list.get(list.size()-1) + 1;
        int smallInt = list.get(list.size() - 2) + 1;

        int calculate = calculate(bigInt, smallInt);
        System.out.println(calculate);
    }
}
