package org.gxuwz.arithmatic.practice.t1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 6.（程序题 20分）已知一个整数序列A=(a0,a1,…，an-1),其中0≤ai<n(0≤i<n)。
 * 若存在ap1=ap2=…=apm=x且m>n/2（0≤pk<n,1≤k≤m）,则称x为A的主元素。
 * 例如A=(0,5,5,3,5,7,5,5),则5为主元素；又如A=(0,5,5,3,5,1,5,7),则A中没有主元素。
 * 假设A中的n个元素保存在一个以为数组中，请设计一个尽可能高效的算法，找出A的主元素。若存在主元素，则输出该元素；否则输出-1.
 * 输入：
 * 首先输入n（表示A序列中元素的个数），之后依次输入n个A序列中的各个元素。
 * 输出：
 * A的主元素。若存在主元素，则输出该元素；否则输出-1.
 * 数据样例：
 * 输入：
 * 8
 * 0 5 5 3 5 7 5 5
 * 输出：
 * 5
 */
public class Demo6 {

    // 方法2
    static void f1(int[] arr) {
        int count = 0;
        int c = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == c) {
                count++;
            } else {
                if (count > 0) {
                    count--;
                } else {
                    count = 1;
                    c = arr[i];
                }
            }
        }

        int n = 0;
        if (count >= 0) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == c)
                    n++;
            }
        }

        if (n > arr.length / 2) {
            System.out.println(c);
        } else
            System.out.println(-1);
    }

    static void f(int[] arr) {
        String s = "";
        // 初始化数组对象
        Result[] results = new Result[arr.length];
        for (int i = 0; i < results.length; i++) {
            Result re = new Result(0, 0);
            results[i] = re;
        }
        int p = 0;
        for (int i = 0; i < arr.length; i++) {
            if (s.indexOf("" + arr[i]) == -1) {
                s += arr[i];
                Result r = new Result(arr[i], 1);
                results[p] = r;
                p++;
            } else {
                for (int j = 0; j < results.length; j++) {
                    if (results[j].a == arr[i]) {
                        results[j].count++;
                        break;
                    }
                }
            }
        }

        // 对结果集进行排序
        Arrays.sort(results, new Comparator<Result>() {
            @Override
            public int compare(Result r1, Result r2) {
                return r2.count - r1.count;
            }
        });

        if (results[0].count > arr.length / 2)
            System.out.println(results[0].a);
        else
            System.out.println(-1);

//        for (int i = 0; i < p; i++) {
//            System.out.println(results[i].a+"-"+results[i].count);
//        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        f(arr);
    }
}

class Result {
    int a;
    int count;

    public Result(int a, int count) {
        this.a = a;
        this.count = count;
    }
}
