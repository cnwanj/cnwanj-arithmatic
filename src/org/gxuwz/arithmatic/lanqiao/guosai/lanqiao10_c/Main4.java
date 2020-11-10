package org.gxuwz.arithmatic.lanqiao.guosai.lanqiao10_c;

/**
 * @Author: 韦永恒
 * @Date: 2020-10-28 13:58:13
 * @Description:
 *
 * 标题：寻找有100个约数的最小数
 *
 * 有1个约数的最小数为1（1），有两个约数的最小数为2（1，2）……
 *
 * 有n个约数的最小数为Sn
 *
 * S1=1 （1）
 *
 * S2=2 （1 2）
 *
 * S3=4 （1 2 4）
 *
 * S4=6 （1 2 3 6）
 *
 * s5=8 （1 2 4 6 12）
 *
 * 求S100
 *
 * 答案：45360
 *
 */
public class Main4 {

    public static void main(String[] args) {
        int n = 1, count;
        while(true) {
            count = 0;
            for (int i = 1; i <= n; i++) {
                if (n % i == 0) {
                    count ++;
                    if (count == 100)
                        System.out.print(i);
                }
            }
            n ++;
            if (count == 100) {
                break;
            }
        }
    }
}
