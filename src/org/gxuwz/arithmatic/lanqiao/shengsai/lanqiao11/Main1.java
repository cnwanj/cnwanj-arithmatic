package org.gxuwz.arithmatic.lanqiao.shengsai.lanqiao11;

/**
 * 试题 A: 门牌制作
 */
public class Main1 {
    // 624
    public static void main(String[] args) {
        int n = 2020, sum = 0;
        for (int i = 1; i <= 1000; i++) {
            for (int j = 0, k = 1; j < String.valueOf(i).length(); j++, k *= 10) {
                int m = i % (k * 10) / k;
                if (m == 2) {
                    sum ++;
                }
            }
        }
        System.out.println(sum);
    }
}
