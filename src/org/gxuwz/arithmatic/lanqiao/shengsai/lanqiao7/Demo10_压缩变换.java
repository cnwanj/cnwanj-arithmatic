package org.gxuwz.arithmatic.lanqiao.shengsai.lanqiao7;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 压缩变换
 *
 * 小明最近在研究压缩算法。
 * 他知道，压缩的时候如果能够使得数值很小，就能通过熵编码得到较高的压缩比。
 * 然而，要使数值很小是一个挑战。
 *
 * 最近，小明需要压缩一些正整数的序列，这些序列的特点是，后面出现的数字很大可能是刚出现过不久的数字。
 *
 * 对于这种特殊的序列，小明准备对序列做一个变换来减小数字的值。
 *
 * 变换的过程如下：
 * 从左到右枚举序列，每枚举到一个数字，如果这个数字没有出现过，刚将数字变换成它的相反数，
 *
 * 如果数字出现过，则看它在原序列中最后的一次出现后面（且在当前数前面）出现了几种数字，用这个种类数替换原来的数字。
 *
 * 比如，序列(a1, a2, a3, a4, a5)=(1, 2, 2, 1, 2)在变换过程为：
 * a1: 1未出现过，所以a1变为-1；
 * a2: 2未出现过，所以a2变为-2；
 * a3: 2出现过，最后一次为原序列的a2，在a2后、a3前有0种数字，所以a3变为0；
 * a4: 1出现过，最后一次为原序列的a1，在a1后、a4前有1种数字，所以a4变为1；
 * a5: 2出现过，最后一次为原序列的a3，在a3后、a5前有1种数字，所以a5变为1。
 * 现在，给出原序列，请问，按这种变换规则变换后的序列是什么。
 *
 * 输入格式：
 * 输入第一行包含一个整数n，表示序列的长度。
 * 第二行包含n个正整数，表示输入序列。
 *
 * 输出格式：
 * 输出一行，包含n个数，表示变换后的序列。
 *
 * 例如，输入：
 * 5
 * 1 2 2 1 2
 *
 * 程序应该输出：
 * -1 -2 0 1 1
 *
 * 再例如，输入：
 * 12
 * 1 1 2 3 2 3 1 2 2 2 3 1
 *
 * 程序应该输出：
 * -1 0 -2 -3 1 1 2 2 0 0 2 2
 *
 * 数据规模与约定
 * 对于30%的数据，n<=1000；
 * 对于50%的数据，n<=30000；
 * 对于100%的数据，1 <=n<=100000，1<=ai<=10^9
 *
 * 资源约定：
 * 峰值内存消耗（含虚拟机） < 256M
 * CPU消耗  < 3000ms
 *
 *
 * 请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。
 *
 * 所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
 * 注意：不要使用package语句。不要使用jdk1.7及以上版本的特性。
 * 注意：主类的名字必须是：Main，否则按无效代码处理。
 */
public class Demo10_压缩变换 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // 存放结果集
        int[] res = new int[n];
        // 存放中间有多少种不同的数
        Set<Integer> set = new HashSet<Integer>();

        res[0] = -a[0];
        int p;
        for (int i = 1; i < n; i++) {
            p = i - 1;
            // 遍历原序列中最后一次出现的数
            while (p >= 0) {
                // 若找到最后一次出现的数
                if (a[p] == a[i]) {
                    for (int j = p + 1; j < i; j++) {
                        set.add(a[j]);
                    }
                    res[i] = set.size();
                    // 清除set集合中的数
                    set.clear();
                    break;
                }
                p--;
            }
            if (p == -1) {
                // 若这个数在原序列中没有出现过，直接变负数
                res[i] = -a[i];
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
    }
}

class Main {

    private static int[] arr, arr1;
    private static Set<Integer> set = new HashSet<Integer>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];
        arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            // 复制数组
            arr1[i] = arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            f(i);
        }
        System.out.println(Arrays.toString(arr1));
    }

    static void f(int p) {
        boolean tag = false;
        for (int i = p - 1; i >= 0; i--) {
            if (arr[p] == arr[i]) {
                tag = true;
                if (p - i == 1) {
                    arr1[p] = 0;
                    break;
                }
                for (int j = i + 1; j < p; j++) {
                    set.add(arr[j]);
                }
                arr1[p] = set.size();
                set.clear();
                break;
            }
        }
        if (!tag) {
            arr1[p] = -arr[p];
        }
    }
}
