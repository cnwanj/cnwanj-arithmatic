package org.gxuwz.arithmatic.lanqiao.lanqiao11_校选;

import java.util.Scanner;

/**
 * @description:
 * @author: 韦永恒
 * @date: 2020-10-16 21:58:17
 *
 * （程序题 20分）已知一个整数序列A=(a0,a1,…，an-1),其中0≤ai<n(0≤i<n)。
 * 若存在ap1=ap2=…=apm=x且m>n/2（0≤pk<n,1≤k≤m）,则称x为A的主元素。
 * 例如A=(0,5,5,3,5,7,5,5),则5为主元素；又如A=(0,5,5,3,5,1,5,7),
 * 则A中没有主元素。假设A中的n个元素保存在一个以为数组中，请设计一个尽可能高效的算法，
 * 找出A的主元素。若存在主元素，则输出该元素；否则输出-1.
 * 输入：
 * 首先输入n（表示A序列中元素的个数），之后依次输入n个A序列中的各个元素。
 * 输出：
 *     A的主元素。若存在主元素，则输出该元素；否则输出-1.
 * 数据样例：
 * 输入：
 * 8
 * 0 5 5 3 5 7 5 5
 *     输出：
 * 5
 */
public class Demo6_主元素 {

    /**
     * 寻找序列中的主元素
     * @param A 序列
     * @param n 序列中的元素个数
     * @return
     */
    public static int calculate(int A[],int n) {
        int i, c, count = 1;            	//c用来保存候选主元素，count用来计数
        c = A[0];                 		//首先假设A[0]为候选主元素
        for (i = 1; i < n; i++)            	//查找候选主元素
            if (A[i] == c)
                count++;            	//依次遍历查找，找到的话个数加一
            else {
                if (count > 0)
                    count --;        	//抵消
                else {
                    c = A[i];
                    count = 1;        //count<0则更改候选主元素
                }
            }
        System.out.println(count);
        if (count > 0) {
            for (i = count = 0; i < n; i++)
                if (A[i] == c)
                    count++;
        }
        if (count > n / 2)
            return c;
        else
            return - 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] A = new int[n];
        //循环获取A的各个元素
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        //计算A的主元素
        int calculate = calculate(A, n);
        System.out.println(calculate);
    }
}
