package org.gxuwz.arithmatic.lanqiao.guosai.lanqiao10_c;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 韦永恒
 * @Date: 2020-10-28 13:58:01
 * @Description:
 *
 * 求两两不同的素数组成2019的方案数
 *
 * 注意点：并不是两个不同的素数，再者直接搜索应该会TimeLimited，
 *
 * 所以用dp或者记忆化搜索，方案数可能很多，记得用long long
 *
 * 结果: 55965365465060
 *
 * 【题目】
 * 2019可以被分解成若干个两两不同的素数，请问不同的分解方案有多少种？
 *
 * 注意：分解方案不考虑顺序，如2+2017=2019和2017+2=2019属于同一种方案。
 *
 * 不一定是两个素数相加,可能3个数，4个数相加等于2019，只是每一组素数中两两不同。
 *
 */
public class Main2 {

    static List<Long> list = new ArrayList<Long>();
    static long[] arr;
    static long n = 2019, num = 0;

    public static void main(String[] args) {
        int count = 0;
        for (long i = 2; i <= n; i++) {
            if (check(i)) {
                count ++;
                list.add(i);
            }
        }
//        for (int i = 0; i < count; i++) {
            arr = new long[6];
            f(0, 0);
//        }

        System.out.println(num);

    }

    static void f(int c, int p) {
        if (p == arr.length) {
            // 相加是否等于2019
//            if (add()) {
                num ++;
//            }
            return;
        }
        for (int i = c; i < list.size(); i++) {
            arr[p] = list.get(i);
            f(i + 1, p + 1);
        }
    }

    static boolean add() {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum == n)
            return true;
        return false;
    }

    // 判断一个数是否是素数（低效）
    static boolean check(long n) {
        if (n == 2 || n == 3)
            return true;
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
