package org.gxuwz.arithmatic.lanqiao.shengsai.lanqiao8;

import java.util.Scanner;

/**
 * 标题：包子凑数
 *
 * 小明几乎每天早晨都会在一家包子铺吃早餐。他发现这家包子铺有N种蒸笼，其中第i种蒸笼恰好能放Ai个包子。
 *
 * 每种蒸笼都有非常多笼，可以认为是无限笼。
 *
 * 每当有顾客想买X个包子，卖包子的大叔就会迅速选出若干笼包子来，使得这若干笼中恰好一共有X个包子。
 *
 * 比如一共有3种蒸笼，分别能放3、4和5个包子。
 *
 * 当顾客想买11个包子时，大叔就会选2笼3个的再加1笼5个的（也可能选出1笼3个的再加2笼4个的）。
 *
 * 当然有时包子大叔无论如何也凑不出顾客想买的数量。比如一共有3种蒸笼，分别能放4、5和6个包子。
 *
 * 而顾客想买7个包子时，大叔就凑不出来了。
 *
 * 小明想知道一共有多少种数目是包子大叔凑不出来的。
 *
 * 输入
 * ----
 * 第一行包含一个整数N。(1 <= N <= 100)
 * 以下N行每行包含一个整数Ai。(1 <= Ai <= 100)
 *
 * 输出
 * ----
 * 一个整数代表答案。如果凑不出的数目有无限多个，输出INF。
 *
 * 例如，
 * 输入：
 * 2
 * 4
 * 5
 *
 * 程序应该输出：
 * 6
 *
 * 再例如，
 * 输入：
 * 2
 * 4
 * 6
 *
 * 程序应该输出：
 * INF
 *
 * 样例解释：
 * 对于样例1，凑不出的数目包括：1, 2, 3, 6, 7, 11。
 * 对于样例2，所有奇数都凑不出来，所以有无限多个。
 *
 * 资源约定：
 * 峰值内存消耗（含虚拟机） < 256M
 * CPU消耗  < 1000ms
 *
 * 请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。
 * 背包
 * 所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
 * 不要使用package语句。不要使用jdk1.7及以上版本的特性。
 * 主类的名字必须是：Main，否则按无效代码处理。
 * 提交程序时，注意选择所期望的语言类型和编译器类型。
 */
public class Demo8_包子凑数 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        arr[0] = sc.nextInt();
        int g = arr[0];
        for (int i = 1; i < n; i++) {
            arr[i] = sc.nextInt();
            g = gcd(g, arr[i]);
        }

        // System.out.println(g);
         f(arr, g);
    }

    // 求它们的公约数
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static void f(int[] arr, int g) {
        // 若公约数不为1，说明不能承装的数量无限大
        if (g != 1)
            System.out.println("INF");
        else {
            // true: 能够凑出来的数
            boolean[] flag = new boolean[10000];
            // 0个数肯定能凑出来
            flag[0] = true;
            for (int i = 0; i < arr.length; i++) {
                // j + arr[i]：表示j的倍数
                for (int j = 0; j + arr[i] < flag.length; j++) {
                    // 若当前数能凑出来，则j的倍数也能凑出来
                    if (flag[j]) {
                        flag[j + arr[i]] = true;
                    }
                }
            }

            // 统计凑不出来的个数
            int count = 0;
            for (int i = 0; i < flag.length; i++) {
                if (!flag[i])
                    count ++;
            }
            System.out.println(count);
        }
    }
}



















