package org.gxuwz.arithmatic.interview.meituan;

import java.util.Scanner;

/**
 * 题目描述：
 * A国和B国正在打仗，他们的目的是n块土地。现在，A国和B国暂时休战，为了能合理分配这一些土地，AB国开始协商。
 *
 * A国希望得到这n块土地中的p块土地，B国希望得到这n块土地中的q块土地。每个国家都将自己希望得到的土地编号告诉了小团和小美——两位战争调和人。
 *
 * 你需要帮小团和小美计算，有多少块土地是只有A国想要的，有多少块土地是只有B国想要的，有多少块土地是两个国家都想要的。
 *
 *
 *
 * 输入描述
 * 输入第一行包含三个整数n,p,q，含义如题意所示
 *
 * 接下来一行p个整数，空格隔开，第 i 个整数代表A国需要的土地编号ai
 *
 * 接下来一行q个整数，空格隔开，第 i 个整数代表B国需要的土地编号bi
 *
 * 土地编号从1开始，n结束。
 *
 * p,q≤n≤100000 , 1≤ai,bi≤n , 数据保证所有的ai互相不相同，bi互相不相同。
 *
 * 输出描述
 * 输出包含三个数，只有A国想要的土地数，只有B国想要的土地数，两个国家都想要的土地数。
 *
 *
 * 样例输入
 * 5 3 3
 * 1 2 3
 * 3 4 5
 * 样例输出
 * 2 2 1
 *
 * 提示
 * 1,2号土地只有A想要，4,5号土地只有B想要，3号土地都想要
 * 规则
 * 请尽量在全场考试结束10分钟前调试程序，否则由于密集排队提交，可能查询不到编译结果
 * 点击“调试”亦可保存代码
 * 编程题可以使用本地编译器，此页面不记录跳出次数
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        if (p > n || q > n)
            return;
        sc.nextLine();
        String[] aa = sc.nextLine().split(" ");
        String[] bb = sc.nextLine().split(" ");
        sc.close();
        int[] a = new int[p];
        int[] b = new int[q];
        for (int i = 0; i < p; i++) {
            a[i] = Integer.parseInt(aa[i]);
        }
        for (int i = 0; i < q; i++) {
            b[i] = Integer.parseInt(bb[i]);
        }
        int c1 = 0, c2 = 0, c3 = 0;
        boolean tag = true;
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {
                if (a[i] == b[j]) {
                    c3 ++;
                    tag = false;
                    break;
                }
            }
            if (tag)
                c1 ++;
        }
        c2 = q - c3;
        System.out.println(c1 + " " + c2 + " " + c3);
    }
}
