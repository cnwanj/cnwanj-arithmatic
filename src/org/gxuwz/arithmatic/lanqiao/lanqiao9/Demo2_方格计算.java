package org.gxuwz.arithmatic.lanqiao.lanqiao9;

public class Demo2_方格计算 {

    public static void main(String[] args) {
        int n = 1000, count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < n; j++) {
                if (Math.sqrt(i * i + j * j) <= n) {
                    count++;
                }
            }
        }
        System.out.println(count * 4);
    }
}
