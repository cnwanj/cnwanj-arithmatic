package org.gxuwz.arithmatic.lanqiao.shengsai.lanqiao11_模拟2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 *
 * 【问题描述】将LANQIAO中的字母重新排列，可以得到不同的单词，如LANQIAO、AAILNOQ等，
 * 注意这7个字母都要被用上，单词不一定有具体的英文意义。
 * 请问，总共能排列如多少个不同的单词。
 *
 * 【答案提交】这是一道结果填空的题，你只需要算出结果后提交即可本题的结果为一个整数，
 * 在提交答案时只填写这个整数，填写多余的内容将无法得分。
 *
 * 答案：2520
 *
 * @author: 韦永恒
 * @date: 2020-08-31 17:25:20
 */
public class Demo3_单词重排 {

//    private static int count = 0;
//
//    public static void main(String[] args) {
//        char[] arr = "LANQIAO".toCharArray();
//
//        f(arr, 0);
//        System.out.println(count);
//    }
//
//    public static void f(char[] arr, int p) {
//        // 终止条件，若指针指向数组的最后一位
//        if (p == arr.length - 1) {
//            count ++;
//            System.out.println(arr);
//            return;
//        }
//
//        for (int i = p; i < arr.length; i++) {
//            swap(arr, i, p);
//            f(arr, p + 1);
//            swap(arr, i, p);
//        }
//    }
//
//    static void swap(char[] arr, int i, int p) {
//        char t = arr[i];
//        arr[i] = arr[p];
//        arr[p] = t;
//    }

    private static int count = 0;
    private static Set<String> set = new HashSet<String>();

    public static void main(String[] args) {
        char[] arr = "LANQIAO".toCharArray();
        f(arr, 0);
        System.out.println(count);
        System.out.println(set);
        System.out.println(set.size());
    }

    static void f(char[] arr, int p) {
        if (p == arr.length - 1) {
            String s = "";
            for (int i = 0; i < arr.length; i++) {
                s += arr[i];
            }
            set.add(s);
            System.out.println(Arrays.toString(arr));
            count ++;
            return;
        }

        for (int i = p; i < arr.length; i++) {
            swap(arr, i, p);
            f(arr, 1 + p);
            swap(arr, i, p);
        }
    }

    static void swap(char[] arr, int i, int p) {
        char t = arr[i];
        arr[i] = arr[p];
        arr[p] = t;
    }
}
