package org.gxuwz.arithmatic.lanqiao.practise;

/*
 * 对于长度为5位的一个01串，每一位都可能是0或1，一共有32种可能。它们的前几个是：
 * 00000
 * 00001
 * 00010
 * 00011
 * 00100
 * 请按从小到大的顺序输出这32种01串。
 * 输入格式
 * 本试题没有输入。
 * 输出格式
 * 输出32行，按从小到大的顺序每行一个长度为5的01串。
 * 样例输出
 * 00000
 * 00001
 * 00010
 * 00011
 */
public class Demo3 {

    public static void f1(int n) {
        int[] arr = new int[5];
        int b = 0;
        int c = 0;
        for (int i = 0; i < 5; i++) {
            b = n % 2;
            arr[i] = b;
            c = n / 2;
            n = c;
        }
        for (int i = 4; i >= 0; i--) {
            System.out.print(arr[i]);
        }
    }

    public static void f2(int n) {
        int[] arr = new int[5];
        int a = 0;
        int b = 0;
        for (int i = 0; i < 5; i++) {
            a = n % 2;
            arr[i] = a;
            b = n / 2;
            n = b;
        }
        for (int i = 5; i >= 0; i--) {
            System.out.print(arr[i]);
        }
    }

    public static void main(String[] args) {
//        for(int i=0; i<32; i++){
//            f1(i);
//            System.out.println();
//        }


        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

            }
        }
    }
}
