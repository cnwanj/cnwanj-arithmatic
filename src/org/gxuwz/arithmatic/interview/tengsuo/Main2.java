package org.gxuwz.arithmatic.interview.tengsuo;

import java.util.Scanner;

/**
 * @Author: vovhh
 * @Date: 2021-01-22 15:44:54
 * @Description:
 *
 * 题目：双素数
 *
 * 一个正整数是素数当且仅当它除了1和自身以外没有其他因子，现在我们定义双素数；
 *
 * 一个正整数是双素数当且仅当它本身是个素数，并且将他的十进制表示反转后得到数不等于它自身且也是个素数，
 *
 * 如13就是一个双素数，因为13和31不相等且都是素数，现给出一个整数k,你需要找到第k小的双素数
 *
 * 输入描述：
 *
 * 第一行包含一个整数k,1≤k≤200
 *
 * 输出描述：
 *
 * 若第k小的素数不超过10^6则输出它
 *
 * 输入：
 * 1
 *
 * 输出：
 * 13
 */
public class Main2 {

    public int getDoublePrimes (int index) {
        if (index > 200)
            return -1;
//        return check1(index);
        System.out.println(checkSS(index));
        return 0;
    }

    public int check1(int index) {
        int num = 12;
        while (index != 0) {
            num ++;
            if (checkSS(num) && checkSS(reversal(num))) {
                index--;
            }
        }
        return num;
    }

    public boolean checkSS(int num) {
        boolean tag = true;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                tag = false;
                break;
            }
        }
        return tag;
    }

    public int reversal(int num) {
        StringBuilder s = new StringBuilder("" + num);
        s.reverse();
        return Integer.parseInt(s.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Main2 m = new Main2();
        System.out.println(m.getDoublePrimes(num));
    }
}
